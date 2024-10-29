import patmat.*
import UnaryNat.*
import UnaryNatOps.*

class UnaryNatOpsTest extends munit.FunSuite:
  test("add: rhs is zero"):
    assertEquals(add(Zero, Zero), Zero)
    assertEquals(add(Succ(Zero), Zero), Succ(Zero))

  test("add: rhs is non-zero"):
    assertEquals(add(Zero, Succ(Zero)), Succ(Zero))
    assertEquals(add(Succ(Zero), Succ(Zero)), Succ(Succ(Zero)))

  test("minus: rhs is zero"):
    assertEquals(minus(Zero, Zero), Zero)
    assertEquals(minus(Succ(Zero), Zero), Succ(Zero))
    assertEquals(minus(Succ(Succ(Zero)), Zero), Succ(Succ(Zero)))

  test("minus: rhs is non-zero"):
    assertEquals(minus(Succ(Zero), Succ(Zero)), Zero)
    assertEquals(minus(Succ(Succ(Zero)), Succ(Zero)), Succ(Zero))

  test("minus: rhs is bigger than lhs"):
    assertEquals(minus(Zero, Succ(Zero)), Zero)
    assertEquals(minus(Succ(Zero), Succ(Succ(Zero))), Zero)

  test("multiply: rhs is zero"):
    assertEquals(multiply(Succ(Zero), Zero), Zero)

  test("multiply: one times one"):
    assertEquals(multiply(Succ(Zero), Succ(Zero)), Succ(Zero))

  test("multiply: two times two"):
    assertEquals(multiply(Succ(Succ(Zero)), Succ(Succ(Zero))), Succ(Succ(Succ(Succ(Zero)))))

  test("isEven: zero"):
    assertEquals(isEven(Zero), true)

  test("isEven: one"):
    assertEquals(isEven(Succ(Zero)), false)

  test("isEven: two"):
    assertEquals(isEven(Succ(Succ(Zero))), true)

  test("isEven: three"):
    assertEquals(isEven(Succ(Succ(Succ(Zero)))), false)

  test("isOdd: zero"):
    assertEquals(isOdd(Zero), false)

  test("isOdd: one"):
    assertEquals(isOdd(Succ(Zero)), true)

  test("isOdd: two"):
    assertEquals(isOdd(Succ(Succ(Zero))), false)

  test("isOdd: three"):
    assertEquals(isOdd(Succ(Succ(Succ(Zero)))), true)
