package poly

import poly.MyList.*
import scala.annotation.tailrec
import cs214.TODO

def map[A, B](l: MyList[A])(f: A => B): MyList[B] =
  ???

def filter[A](l: MyList[A])(p: A => Boolean): MyList[A] =
  ???

def foldRight[A, B](l: MyList[A])(f: (A, B) => B, base: B): B =
  ???

def reduceRight[A](l: MyList[A])(f: (A, A) => A): A =
  ???

def forall[A](l: MyList[A])(p: A => Boolean): Boolean =
  ???

def exists[A](l: MyList[A])(p: A => Boolean): Boolean =
  ???

def zip[A, B](l1: MyList[A], l2: MyList[B]): MyList[(A, B)] =
  ???

def zipWith[A, B, C](l1: MyList[A], l2: MyList[B])(op: (A, B) => C): MyList[C] =
  ???

def elementsAsStrings[A](l: MyList[A]): MyList[String] =
  ???

def length[A](l: MyList[A]): Int =
  ???

def takeWhilePositive(l: MyList[Int]): MyList[Int] =
  ???

def last[A](l: MyList[A]): A =
  ???

val capitalizeString: MyList[Char] => MyList[Char] =
  TODO

def wordCount(l: MyList[Char]): Int =
  ???

def append[A](l1: MyList[A], l2: MyList[A]): MyList[A] = l1 match
  case Nil         => l2
  case Cons(x, xs) => Cons(x, append(xs, l2))

extension [A](l: MyList[A])
  def ++(that: MyList[A]): MyList[A] = append(l, that)

def flatMap[A, B](l: MyList[A])(f: A => MyList[B]): MyList[B] =
  ???

def flatten[A](l: MyList[MyList[A]]): MyList[A] =
  ???

def crossProduct[A, B](l1: MyList[A], l2: MyList[B]): MyList[(A, B)] =
  ???

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
  ???
  sum(l, 0)

// @tailrec // Uncomment this line.
def foldLeft[A, B](l: MyList[A])(base: B, f: (B, A) => B): B =
  ???

def sum0Fold(l: MyList[Int]): Int =
  ???
def sum1Fold(l: MyList[Int]): Int =
  ???

def reverseAppend[A](l1: MyList[A], l2: MyList[A]): MyList[A] =
  ???

def reverse[A](l: MyList[A]): MyList[A] = reverseAppend(l, Nil)

val countEven: MyList[Int] => Int =
  TODO

val totalLength: MyList[String] => Int =
  TODO

// A polymorphic method:
def foo[A](xs: List[A]): List[A] = ???

// A polymorphic function value:
val bar = [A] => (xs: List[A]) => foo(xs)

val curriedZipWith: [A, B, C] => ((A, B) => C) => MyList[A] => MyList[B] => MyList[C] =
  TODO
