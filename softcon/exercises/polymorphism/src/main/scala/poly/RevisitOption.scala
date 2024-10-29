package poly

import scala.collection.immutable.List
import cs214.TODO

def findFirstEvenNumber(l: List[Int]): Option[Int] =
  l match
    case head :: next => if head % 2 == 0 then Some(head) else findFirstEvenNumber(next)
    case Nil => None

def parseStringToInt(s: String): Option[Int] =
  s.toIntOption

def findSquareRoot(n: Int): Option[Double] =
  if n >= 0 then Some(Math.sqrt(n)) else None

def findSquareRootFromString(s: String): Option[Double] =
  parseStringToInt(s).flatMap(findSquareRoot)

val numberStrings = List("1", "2", "star", "4")

val numbers = numberStrings.flatMap(parseStringToInt)
