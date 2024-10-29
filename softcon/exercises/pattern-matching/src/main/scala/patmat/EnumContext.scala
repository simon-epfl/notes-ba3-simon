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

  def empty: Context = Context.Empty

  def cons(name: String, value: Int, rem: Context) =
    Context.Cons(name, value, rem)

  def lookup(ctx: Context, name: String): LookupResult =
    ctx match
      case Empty => NotFound
      case Cons(cName, value, tail) if cName == name => Ok(value)
      case Cons(cName, value, tail) => lookup(tail, name)

  def erase(ctx: Context, name: String): Context =
    ctx match
      case Empty => ctx
      case Cons(cName, value, tail) if cName == name => erase(tail, name)
      case Cons(cName, value, tail) => Cons(cName, value, erase(tail, name))

  def filter(ctx: Context, pred: (String, Int) => Boolean): Context =
    ctx match
      case Empty => ctx
      case Cons(cName, value, tail) if !pred(cName, value) => tail
      case Cons(cName, value, tail) => Cons(cName, value, filter(tail, pred))
