package patmat

object FuncContext:
  import EnumContext.LookupResult
  import LookupResult.*

  type Context =
    String => LookupResult

  def empty: Context =
    ???

  def cons(name: String, value: Int, rem: Context): Context =
    ???

  def lookup(ctx: Context, name: String): LookupResult =
    ???

  def erase(ctx: Context, name: String): Context =
    ???
