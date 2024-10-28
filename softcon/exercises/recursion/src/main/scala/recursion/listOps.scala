package recursion

def length(l: IntList): Int =
  l match 
    case IntCons(head, tail) => 1 + length(tail)
    case IntNil() => 0

def allPositiveOrZero(l: IntList): Boolean =
  l match
    case IntCons(head, tail) => head >= 0 && allPositiveOrZero(tail)
    case IntNil() => true

def countPositive(l: IntList): Int =
  l match
    case IntCons(head, tail) if head > 0 => 1 + countPositive(l.tail)
    case IntCons(head, tail) if head <= 0 => countPositive(l.tail)
    case IntNil() => 0

def sum(l: IntList): Int =
  l match
    case IntCons(head, tail) => head + sum(l.tail)
    case IntNil() => 0

def product(l: IntList): Int =
  l match
    case IntCons(head, tail) => head * product(l.tail)
    case IntNil() => 1

def anyOdd(l: IntList): Boolean =
  l match
    case IntCons(head, tail) if head % 2 == 0 => anyOdd(tail)
    case IntCons(head, tail) => true
    case IntNil() => false

def decrement(l: IntList): IntList =
  l match
    case IntCons(head, tail) => IntCons(head - 1, decrement(tail))
    case IntNil() => IntNil()

def collectEven(l: IntList): IntList =
  l match
    case IntCons(head, tail) if head % 2 == 0 => IntCons(head, collectEven(tail))
    case IntCons(head, tail) => collectEven(tail)
    case IntNil() => IntNil()
  
def min(l: IntList): Int =
  l match
    case IntNil() => throw new Exception("can not compute min")
    case IntCons(head, IntNil()) => head
    case IntCons(head, tail) => if head > tail.head then min(tail) else min(IntCons(head, tail.tail))

def increment(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) => IntCons(head + 1, increment(tail))

def subtract(l: IntList): Int =
  ???

def removeOdd(l: IntList): IntList =
  l match
    case IntNil() => IntNil()
    case IntCons(head, tail) => if head % 2 == 0 then IntCons(head, removeOdd(tail)) else removeOdd(tail)

def countEven(l: IntList): Int =
  ???

/** `countEven` using `collectEven` and `length` */
def countEven2(l: IntList): Int =
  ???

def multiplyBy2(l: IntList): IntList =
  ???

def anyNegative(l: IntList): Boolean =
  ???

def allEven(l: IntList): Boolean =
  ???

def multiplyOdd(l: IntList): Int =
  ???

def horner(x: Int, l: IntList): Int =
  if l.isEmpty then 0 else l.head + x * horner(x, l.tail)

def capAtZero(l: IntList): IntList =
  ???

def removeZeroes(l: IntList): IntList =
  ???

def reverseAppend(l1: IntList, l2: IntList): IntList =
  (l1, l2) match
    case (IntNil(), l) => l
    case (IntCons(head, tail), l) => reverseAppend(l1.tail, IntCons(l1.head, l2))

def reverse(l: IntList): IntList =
  reverseAppend(l, IntNil())

def takeWhilePositive(l: IntList): IntList =
  ???

def append(l1: IntList, l2: IntList): IntList =
  ???

def collectMultiples(d: Int, l: IntList): IntList =
  ???

def last(l: IntList): Int =
  ???

def init(l: IntList): IntList =
  ???

def contains(l: IntList, n: Int): Boolean =
  ???

def isSubset(l: IntList, L: IntList): Boolean =
  ???

def intersection(l: IntList, L: IntList): IntList =
  ???

def difference(l: IntList, L: IntList): IntList =
  ???

def minMax(l: IntList): (Int, Int) =
  def minMaxHelper (l: IntList, currentMin: Int, currentMax: Int): (Int, Int) =
    l match
      case IntCons(head, tail) =>
        if head > currentMax then minMaxHelper(tail, currentMin, head)
        else if head < currentMin then minMaxHelper(tail, head, currentMax)
        else minMaxHelper(tail, currentMin, currentMax)
      case IntNil() => (currentMin, currentMax)

  if l.isEmpty then throw new Exception() else minMaxHelper(l, l.head, l.head)
  

val Add = -1
val Multiply = -2

def polishEval(l: IntList): (Int, IntList) =
  l match
    case IntCons(head, tail) =>
      val (resLeft, remainingRight) = polishEval(tail)
      val (resRight, remainingRemainingRight) = polishEval(remainingRight)
      if head == Add then
        (resLeft + resRight, remainingRemainingRight)
      else if head == Multiply then
        (resLeft * resRight, remainingRemainingRight)
      else (head, tail)
    case IntNil() => (0, IntNil())
