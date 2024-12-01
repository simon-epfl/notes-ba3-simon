package wires

import ujson.*
import scala.util.{Try, Success, Failure}

/** There was an error during the parsing of a JSON message. */
case class DecodingException(msg: String) extends Exception(f"Error while trying to decode JSON message: $msg.")

/** Encodes an object of type [[T]] to a [[ujson.Value]] */
trait Encoder[T]:
  def encode(t: T): ujson.Value

/** Decodes an object of type [[T]] from a [[ujson.Value]] */
trait Decoder[T]:
  def decode(json: ujson.Value): util.Try[T]

/** Provides a way to decode and encode an object of type [[T]] to [[Value]] */
trait WireFormat[T] extends Encoder[T] with Decoder[T]

def encodeWire[T](t: T)(using wt: WireFormat[T]): ujson.Value =
  wt.encode(t)

def decodeWire[T](js: ujson.Value)(using wt: WireFormat[T]): Try[T] =
  wt.decode(js)

object IdentityWire extends WireFormat[ujson.Value]:
  def encode(t: ujson.Value): Value = t
  def decode(js: Value): Try[ujson.Value] = Success(js)

object OldBooleanWire extends WireFormat[Boolean]:
  def encode(t: Boolean): Value = Bool(t)
  def decode(js: Value): Try[Boolean] = Try(js.bool)

given WireFormat[Boolean] with
  def encode(t: Boolean): Value = Bool(t)
  def decode(js: Value): Try[Boolean] = Try(js.bool)

object StringWire extends WireFormat[String]:
  def encode(t: String): Value = Str(t)
  def decode(js: Value): Try[String] = Try(js.str)

object IntWire extends WireFormat[Int]:
  def encode(t: Int): Value = Num(t)
  def decode(js: Value): Try[Int] = Try(js.num.toInt)

case class OptionWire[T](wt: WireFormat[T]) extends WireFormat[Option[T]]:
  def encode(o: Option[T]): ujson.Value =
    o match
      case None    => Obj()
      case Some(t) => Obj("get" -> wt.encode(t))
  def decode(js: ujson.Value): Try[Option[T]] = Try:
    js.obj.get("get").map(wt.decode(_).get)

case class TryWire[T](wt: WireFormat[T]) extends WireFormat[Try[T]]:
  def encode(t: Try[T]): Value =
    t match
      case Failure(exn) =>
        Obj(
          "type" -> "failure",
          "msg" -> Str(exn.getMessage),
          "stacktrace" -> exn.getStackTrace.mkString("StackTrace(", ", ", ")")
        )
      case Success(t) =>
        Obj("type" -> "success", "get" -> wt.encode(t))

  def decode(json: Value): Try[Try[T]] = Try:
    json("type").str match
      case "failure" =>
        Failure(Exception(json("msg").str))
      case "success" =>
        Success(wt.decode(json("get")).get)
      case _ =>
        throw DecodingException(f"Unexpected try: $json")

case class SeqWire[T](wt: WireFormat[T]) extends WireFormat[Seq[T]]:
  def encode(s: Seq[T]): ujson.Value =
    Arr(s.map(wt.encode)*)
  def decode(js: ujson.Value): Try[Seq[T]] = Try:
    js.arr.map(wt.decode(_).get).toSeq

case class CastWire[T1, T2](w2: WireFormat[T2], enc: T1 => T2, dec: T2 => Try[T1])
    extends WireFormat[T1]:
  def encode(t1: T1): ujson.Value =
    w2.encode(enc(t1))
  def decode(js: ujson.Value): Try[T1] =
    w2.decode(js).flatMap(dec)

class SetWire[T](wt: WireFormat[T])
    extends CastWire[Set[T], Seq[T]](
      SeqWire(wt),
      (s: Set[T]) => s.toSeq,
      (s: Seq[T]) => Success(s.toSet)
    )

case class PairWire[T1, T2](w1: WireFormat[T1], w2: WireFormat[T2])
    extends WireFormat[(T1, T2)]:
  def encode(p: (T1, T2)): ujson.Value =
    Arr(w1.encode(p._1), w2.encode(p._2))
  def decode(js: ujson.Value): Try[(T1, T2)] = Try:
    (w1.decode(js.arr(0)).get, w2.decode(js.arr(1)).get)

class MapWire[K, V](wk: WireFormat[K], wv: WireFormat[V])
    extends CastWire[Map[K, V], Seq[(K, V)]](
      SeqWire(PairWire(wk, wv)),
      (m: Map[K, V]) => m.toSeq,
      (s: Seq[(K, V)]) => Success(s.toMap)
    )
