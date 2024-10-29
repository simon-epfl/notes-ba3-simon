package patmat

import UnaryNat.*

object UnaryNatOps:
  def fromInt(n: Int): UnaryNat =
    n match
      case 0 => Zero
      case _ => Succ(fromInt(n - 1))

  def toInt(n: UnaryNat): Int =
    ???

  def add(n: UnaryNat, m: UnaryNat): UnaryNat =
    ???

  def multiply(n: UnaryNat, m: UnaryNat): UnaryNat =
    m match
      case Zero => n
      case Succ(m0) => add(n, multiply(n, m0))

  def minus(n: UnaryNat, m: UnaryNat): UnaryNat =
    ???

  def isEven(n: UnaryNat): Boolean =
    ???

  def isOdd(n: UnaryNat): Boolean =
    ???

