package patmat

object EnumContext:
  enum LookupResult:
    case Ok(v: Int)
    case NotFound

  import LookupResult.*
  enum Context:
    case Empty
    case Cons(name: String, value: Int, tail: Context)

  import Context.*

  def empty: Context =
    ???

  def cons(name: String, value: Int, rem: Context) =
    ???

  def lookup(ctx: Context, name: String): LookupResult =
    ???

  def erase(ctx: Context, name: String): Context =
    ???

  def filter(ctx: Context, pred: (String, Int) => Boolean): Context =
    ???
