package contextual

enum Expr:
  case Num(value: Int)
  case Var(name: String)
  case Let(name: String, value: Expr, body: Expr)
  case Add(e1: Expr, e2: Expr)
  case Sub(e1: Expr, e2: Expr)
  case Mul(e1: Expr, e2: Expr)

import Expr.*

def evaluate(e: Expr): Int =
  def recur(e: Expr)(using ctx: Map[String, Int]): Int = e match
    case _ => ???

  recur(e)(using Map.empty)
