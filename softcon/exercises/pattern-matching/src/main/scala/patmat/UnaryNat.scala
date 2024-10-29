package patmat

enum UnaryNat:
  case Zero
  case Succ(pred: UnaryNat)

  def isZero: Boolean = this match
    case Zero    => true
    case Succ(_) => false

  def prev: UnaryNat = this match
    case Zero     => Zero
    case Succ(n0) => n0
