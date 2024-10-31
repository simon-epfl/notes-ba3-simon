package comprehensions

import java.util.Locale

object DesLettres:
  def scramble(word: String): String =
    word.toUpperCase().sorted

  def scrambleList(allWords: Set[String]): Map[String, Set[String]] =
    allWords.groupBy(scramble)

  def exactWord(allWords: Set[String], letters: String): Set[String] =
    scrambleList(allWords).getOrElse(scramble(letters), Set.empty)

  def compatible(small: String, large: String): Boolean =
    (small, large) match
      case ("", _) => true
      case (_, "") => false
      case (_, _) =>
        if small.head  == large.head then compatible(small.tail, large.tail)
        else if small.head > large.head then compatible(small, large.tail)
        else false

  def longestWord(allWords: Set[String], letters: String): Set[String] =
    val scrambled = scramble(letters)
    (for
      (word, subwords) <- scrambleList(allWords)
      if compatible(word, scrambled)
    yield subwords).maxByOption(_.head.length).getOrElse(Set.empty)

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


/* 

(1, 2, 3)


(1), (2, 3)
(1, 2), (3)
(2, 3), (1)
(1, 2, 3), ()

 */

  def partitions[A](l: List[A]): List[(List[A], List[A])] =
    l match
      case Nil => List((Nil, Nil))
      case head :: next =>
        for
          (l1, l2) <- partitions(next)
          p <- List((head :: l1, l2), (head :: l2, l1))
        yield p

  def allTrees(ints: List[Int]): List[Expr] =
      ???

  def leCompteEstBon(ints: List[Int], target: Int): Option[Expr] =
      ???
