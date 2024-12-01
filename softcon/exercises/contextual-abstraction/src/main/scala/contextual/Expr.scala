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
    case Num(value) => value
    case Var(name) => ctx(name)
    case Add(e1, e2) => recur(e1) + recur(e2)
    case Sub(e1, e2) => recur(e1) - recur(e2)
    case Mul(e1, e2) => recur(e1) * recur(e2)
    case Let(name, value, body) =>
      recur(body)(using ctx.updated(name, recur(value)))

  recur(e)(using Map.empty)
