package mutation.interpreter

abstract class InterpreterTest extends munit.FunSuite:
  import Operation.*

  def eval(l: List[Operation]): List[Int]

  test("eval: empty program"):
    assert(eval(Nil) == Nil)

  test("eval: program with one Push"):
    assert(eval(List(Push(1))) == List(1))

  test("eval: program with one Add"):
    assert(eval(List(Add)) == Nil)

  test("eval: program with one Sub"):
    assert(eval(List(Sub)) == Nil)

  test("eval: program 2 + 1"):
    assert(eval(List(Push(2), Push(1), Add)) == List(3))

  test("eval: program 2 - 1"):
    assert(eval(List(Push(2), Push(1), Sub)) == List(1))

  test("eval: program 6 - (3 + 5)"):
    assert(eval(List(Push(6), Push(3), Push(5), Add, Sub)) == List(-2))

class RecursiveInterpreterTest extends InterpreterTest:
  import RecursiveInterpreter.*
  import Operation.*

  def eval(l: List[Operation]): List[Int] =
    RecursiveInterpreter.eval(l)

  test("evalOp: Push"):
    assert(evalOp(List(2, 3), Push(1)) == List(1, 2, 3))

  test("evalOp: Add"):
    assert(evalOp(List(2, 3), Add) == List(5))

  test("evalOp: Sub"):
    assert(evalOp(List(2, 3), Sub) == List(1))

class LoopInterpreterTest extends InterpreterTest:
  def eval(l: List[Operation]): List[Int] =
    LoopInterpreter.eval(l).toList
