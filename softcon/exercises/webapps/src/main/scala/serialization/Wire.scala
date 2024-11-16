package serialization

import scala.util.{Try, Success, Failure}

trait Wire[T]:
  def serialize(t: T): ujson.Value
  def deserialize(js: ujson.Value): Try[T]

object IntStringWire extends Wire[(Int, String)]:
  def serialize(t: (Int, String)): ujson.Value =
    ujson.Arr(
      ujson.Num(t._1),
      ujson.Str(t._2)
    )

  def deserialize(js: ujson.Value): Try[(Int, String)] =
    Try {
      val arr = js.arr // .arr throws an exception if the input isn't an array
      val (fst, snd) = (arr(0).num, arr(1).str)
      if !fst.isValidInt then
        throw IllegalArgumentException(f"Not an int: $fst")
      (fst.toInt, snd)
    }

case class OptionWire[T](w: Wire[T]) extends Wire[Option[T]]:
  def serialize(t: Option[T]): ujson.Value =
    t match
      case None =>
        ujson.Arr(ujson.Str("none"))
      case Some(t) =>
        ujson.Arr(ujson.Str("some"), w.serialize(t))

  def deserialize(js: ujson.Value): Try[Option[T]] =
    Try {
      val arr = js.arr
      val tag = arr(0).str
      if arr.size == 1 && arr(0).str == "none" then
        None
      else if arr.size == 2 && arr(0).str == "some" then
        Some(w.deserialize(arr(1)).get)
      else
        throw IllegalArgumentException(f"Unexpected: ${arr.toList}")
    }

enum Formula:
  case Lit(b: Boolean)
  case Var(name: String)
  case FnCall(fn: String, args: List[Formula])

object FormulaWire extends Wire[Formula]:
  import Formula.*

  def serialize(e: Formula): ujson.Value =
    ???

  def deserialize(js: ujson.Value): Try[Formula] =
    ???

