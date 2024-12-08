package tailRecursion.lists

import scala.annotation.tailrec

@tailrec
def reverseAppend(l1: List[Int], l2: List[Int]): List[Int] =
  if l1.isEmpty then l2
  else reverseAppend(l1.tail, l1.head :: l2)

def reverseAppendLoop(l1: List[Int], l2: List[Int]): List[Int] =
  var lTmp = l1
  var finalListTmp = l2
  while true do
    if lTmp.isEmpty then return finalListTmp
    else
      finalListTmp = lTmp.head :: finalListTmp
      lTmp = lTmp.tail

  throw new Exception("unreachable")

@tailrec
def sum(l: List[Int], acc: Int = 0): Int =
  if l.isEmpty then acc
  else sum(l.tail, acc + l.head)

def sumLoop(l: List[Int]): Int =
  var lTmp = l
  var acc = 0
  while true do
    if lTmp.isEmpty then return acc
    else
      acc = lTmp.head + acc
      lTmp = lTmp.tail
  throw new Exception("unreachable")

@tailrec
def foldLeft(l: List[Int], acc: Int)(f: (Int, Int) => Int): Int =
  if l.isEmpty then acc
  else foldLeft(l.tail, f(acc, l.head))(f)

def foldLeftLoop(l: List[Int], startValue: Int)(f: (Int, Int) => Int): Int =
  var acc = startValue
  var lTmp = l
  while true do
    if lTmp.isEmpty then return acc
    else
      acc = f(acc, lTmp.head)
      lTmp = lTmp.tail
  throw new Exception("unreachable")

extension [T](l: List[T])
  def foldt(z: T)(op: (T, T) => T): T =
    ???

extension [T](l: List[T])
  def pairs(op: (T, T) => T): List[T] =
    // Optional exercise: write it with a `while` loop!

    l match
      case a :: b :: tl => op(a, b) :: tl.pairs(op)
      case _            => l

def map(l: List[Int], f: Int => Int): List[Int] =
  if l.isEmpty then Nil
  else f(l.head) :: map(l.tail, f)

object MapContext:
  enum MutableList:
    case Nil
    case Cons(val hd: Int, var tail: MutableList)

  import MutableList.*

  def mapTR(l: MutableList, f: Int => Int): MutableList =
    l match
      case Nil => Nil
      case Cons(hd, tl) =>
        val acc: Cons = Cons(f(hd), Nil)
        mapTRWorker(tl, f, acc)
        acc

  // @tailrec uncomment when working on the exercise
  def mapTRWorker(
      l: MutableList,
      f: Int => Int,
      acc: MutableList.Cons
  ): Unit = // au début on a acc qui vaut Cons(f(1), Nil) puis acc = Cons(f(1), Cons(f(2), Nil)), etc.
    l match
      case Nil => acc
      case Cons(hd, tail) =>
        acc.tail = Cons(f(hd), Nil)
        mapTRWorker(tail, f, acc.tail.asInstanceOf[Cons])
