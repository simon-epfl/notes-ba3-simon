package parallelism

import scala.reflect.ClassTag
import parallelism.FoldReduce.reducePar

class ParWorker[T](t: => T) extends Thread:
  private var result: Option[T] = None
  override def run: Unit = result = Some(t)
  def get = result.get

/** Run `a` and `b` in parallel */
def par2[A, B](a: => A, b: => B): (A, B) =
  val wa = ParWorker(a); val wb = ParWorker(b)
  wa.start(); wb.start()
  wa.join(); wb.join()
  (wa.get, wb.get)

/** Run `f(0)` … `f(n-1)` in parallel */
def parN(n: Int)(f: Int => Unit): Unit =
  require(n >= 0)
  // For the purpose of this exercise, we assume that creating and manipulating
  // this collection of threads is instantaneous.
  val threads = (0 until n).map(i => ParWorker(f(i)))
  threads.foreach(_.start())
  threads.foreach(_.join())

object ParMap:
  extension [A](self: Vector[A])
    def map_vector[B](f: A => B): Vector[B] = self match
      case Vector()  => Vector()
      case Vector(x) => Vector(f(x))
      case _ =>
        val (la, ra) = self.splitAt(self.size / 2)
        val (lb, rb) = par2(la.map_vector(f), ra.map_vector(f))
        lb ++ rb

  extension [A](src: Array[A])
    def map_array_par2[B](f: A => B)(dst: Array[B]) =
      require(dst.length == src.length)

      def rec(from: Int, until: Int): Unit =
        require(0 <= from && from <= until && until <= src.length)
        if until == from then
          ()
        else if until == from + 1 then
          dst(from) = f(src(from))
        else
          val mid = from + (until - from) / 2
          par2(rec(from, mid), rec(mid, until))

      rec(0, src.length)
      dst

  extension [A](src: Array[A])
    def map_array_parN[B](f: A => B)(dst: Array[B]) =
      require(dst.length == src.length)
      parN(src.length)(i => dst(i) = f(src(i)))
      dst

  extension [A](ls: List[A])
    def map_list[B](f: A => B): List[B] = ls match
      case Nil => Nil
      case ha :: ta =>
        val (hb, tb) = par2(f(ha), ta.map_list(f))
        hb :: tb

object ParSum:
  extension (self: Vector[Int])
    def sum_vector: Int = self match
      case Vector()  => 0
      case Vector(x) => x
      case _ =>
        val (l, r) = self.splitAt(self.size / 2)
        val (sl, sr) = par2(l.sum_vector, r.sum_vector)
        sl + sr

  extension (self: Array[Int])
    def sum_array: Int =
      def sum_range(from: Int, until: Int): Int =
        require(0 <= from && from <= until && until <= self.length)
        if until == from then 0
        else if until == from + 1 then self(from)
        else
          val mid = from + (until - from) / 2
          val (sl, sr) = par2(sum_range(from, mid), sum_range(mid, until))
          sl + sr
      sum_range(0, self.length)

object ParMatMul:
  case class Matrix(rows: Array[Array[Int]], nR: Int, nC: Int):
    require(rows.length == nR && rows.forall(_.length == nC))
    override def toString =
      rows.map(_.map(_.toString).mkString(" ")).mkString(";\n")
  object Matrix:
    def apply(nR: Int, nC: Int): Matrix =
      Matrix(Array.ofDim[Int](nR, nC), nR, nC)

  def matmul(m1: Matrix, m2: Matrix): Matrix =
    require(m1.nC == m2.nR)
    val mul = Matrix(m1.nR, m2.nC)
    parN(mul.nR): r =>
      parN(mul.nC): c =>
        (0 to m1.nC).foreach: i =>
          mul.rows(r)(c) += m1.rows(r)(i) * m2.rows(i)(c)
    mul

object ParCumSum:
  def cumsum_sequential(v: Vector[Int]): Vector[Int] =
    ???

  enum SumTree:
    case Empty
    case Leaf(n: Int)
    case Branch(_sum: Int, left: SumTree, rright: SumTree)

    def sum = this match
      case Empty              => 0
      case Leaf(n)            => n
      case Branch(_sum, _, _) => _sum

  import SumTree.*
  def mkSumTree(v: Vector[Int]): SumTree = v match
    case Vector()  => Empty
    case Vector(x) => Leaf(x)
    case _         =>
      ???

  def cumsum_sumtree(st: SumTree, leftSum: Int = 0): Vector[Int] = st match
    case Empty           => Vector()
    case Leaf(s)         => Vector(leftSum + s)
    case Branch(s, l, r) =>
      ???

  def cumsum_par2(v: Vector[Int]): Vector[Int] =
    cumsum_sumtree(mkSumTree(v))
