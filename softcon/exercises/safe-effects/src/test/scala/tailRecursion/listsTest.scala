package tailRecursion.lists

class TailRecursionTest extends munit.FunSuite:
  def testReverseAppend(l1: List[Int], l2: List[Int]) =
    assert(reverseAppend(l1, l2) == reverseAppendLoop(l1, l2))

  test("`reverseAppendLoop` works for two arbitrary lists") {
    testReverseAppend(List(52, 515, 12, -5, 65), List(65, 20, 23, 100, -6))
  }

  test("`sumLoop` works for an arbitrary array") {
    val l = List(45, -2, 1, 32)
    assert(l.sum == sumLoop(l))
  }

  test("`foldLeftLoop` works with List(1,2,3) and op = _ + _") {
    val l = List(1, 2, 3)
    assert(l.foldLeft(0)(_ + _) == foldLeftLoop(l, 0)(_ + _))
  }

  test("`foldLeftLoop` works with List(1,2,3) and op = _ - _") {
    val l = List(1, 2, 3)
    assert(l.foldLeft(0)(_ - _) == foldLeftLoop(l, 0)(_ - _))
  }

  test("`foldt` produces the same result as the recursive version with even size") {
    def groundTruthPairs[T](l: List[T], op: (T, T) => T): List[T] = l match
      case a :: b :: tl => op(a, b) :: groundTruthPairs(tl, op)
      case _            => l
    def groundTruthFoldt[T](z: T)(l: List[T], op: (T, T) => T): T = l match
      case Nil       => z
      case List(t)   => t
      case _ :: tail => groundTruthFoldt(z)(groundTruthPairs(l, op), op)

    val l = List(1, 2, 3, 4, 5, 6)
    assert(l.foldt(15)((x: Int, y: Int) => x - y) == groundTruthFoldt(15)(l, (x: Int, y: Int) => x - y))
  }

  test("`foldt` produces the same result as the recursive version with odd size") {
    def groundTruthPairs[T](l: List[T], op: (T, T) => T): List[T] = l match
      case a :: b :: tl => op(a, b) :: groundTruthPairs(tl, op)
      case _            => l
    def groundTruthFoldt[T](z: T)(l: List[T], op: (T, T) => T): T = l match
      case Nil       => z
      case List(t)   => t
      case _ :: tail => groundTruthFoldt(z)(groundTruthPairs(l, op), op)

    val l = List(1, 2, 3, 4, 5, 6, 7)
    assert(l.foldt(15)((x: Int, y: Int) => x - y) == groundTruthFoldt(15)(l, (x: Int, y: Int) => x - y))
  }

  test("`mapTR` works with Cons(1, Cons(2, Cons(3, Nil)) and the square op.") {
    import MapContext.*
    import MutableList.*

    val original = Cons(1, Cons(2, Cons(3, Nil)))
    val expected = Cons(1, Cons(4, Cons(9, Nil)))
    val result = mapTR(original, x => x * x)

    assert(result == expected)
  }
