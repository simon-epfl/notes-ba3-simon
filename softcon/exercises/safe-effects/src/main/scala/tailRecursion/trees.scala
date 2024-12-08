package tailRecursion.trees

import scala.collection.mutable.Stack
enum Tree[T]:
  case Leaf(value: T)
  case Node(left: Tree[T], right: Tree[T])

import Tree.*

def sizeRec(t: Tree[Int]): Int =
  ???

def sizeLoop(t: Tree[Int]): Int =
  ???

def sumRec(t: Tree[Int]): Int =
  t match
    case Leaf(value)       => value
    case Node(left, right) => sumRec(left) + sumRec(right)

def isRightLineTree(t: Tree[Int]): Boolean =
  t match
    case Leaf(_)              => true
    case Node(Leaf(_), right) => isRightLineTree(right)
    case _                    => false

def sumRightLineTree(tr: Tree[Int]): Int =
  require(isRightLineTree(tr))
  var sum = 0
  var currentTree = tr
  while true do
    currentTree match
      case Leaf(value) => return sum + value
      case Node(Leaf(value), right) =>
        sum += value
        currentTree = right
  throw new Exception()

def sumRotate(tr: Tree[Int], acc: Int): Int =
  ???

def sumLoop(t: Tree[Int]): Int =
  ???

def reduce[T](tr: Tree[T], f: (T, T) => T): T =
  tr match
    case Leaf(value)       => value
    case Node(left, right) => f(reduce(left, f), reduce(right, f))

trait MStackTrait[A]:
  def push(a: A): Unit
  def pop(): A
  def isEmpty: Boolean
  def size: Int
  def contains(a: A): Boolean

case class MStack[A](var l: List[A] = Nil) extends MStackTrait[A]:
  def push(a: A): Unit =
    l = l.appended(a)
  def pop(): A =
    l = l.tail
  def isEmpty: Boolean =
    l.isEmpty
  def size: Int =
    l.size
  def contains(a: A): Boolean =
    l.contains(a)

def postOrderTraversal[T](tr: Tree[T]): List[Tree[T]] =
  var toVIsit = MStack[Tree[T]]()
  toVIsit.push(tr)
  var postOrderNodes: List[Tree[T]] = Nil
  while !toVIsit.isEmpty do
    val n = toVIsit.pop()
    postOrderNodes = n :: postOrderNodes
    n match
      case Leaf(value) =>
      case Node(left, right) =>
        toVIsit.push(left)
        toVIsit.push(right)
  postOrderNodes

def reduceLoop[T](tr: Tree[T], f: (T, T) => T): T =
  ???

