package patmat

import UnaryNat.*

object UnaryNatOps:
  def fromInt(n: Int): UnaryNat =
    n match
      case 0 => Zero
      case _ => Succ(fromInt(n - 1))

  def toInt(n: UnaryNat): Int =
    n match
      case Zero => 0
      case Succ(pred) => 1 + toInt(pred)

  def add(n: UnaryNat, m: UnaryNat): UnaryNat =
    n match
      case Zero => m
      case Succ(pred) => add(pred, Succ(m))

  def multiply(n: UnaryNat, m: UnaryNat): UnaryNat =
    m match
      case Zero => Zero
      case Succ(m0) => add(n, multiply(n, m0))

  def minus(n: UnaryNat, m: UnaryNat): UnaryNat =
    (n, m) match
      case (_, Zero) => n
      case (Zero, _) => Zero
      case (Succ(pred), Succ(pred2)) => minus(pred, pred2)  

  def isEven(n: UnaryNat): Boolean =
    n match
      case Zero => true
      case Succ(Zero) => false
      case Succ(Succ(pred)) => isEven(pred)

  def isOdd(n: UnaryNat): Boolean =
    n match
      case Zero => false
      case Succ(Zero) => true
      case Succ(Succ(pred)) => isOdd(pred)

