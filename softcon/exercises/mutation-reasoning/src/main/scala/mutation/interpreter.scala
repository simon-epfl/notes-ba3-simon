package mutation.interpreter

enum Operation:
  case Push(n: Int)
  case Add
  case Sub

type Program = List[Operation]

object RecursiveInterpreter:
  import Operation.*
  type Stack = List[Int]

  def evalOp(stack: Stack, op: Operation): Stack =
    ???

  def eval(p: List[Operation]): Stack =
    ???

end RecursiveInterpreter

object LoopInterpreter:
  import Operation.*
  import scala.collection.mutable.Stack

  def eval(p: List[Operation]): Stack[Int] =
    ???
end LoopInterpreter
