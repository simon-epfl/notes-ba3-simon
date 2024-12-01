package contextual

import org.scalacheck.*
import Gen.*
import Arbitrary.arbitrary
import Prop.forAll

object ExprTest extends Properties("Expr"):
  import Expr.*

  def genName(env: Seq[String]): Gen[String] =
    for
      c <- choose('a', 'z')
      cs <- listOfN(2, choose('0', '9'))
      n = (c :: cs).mkString
      if !env.contains(n)
    yield n

  val genNum: Gen[Num] =
    for
      value <- arbitrary[Int]
    yield Num(value)

  def genVar(env: Seq[String]): Gen[Var] =
    if env.isEmpty then fail
    else oneOf(env).map(Var(_))

  def genLet(env: Seq[String]): Gen[Let] = sized: sz =>
    for
      name <- genName(env)
      vsz <- choose(1, sz - 2)
      value <- resize(vsz, genExpr(env))
      body <- resize(sz - 1 - vsz, genExpr(name +: env))
    yield Let(name, value, body)

  def genBin(env: Seq[String]): Gen[Expr] = sized: sz =>
    for
      e1 <- resize(sz / 2 - 1, genExpr(env))
      e2 <- resize(sz / 2 - 1, genExpr(env))
      bin <- oneOf(Add(e1, e2), Sub(e1, e2), Mul(e1, e2))
    yield bin

  def genExpr(env: Seq[String]): Gen[Expr] = sized: sz =>
    if sz <= 2 then
      if env.isEmpty then genNum
      else oneOf(genNum, genVar(env))
    else oneOf(genLet(env), genBin(env))

  given Arbitrary[Expr] = Arbitrary(genExpr(Seq.empty))

  def eliminateLets(e: Expr, env: Map[String, Expr]): Expr = e match
    case Num(value) => Num(value)
    case Var(name)  => env(name)
    case Let(name, value, body) =>
      val value1 = eliminateLets(value, env)
      eliminateLets(body, env + (name -> value1))
    case Add(e1, e2) => Add(eliminateLets(e1, env), eliminateLets(e2, env))
    case Sub(e1, e2) => Sub(eliminateLets(e1, env), eliminateLets(e2, env))
    case Mul(e1, e2) => Mul(eliminateLets(e1, env), eliminateLets(e2, env))

  def evaluateWithoutLetsAndVars(e: Expr): Int =
    def recur(e: Expr): Int = e match
      case Num(value)   => value
      case Var(_)       => throw new Exception("var not allowed")
      case Let(_, _, _) => throw new Exception("let not allowed")
      case Add(e1, e2)  => recur(e1) + recur(e2)
      case Sub(e1, e2)  => recur(e1) - recur(e2)
      case Mul(e1, e2)  => recur(e1) * recur(e2)
    recur(e)

  property("evaluate") = forAll: (e: Expr) =>
    evaluate(e) == evaluateWithoutLetsAndVars(eliminateLets(e, Map.empty))
