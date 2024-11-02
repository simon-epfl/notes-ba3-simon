package parallelism

import collection.parallel.CollectionConverters.ImmutableSeqIsParallelizable

object AggregateImpl:

  extension [A](l: Seq[A])
    def aggregate1[B](z: B)(f: (B, A) => B, g: (B, B) => B): B =
      l.par
        .map(f(z, _))
        .reduce(g)

    def aggregate2[B](z: B)(f: (B, A) => B, g: (B, B) => B): B =
      l.foldLeft(z)(f)

    def aggregate3[B](z: B)(f: (B, A) => B, g: (B, B) => B): B =
      if l.length <= 1 then l.foldLeft(z)(f)
      else
        l.grouped(l.length / 2)
          .toSeq
          .par
          .map(s => s.aggregate3(z)(f, g))
          .reduce(g)

    def aggregate4[B](z: B)(f: (B, A) => B, g: (B, B) => B): B =
      if l.length <= 1 then l.foldLeft(z)(f)
      else
        l.grouped(l.length / 2)
          .toSeq
          .par
          .map(s => s.aggregate4(z)(f, g))
          .foldLeft(z)(g)
