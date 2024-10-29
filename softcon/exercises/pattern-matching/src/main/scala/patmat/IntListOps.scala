package patmat

import IntList.*
import IntIntList.*

def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  ???

def zip(l1: IntList, l2: IntList): IntIntList =
  ???

def unzip(l: IntIntList): (IntList, IntList) =
  ???

def map2to1(op: (Int, Int) => Int)(l: IntIntList): IntList =
  ???

def zipThenWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
  ???

def movingWindow(l: IntList): IntIntList =
  ???

enum ExtractResult:
  case SecondElem(i: Int)
  case NotLongEnough
  case EmptyList
import ExtractResult.*

def extractSecond(l: IntList): ExtractResult =
  ???

