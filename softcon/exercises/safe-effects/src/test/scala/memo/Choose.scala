package memo

class MemoTests extends munit.FunSuite:
  def testChoose(choose: (Int, Int) => Int) =
    for ((n, k), r) <- List(
        ((0, 0), 1),
        ((0, 1), 1),
        ((0, 2), 1),
        ((0, 3), 1),
        ((0, 4), 1),
        ((0, 5), 1),
        ((1, 0), 1),
        ((1, 1), 1),
        ((1, 2), 1),
        ((1, 3), 1),
        ((1, 4), 1),
        ((1, 5), 1),
        ((2, 0), 1),
        ((2, 1), 2),
        ((2, 2), 1),
        ((2, 3), 1),
        ((2, 4), 1),
        ((2, 5), 1),
        ((3, 0), 1),
        ((3, 1), 3),
        ((3, 2), 3),
        ((3, 3), 1),
        ((3, 4), 1),
        ((3, 5), 1),
        ((4, 0), 1),
        ((4, 1), 4),
        ((4, 2), 6),
        ((4, 3), 4),
        ((4, 4), 1),
        ((4, 5), 1),
        ((5, 0), 1),
        ((5, 1), 5),
        ((5, 2), 10),
        ((5, 3), 10),
        ((5, 4), 5),
        ((5, 5), 1)
      )
    do assertEquals(choose(n, k), r)

  test("choose"):
    testChoose(choose)

  test("chooseMemo"):
    testChoose(chooseMemo)

  test("chooseIter"):
    testChoose(chooseIter)

  test("chooseIterFinal"):
    testChoose(chooseIterFinal)

  test("chooseIterFinalGC"):
    testChoose(chooseIterFinalGC)

  test("chooseIterFinalOpt"):
    testChoose(chooseIterFinalOpt)
