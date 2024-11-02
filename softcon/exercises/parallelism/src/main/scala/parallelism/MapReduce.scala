package parallelism

import scala.collection.parallel.CollectionConverters.*

extension [A](seq: Seq[A])
  def parMap[B](f: A => B): Seq[B] =
    ???

