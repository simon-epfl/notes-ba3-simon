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
  ???

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
    ???
  def pop(): A =
    ???
  def isEmpty: Boolean =
    ???
  def size: Int =
    ???
  def contains(a: A): Boolean =
    ???

def postOrderTraversal[T](tr: Tree[T]): List[Tree[T]] =
  ???

def reduceLoop[T](tr: Tree[T], f: (T, T) => T): T =
  ???

