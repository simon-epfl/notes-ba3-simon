package patmat

enum IntList:
  case IntNil
  case IntCons(x: Int, xs: IntList)

  def isEmpty: Boolean = this match
    case IntNil              => true
    case IntCons(head, tail) => false

  def head: Int = this match
    case IntCons(x, _) => x
    case _             => throw RuntimeException("head of empty")

  def tail: IntList = this match
    case IntCons(_, xs) => xs
    case _              => throw RuntimeException("tail of empty")

enum IntIntList:
  case IntIntNil
  case IntIntCons(xy: (Int, Int), xs: IntIntList)
import IntIntList.*

import IntList.*

def reduceIf(f: (Int, Int) => Int)(l: IntList): Int =
  if l.isEmpty then throw IllegalArgumentException("Empty list!")
  else if l.tail.isEmpty then l.head
  else f(l.head, reduceIf(f)(l.tail))

def reduceMatch(f: (Int, Int) => Int)(l: IntList): Int =
  l match
    case IntNil              => throw IllegalArgumentException("Empty list!")
    case IntCons(hd, IntNil) => hd
    case IntCons(hd, tl)     => f(hd, reduceMatch(f)(tl))

def constructDestruct =
  IntCons(1, IntCons(2, IntNil)) match
    case IntCons(a, IntCons(b, IntNil)) =>
      println(f"Found $a and $b")
    case _ => throw Exception("Not possible!")
