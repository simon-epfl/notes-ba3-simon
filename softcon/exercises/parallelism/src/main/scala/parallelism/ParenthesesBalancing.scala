package parallelism

import scala.collection.parallel.CollectionConverters.*
import scala.collection.parallel.mutable.ParArray

object ParenthesesBalancing:
  def isBalancedRecursive(str: List[Char]): Boolean =
    ???

  def isBalancedFold(str: List[Char]): Boolean =
    ???

  def isBalancedParSimple(str: List[Char]): Boolean =
    val foldingFunction: (Int, Char) => Int = ??? // your folding function

    val numOpen = str.par.aggregate(0)(foldingFunction, _ + _)

    (numOpen == 0)

  def isBalancedPar(str: List[Char]): Boolean =
    val seqOp: (Any, Char) => Any = ???
    val combOp: (Any, Any) => Any = ???

    str.par.aggregate(???)(seqOp, combOp) == ???
