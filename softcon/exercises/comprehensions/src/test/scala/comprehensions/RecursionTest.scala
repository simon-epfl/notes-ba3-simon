package comprehensions

class RecursionTest extends munit.FunSuite:

  val factorials: List[(Int, Int)] =
    List(
      0 -> 1,
      1 -> 1,
      2 -> 2,
      3 -> 6,
      4 -> 24,
      5 -> 120,
      12 -> 479001600
    )
  for (n, f) <- factorials do
    test(s"factorial: $n! = $f"):
      assertEquals(factorial(n), f)

  val exps: List[((Int, Int), Int)] =
    List(
      (5, 0) -> 1,
      (2, 1) -> 2,
      (2, 4) -> 16,
      (3, 3) -> 27
    )

  for ((b, e), r) <- exps do
    test(s"fastExp: $b^$e = $r"):
      assertEquals(fastExp(b, e), r)

  test("decimalToBaseN: number 9 to base-2"):
    assertEquals(decimalToBaseN(9, 2), List(1, 0, 0, 1))

  test("decimalToBaseN: number 20 to base-16"):
    assertEquals(decimalToBaseN(20, 16), List(1, 4))

  test("decimalToBaseN: number 100 to base-4"):
    assertEquals(decimalToBaseN(100, 4), List(1, 2, 1, 0))

  test("decimalToBaseN: number 77 to base-6"):
    assertEquals(decimalToBaseN(77, 6), List(2, 0, 5))

  val someCoins = List(1, 2, 5)
  val singleCoin = List(3)
  val noCoins = List.empty[Int]

  test("coinChange should return the correct number of ways to make change"):
    assertEquals(coinChange(someCoins, 5), 4)
    assertEquals(coinChange(someCoins, 11), 11)
    assertEquals(coinChange(singleCoin, 3), 1)
    assertEquals(coinChange(singleCoin, 2), 0)
    assertEquals(coinChange(singleCoin, 10), 0)

  test("coinChange should return 0 if the list of coins is empty"):
    assertEquals(coinChange(noCoins, 5), 0)
    assertEquals(coinChange(noCoins, 11), 0)
    assertEquals(coinChange(noCoins, -1), 0)

  test("coinChange should return 1 if the amount is 0"):
    assertEquals(coinChange(someCoins, 0), 1)
    assertEquals(coinChange(noCoins, 0), 1)

  test("coinChange should return 0 if the amount is negative"):
    assertEquals(coinChange(someCoins, -1), 0)

  test("split: split a 9-element list"):
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
    val (l1, l2) = split(l)
    assertEquals(math.abs(l1.length - l2.length), 1)
    assertEquals((l1 ++ l2).sorted, l.sorted)

  test("merge: empty lists"):
    assertEquals(merge(Nil, Nil), Nil)

  test("merge: left empty list"):
    assertEquals(merge(Nil, List(1, 2, 3)), List(1, 2, 3))

  test("merge: right empty list"):
    assertEquals(merge(List(1, 2, 3), Nil), List(1, 2, 3))

  test("merge: left list with one small element"):
    assertEquals(merge(List(1), List(2, 3)), List(1, 2, 3))

  test("merge: left list with one large element"):
    assertEquals(merge(List(3), List(1, 2)), List(1, 2, 3))

  test("merge: two interleaved lists"):
    assertEquals(merge(List(1, 3, 5), List(2, 4, 6)), List(1, 2, 3, 4, 5, 6))

  test("mergeSort: empty list"):
    assertEquals(mergeSort(List.empty[Int]), List.empty[Int])

  test("mergeSort: list with one element"):
    assertEquals(mergeSort(List(42)), List(42))

  test("mergeSort: already sorted list"):
    assertEquals(mergeSort(List(1, 2, 3, 4, 5)), List(1, 2, 3, 4, 5))

  test("mergeSort: reverse sorted list"):
    assertEquals(mergeSort(List(5, 4, 3, 2, 1)), List(1, 2, 3, 4, 5))

  test("mergeSort: list with duplicates"):
    assertEquals(mergeSort(List(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)), List(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9))
