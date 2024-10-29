package patmat

import IntList.*
import IntIntList.*

def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  (l1, l2) match
    case (IntNil, _) => IntNil
    case (_, IntNil) => IntNil
    case (l1, l2) => IntCons(op(l1.head, l2.head), zipWith(l1.tail, l2.tail, op))

def zip(l1: IntList, l2: IntList): IntIntList =
  (l1, l2) match
    case (IntNil, _) => IntIntNil
    case (_, IntNil) => IntIntNil
    case(l1, l2) => IntIntCons((l1.head, l2.head), zip(l1.tail, l2.tail))

def unzip(l: IntIntList): (IntList, IntList) =
  l match
    case IntIntNil => (IntNil, IntNil)
    case IntIntCons(xy, xs) => (IntCons(xy._1, unzip(xs)._1), IntCons(xy._2, unzip(xs)._2) )

def map2to1(op: (Int, Int) => Int)(l: IntIntList): IntList =
  l match
    case IntIntNil => IntNil
    case IntIntCons(xy, xs) => IntCons(op(xy._1, xy._2), map2to1(op)(l))

def zipThenWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  zipWith(l1, l2, op)

def movingWindow(l: IntList): IntIntList =
  l match
    case IntNil => IntIntNil
    case IntCons(x, xs) => zip(l, xs)

enum ExtractResult:
  case SecondElem(i: Int)
  case NotLongEnough
  case EmptyList
import ExtractResult.*

def extractSecond(l: IntList): ExtractResult =
  l match
    case IntNil => EmptyList
    case IntCons(x, IntNil) => NotLongEnough
    case IntCons(x, xs) => SecondElem(xs.head)
