package parallelism

import scala.reflect.ClassTag
import scala.collection.parallel.mutable.ParArray
import scala.collection.parallel.CollectionConverters.*

extension (a: Array.type)
  def seqTabulate[A: ClassTag](n: Int)(f: Int => A): Array[A] =
    (0 to n).map(f).toArray

extension (p: ParArray.type) {
  def parTabulate[A: ClassTag](n: Int)(f: Int => A): ParArray[A] =
    if n < 10 then Array.seqTabulate(n)(f).par
    else
      val List(left, right) = Vector(n/2, n/2).par.map(v => ParArray.parTabulate(v)(f)).toList
      left ++ right
}

extension [A](seq: Array[A])
  def zipWith[B, C: ClassTag](f: (A, B) => C)(other: Array[B]): Array[C] =
    ParArray.parTabulate(math.min(seq.length, other.length))(i => f(seq(i), other(i))).toArray

def vectorAdd(a: Array[Int], b: Array[Int]) =
  a.zipWith((l: Int, r: Int) => l + r)(b)
