package patmat

import IntTree.*

object IntTreeOps:
  def treeMap(tree: IntTree, op: Int => Int): IntTree =
    tree match
      case Leaf(value) => Leaf(op(value))
      case Branch(left, right) => Branch(treeMap(left, op), treeMap(right, op))

  def treeReduce(tree: IntTree, op: (Int, Int) => Int): Int =
    tree match
      case Leaf(value) => value
      case Branch(left, right) => op(treeReduce(left, op), treeReduce(right, op))

  def treeMapReduce(tree: IntTree, mapper: Int => String, reducer: (String, String) => String): String =
    tree match
      case Leaf(value) => mapper(value)
      case Branch(left, right) => reducer(treeMapReduce(left, mapper, reducer), treeMapReduce(right, mapper, reducer))

  def treeMapReduceDouble(tree: IntTree, mapper: Int => Double, reducer: (Double, Double) => Double): Double =
    tree match
      case Leaf(value) => mapper(value)
      case Branch(left, right) => reducer(treeMapReduceDouble(left, mapper, reducer), treeMapReduceDouble(right, mapper, reducer))
