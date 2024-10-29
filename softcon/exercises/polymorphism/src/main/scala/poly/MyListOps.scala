package poly

import poly.MyList.*
import scala.annotation.tailrec
import cs214.TODO
import java.util.function.IntConsumer

def map[A, B](l: MyList[A])(f: A => B): MyList[B] =
  l match
    case Nil => Nil
    case Cons(x, xs) => Cons(f(x), map(xs)(f))

def filter[A](l: MyList[A])(p: A => Boolean): MyList[A] =
  l match
    case Nil => Nil
    case Cons(x, xs) => if p(x) then Cons(x, filter(xs)(p)) else filter(xs)(p)

def foldRight[A, B](l: MyList[A])(f: (A, B) => B, base: B): B =
  l match
    case Nil => base
    case _ => f(l.head, foldRight(l.tail)(f, base))

def reduceRight[A](l: MyList[A])(f: (A, A) => A): A =
  l match
    case Nil => throw new IllegalArgumentException()
    case Cons(x, Nil) => x
    case Cons(x, xs) => f(x, reduceRight(xs)(f))

def forall[A](l: MyList[A])(p: A => Boolean): Boolean =
  l match
    case Nil => true
    case Cons(x, xs) => p(x) && forall(xs)(p)

def exists[A](l: MyList[A])(p: A => Boolean): Boolean =
  l match
    case Nil => false
    case Cons(x, xs) => p(x) || exists(xs)(p)

def zip[A, B](l1: MyList[A], l2: MyList[B]): MyList[(A, B)] =
  (l1, l2) match
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case _ => Cons((l1.head, l2.head), zip(l1.tail, l2.tail))

def zipWith[A, B, C](l1: MyList[A], l2: MyList[B])(op: (A, B) => C): MyList[C] =
  (l1, l2) match
    case (_, Nil) => Nil
    case (Nil, _) => Nil
    case _ => Cons(op(l1.head, l2.head), zipWith(l1.tail, l2.tail)(op))

def elementsAsStrings[A](l: MyList[A]): MyList[String] =
  map(l)(_.toString)

def length[A](l: MyList[A]): Int =
  foldRight(l)((x, acc) => 1 + acc, 0)

def takeWhilePositive(l: MyList[Int]): MyList[Int] =
  foldRight(l)((x, acc) => if x >= 0 then Cons(x, acc) else Nil, Nil)

def last[A](l: MyList[A]): A =
  reduceRight(l)((a, b) => b)

val capitalizeString: MyList[Char] => MyList[Char] = (l) => map(l)(_.toUpper)

case class WordCountState(count: Int, lastWasWS: Boolean)

def wordCount(l: MyList[Char]): Int =
  (foldLeft(l)(
    WordCountState(0, true),
    (state, charact) =>
      if charact.isWhitespace then WordCountState(state.count, true)
      else
        if state.lastWasWS then WordCountState(state.count+1, false)
        else WordCountState(state.count, false)
  )).count

def append[A](l1: MyList[A], l2: MyList[A]): MyList[A] = l1 match
  case Nil         => l2
  case Cons(x, xs) => Cons(x, append(xs, l2))

extension [A](l: MyList[A])
  def ++(that: MyList[A]): MyList[A] = append(l, that)

def flatMap[A, B](l: MyList[A])(f: A => MyList[B]): MyList[B] =
  l match
    case Nil => Nil
    case Cons(x, xs) => f(x) ++ flatMap(xs)(f)

def flatten[A](l: MyList[MyList[A]]): MyList[A] = flatMap(l)(identity)

def crossProduct[A, B](l1: MyList[A], l2: MyList[B]): MyList[(A, B)] =
  flatMap(l1)(el => flatMap(l2)(el2 => Cons((el, el2), Nil)))

def allThreeLetterWords(words: MyList[String]): MyList[String] =
  filter(words)(_.length == 3)

def length0(l: MyList[Int]): Int = l match
  case Nil         => 0
  case Cons(x, xs) => 1 + length0(xs)

def lengthTR(l: MyList[Int]): Int =
  def length(l: MyList[Int], prefixLength: Int): Int = l match
    case Nil         => prefixLength
    case Cons(x, xs) => length(xs, prefixLength + 1)
  length(l, 0)

def sum0(l: MyList[Int]): Int = l match
  case Nil         => 0
  case Cons(x, xs) => x + sum0(xs)

def sum1(l: MyList[Int]): Int =
  // @tailrec // Uncomment this line.
  def sum(l: MyList[Int], acc: Int): Int =
    if l.isEmpty then acc
    else sum(l.tail, l.head + acc)
  sum(l, 0)

// @tailrec // Uncomment this line.
def foldLeft[A, B](l: MyList[A])(base: B, f: (B, A) => B): B =
  l match
    case Nil => base
    case Cons(x, xs) => foldLeft(xs)(f(base, x), f)

def sum0Fold(l: MyList[Int]): Int =
  foldRight(l)((el, acc) => el + acc, 0)
def sum1Fold(l: MyList[Int]): Int =
  foldLeft(l)(0, (acc, el) => el + acc)

def reverseAppend[A](l1: MyList[A], l2: MyList[A]): MyList[A] =
  foldLeft(l1)(l2, (cList, el) => Cons(el, cList))

def reverse[A](l: MyList[A]): MyList[A] = reverseAppend(l, Nil)

val countEven: MyList[Int] => Int = (l) => foldLeft(l)(0, (sum, el) => if el % 2 == 0 then sum + 1 else sum)

val totalLength: MyList[String] => Int = (strings) => foldLeft(strings)(0, (sum, el) => el.length() + sum)

// A polymorphic method:
def foo[A](xs: List[A]): List[A] = ???

// A polymorphic function value:
val bar = [A] => (xs: List[A]) => foo(xs)

val curriedZipWith: [A, B, C] => ((A, B) => C) => MyList[A] => MyList[B] => MyList[C] =
  TODO
