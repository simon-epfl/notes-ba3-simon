package contextual

import Orderings.Student
import org.scalacheck.*
import Gen.*
import Arbitrary.arbitrary
import Prop.forAll

object OrderingsTest extends Properties("Orderings"):

  property("pair ordering - inverse") = forAll: (x: (Int, Int), y: (Int, Int)) =>
    Orderings.inverse(x, y)(using Orderings.pairOrdering)

  property("pair ordering - transitive") = forAll: (x: (Int, Int), y: (Int, Int), z: (Int, Int)) =>
    Orderings.transitive(x, y, z)(using Orderings.pairOrdering)

  property("pair ordering - consistent") = forAll: (x: (Int, Int), y: (Int, Int), z: (Int, Int)) =>
    Orderings.consistent(x, y, z)(using Orderings.pairOrdering)

  property("pair ordering - same behaviour as the build-in ordering for pair") = forAll: (l: List[(Int, String)]) =>
    l.sorted(using Orderings.pairOrdering) == l.sorted

  given Arbitrary[Student] = Arbitrary {
    for
      name <- arbitrary[String]
      year <- arbitrary[Int]
    yield Student(name, year)
  }

  property("student ordering - inverse") = forAll: (x: Student, y: Student) =>
    Orderings.inverse(x, y)(using Orderings.studentOrdering1)

  property("student ordering - transitive") = forAll: (x: Student, y: Student, z: Student) =>
    Orderings.transitive(x, y, z)(using Orderings.studentOrdering1)

  property("student ordering - consistent") = forAll: (x: Student, y: Student, z: Student) =>
    Orderings.consistent(x, y, z)(using Orderings.studentOrdering1)

  property("student ordering - same behaviour as the build-in ordering for (Int, String)") =
    forAll: (l: List[Student]) =>
      l.sorted(using Orderings.studentOrdering1) == l.sortBy(s => (s.year, s.name))

  property("student ordering - same behaviour using orderingBy") = forAll: (x: Student, y: Student) =>
    Orderings.sign(Orderings.studentOrdering1.compare(x, y))
      == Orderings.sign(Orderings.studentOrdering2.compare(x, y))
