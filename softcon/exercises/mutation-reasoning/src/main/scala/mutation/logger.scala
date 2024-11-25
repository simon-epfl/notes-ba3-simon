package mutation.logger

import mutation.interpreter.Operation
import mutation.interpreter.Operation.*

trait Logger:
  def log(message: String, depth: Int = 0): Unit

class LoggerBuffered extends Logger:
  // private var ???

  def log(message: String, depth: Int = 0): Unit =
    ???
  def getOutput: String =
    ???

object EvalLogging:
  enum Expr:
    case Constant(a: Int)
    case Add(a: Expr, b: Expr)
    case Sub(a: Expr, b: Expr)
  import Expr.*

  def eval(e: Expr, l: Logger, depth: Int = 0): Int =
    ???

object InterpreterLogging:
  def evalOp(l: Logger)(stack: List[Int], op: Operation): List[Int] =
    ???

  def evalRec(p: List[Operation], l: Logger): List[Int] =
    ???

  type Stack = scala.collection.mutable.Stack[Int]
  import scala.collection.mutable.Stack

  def evalLoop(p: List[Operation], l: Logger): Stack =
    ???
