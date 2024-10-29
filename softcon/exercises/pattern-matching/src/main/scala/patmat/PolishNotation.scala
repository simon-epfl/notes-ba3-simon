package patmat

// Replace these types with `enum`s
type PolishNotationAtom = Unit
type PolishNotation = Unit

def plusOneTwo: PolishNotation = // + 1 2
  ???

def plusTwoTimesThreeFour: PolishNotation = // + 2 * 3 4
  ???

class InvalidExpression extends RuntimeException

def polishEval(l: PolishNotation): (Int, PolishNotation) =
  ???
