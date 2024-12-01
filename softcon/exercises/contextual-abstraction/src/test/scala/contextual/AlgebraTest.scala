package contextual

import Algebra.*
import org.scalacheck.*
import Gen.*
import Arbitrary.arbitrary
import Prop.forAll

object AlgebraTest extends Properties("Algebra"):

  property("sum-semigroup-assoc") = forAll: (x: Int, y: Int, z: Int) =>
    import Algebra.sumSemiGroup
    Algebra.associative(x, y, z)

  property("sum-monoid-identity") = forAll: (x: Int) =>
    import Algebra.sumMonoid
    Algebra.identity(x)

  import Algebra.given

  property("bigints-semigroup-assoc") = forAll: (x: BigInt, y: BigInt, z: BigInt) =>
    Algebra.associative(x, y, z)

  property("bigints-monoid-identity") = forAll: (x: BigInt) =>
    Algebra.identity(Option(x))

  property("bigints-monoid-assoc") = forAll: (x: Option[BigInt], y: Option[BigInt], z: Option[BigInt]) =>
    Algebra.associative(x, y, z)
