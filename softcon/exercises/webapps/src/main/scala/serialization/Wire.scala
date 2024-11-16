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
    e match
      case Lit(b) => ujson.Arr("lit", ujson.Bool(b))
      case FnCall(fn, args) => ujson.Arr("fncall", ujson.Str(fn), ujson.Arr(args.map(a => serialize(a))))
      case Var(name) => ujson.Arr("var", ujson.Str(name))

  def deserialize(js: ujson.Value): Try[Formula] =
    def loop(js: ujson.Value): Formula =
      val arr = js.arr
      val tag = arr(0).str
      if tag == "lit" then
        val value = arr(1)
        Lit(value.bool)
      else if tag == "fncall" then
        val value = arr(1)
        FnCall(value.str, value.arr.toList.map(loop))
      else if tag == "var" then
        val value = arr(1)
        Var(value.str)
      else throw new Exception()
    Try(loop(js))

