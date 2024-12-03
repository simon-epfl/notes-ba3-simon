package tailRecursion.lists

import scala.annotation.tailrec

def groupByForeach[T, S](f: T => S)(xs: List[T]): Map[S, List[T]] =
    ???

def groupByFoldRight[T, S](f: T => S)(xs: List[T]): Map[S, List[T]] =
    ???
