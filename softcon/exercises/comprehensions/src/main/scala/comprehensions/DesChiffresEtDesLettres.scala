package comprehensions

import java.util.Locale

object DesLettres:
  def scramble(word: String): String =
    ???

  def scrambleList(allWords: Set[String]): Map[String, Set[String]] =
    ???

  def exactWord(allWords: Set[String], letters: String): Set[String] =
    ???

  def compatible(small: String, large: String): Boolean =
    ???

  def longestWord(allWords: Set[String], letters: String): Set[String] =
    ???

object DesChiffres:
  trait Expr:
    val value: Option[Int]

  case class Num(n: Int) extends Expr:
    val value = Some(n)
    override def toString(): String = f"$n" // Print as number

  abstract class Binop extends Expr:
    val e1, e2: Expr // Subexpressions
    def op(n1: Int, n2: Int): Option[Int] // How to evaluate this operator

    val opStr: String // How to print this operator
    override def toString(): String = f"($e1 $opStr $e2)"

    val value: Option[Int] =
      for
        n1 <- e1.value
        n2 <- e2.value
        r <- op(n1, n2)
      yield r

  case class Add(e1: Expr, e2: Expr) extends Binop:
    def op(n1: Int, n2: Int) =
      Some(n1 + n2)
    val opStr = "+"

  case class Sub(e1: Expr, e2: Expr) extends Binop:
    def op(n1: Int, n2: Int) =
      if n1 < n2 then None else Some(n1 - n2)
    val opStr = "-"

  case class Mul(e1: Expr, e2: Expr) extends Binop:
    def op(n1: Int, n2: Int) =
      Some(n1 * n2)
    val opStr = "*"

  case class Div(e1: Expr, e2: Expr) extends Binop:
    def op(n1: Int, n2: Int) =
      if n2 != 0 && n1 % n2 == 0 then Some(n1 / n2) else None
    val opStr = "/"

  def partitions[A](l: List[A]): List[(List[A], List[A])] =
      ???

  def allTrees(ints: List[Int]): List[Expr] =
      ???

  def leCompteEstBon(ints: List[Int], target: Int): Option[Expr] =
      ???
