package parallelism

import collection.parallel.CollectionConverters.IterableIsParallelizable
import parallelism.common.Task.task

object FoldReduce:

  extension [A](l: List[A])
    def reduceWithFold(op: (A, A) => A): A =
      l.tail.foldLeft(l.head)(op)

  extension [A](l: List[A])
    def reducePar(op: (A, A) => A): A =
      l match
        case head :: Nil => head
        case head :: next =>
          val (left, right) = l.splitAt(l.length / 2)
          val List(leftV, rightV) = List(left, right).par.map(_.reducePar(op)).toList
          op(leftV, rightV)
        case Nil => throw new Exception()


  extension [A](l: List[A])
    def aggregate[B](z: B)(seqop: (B, A) => B, combop: (B, B) => B): B =
      ???
