package patmat

object FuncContext:
  import EnumContext.LookupResult
  import LookupResult.*

  type Context =
    String => LookupResult

  def empty: Context = (x: String) => NotFound

  def cons(name: String, value: Int, rem: Context): Context =
    (x: String) => if name == x then Ok(value) else rem(x)

  def lookup(ctx: Context, name: String): LookupResult = ctx(name)

  def erase(ctx: Context, name: String): Context =
    (x: String) => if name == x then NotFound else ctx(x)
