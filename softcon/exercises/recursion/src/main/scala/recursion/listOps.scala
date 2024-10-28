package recursion

def length(l: IntList): Int =
  l match 
    case IntCons(head, tail) => 1 + length(tail)
    case IntNil => 0

def allPositiveOrZero(l: IntList): Boolean =
  ???

def countPositive(l: IntList): Int =
  ???

def sum(l: IntList): Int =
  ???

def product(l: IntList): Int =
  ???

def anyOdd(l: IntList): Boolean =
  ???

def decrement(l: IntList): IntList =
  ???

def collectEven(l: IntList): IntList =
  ???

def min(l: IntList): Int =
  ???

def increment(l: IntList): IntList =
  ???

def subtract(l: IntList): Int =
  ???

def removeOdd(l: IntList): IntList =
  ???

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
  ???

def capAtZero(l: IntList): IntList =
  ???

def removeZeroes(l: IntList): IntList =
  ???

def reverseAppend(l1: IntList, l2: IntList): IntList =
  ???

def reverse(l: IntList): IntList =
  ???

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
  ???

val Add = -1
val Multiply = -2

def polishEval(l: IntList): (Int, IntList) =
  ???
