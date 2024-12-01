package contextual

object Orderings:

  def sign(v: Int): Int =
    if v < 0 then -1 else if v > 0 then 1 else 0

  // Laws for Ordering:

  def inverse[T](x: T, y: T)(using ord: Ordering[T]): Boolean =
    sign(ord.compare(x, y)) == -sign(ord.compare(y, x))

  def transitive[T](x: T, y: T, z: T)(using ord: Ordering[T]): Boolean =
    !(ord.compare(x, y) > 0 && ord.compare(y, z) > 0) || ord.compare(x, z) > 0

  def consistent[T](x: T, y: T, z: T)(using ord: Ordering[T]): Boolean =
    ord.compare(x, y) != 0 || sign(ord.compare(x, z)) == sign(ord.compare(y, z))

  // TODO: you should modify this signature according to the requirements
  given pairOrdering[A, B]: Ordering[(A, B)] with
    def compare(x: (A, B), y: (A, B)): Int = ???

  case class Student(name: String, year: Int)

  given studentOrdering1: Ordering[Student] with
    def compare(x: Student, y: Student): Int =
      val cmp1 = x.year.compare(y.year)
      if cmp1 != 0 then cmp1 else x.name.compare(y.name)

  def orderingBy[A, B](f: A => B)(using ord: Ordering[B]): Ordering[A] =
    ???

  given studentOrdering2: Ordering[Student] = orderingBy((s: Student) => (s.year, s.name))
