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
    ???

import scala.util.boundary

extension [T](l: List[T])
  final def containsBoundary(t0: T): Boolean =
    ???

extension [T](l: List[T])
  final def findExn(p: T => Boolean): Option[T] =
    ???

import scala.util.boundary

extension [T](l: List[T])
  final def findBoundary(p: T => Boolean): Option[T] =
    ???
