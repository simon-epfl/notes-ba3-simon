package comprehensions

import munit.FunSuite

class NQueensTest extends FunSuite:
  test("isSafe: return true when no conflict"):
    assertEquals(isSafe(3, List(0, 2, 4, 1)), true)

  test("isSafe: return false when there is a column conflict"):
    assertEquals(isSafe(0, List(2, 0, 3)), false)

  test("isSafe: return false when there is a diagonel conflict, direction 1"):
    assertEquals(isSafe(1, List(2, 0, 3, 5)), false)

  test("isSafe: return false when there is a diagonel conflict, direction 2"):
    assertEquals(isSafe(5, List(2, 0, 3, 1)), false)
