package exceptions

extension [T](l: List[T])
  final def containsRec(t0: T): Boolean =
    l match
      case Nil      => false
      case hd :: tl => hd == t0 || tl.containsRec(t0)

extension [T](l: List[T])
  final def containsFold(t0: T): Boolean =
    l.foldRight(false)((hd, found) => found || hd == t0)

extension [T](l: List[T])
  final def containsExn(t0: T): Boolean =
    case object Found extends Exception
    try
      for hd <- l if hd == t0 do throw Found
      false
    catch
      case Found => true

import scala.util.boundary

extension [T](l: List[T])
  final def containsBoundary(t0: T): Boolean =
    boundary:
      for hd <- l if hd == t0 do break(true)
      false

extension [T](l: List[T])
  final def findExn(p: T => Boolean): Option[T] =
    ???

import scala.util.boundary

extension [T](l: List[T])
  final def findBoundary(p: T => Boolean): Option[T] =
    ???
