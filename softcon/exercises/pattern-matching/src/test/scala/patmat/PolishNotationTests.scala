import patmat.*

class PolishNotationTests extends munit.FunSuite:
  // Uncomment these once you have defined PolishNotation and PolishNotationAtom
  // import PolishNotation.*
  // import PolishNotationAtom.*

  test("polishEval: addition"):
    assertEquals(polishEval(plusOneTwo)._1, 3)

  test("polishEval: nested operations"):
    assertEquals(polishEval(plusTwoTimesThreeFour)._1, 14)
