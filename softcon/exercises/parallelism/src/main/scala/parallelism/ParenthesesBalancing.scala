package parallelism

import scala.collection.parallel.CollectionConverters.*
import scala.collection.parallel.mutable.ParArray

object ParenthesesBalancing:
  def isBalancedRecursive(str: List[Char]): Boolean =
    def isBalancedRecursiveHelper(str: List[Char], count: Int): Boolean =
      str match
        case head :: next => isBalancedRecursiveHelper(next, if head == '(' then count + 1 else if head == ')' then count - 1 else count)
        case Nil => count == 0

    isBalancedRecursiveHelper(str, 0)

  def isBalancedFold(str: List[Char]): Boolean =
    str.foldLeft(0)((acc, el) => acc + (if el == '(' then 1 else if el == ')' then -1 else 0)) == 0

  def isBalancedParSimple(str: List[Char]): Boolean =
    val foldingFunction: (Int, Char) => Int = ??? // your folding function

    val numOpen = str.par.aggregate(0)(foldingFunction, _ + _)

    (numOpen == 0)

  def isBalancedPar(str: List[Char]): Boolean =
    val seqOp: (Int, Char) => Int = (base, el) => base + (if el == '(' then 1 else if el == ')' then -1 else 0)
    val combOp: (Int, Int) => Int = (x, y) => x + y

    str.par.aggregate(0)(seqOp, combOp) == 0
