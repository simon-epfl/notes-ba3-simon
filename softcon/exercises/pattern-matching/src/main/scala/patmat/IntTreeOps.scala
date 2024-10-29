package patmat

import IntTree.*

object IntTreeOps:
  def treeMap(tree: IntTree, op: Int => Int): IntTree =
    ???

  def treeReduce(tree: IntTree, op: (Int, Int) => Int): Int =
    ???

  def treeMapReduce(tree: IntTree, mapper: Int => String, reducer: (String, String) => String): String =
    ???

  def treeMapReduceDouble(tree: IntTree, mapper: Int => Double, reducer: (Double, Double) => Double): Double =
    ???
