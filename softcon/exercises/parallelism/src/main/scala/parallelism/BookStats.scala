package parallelism

import scala.collection.parallel.CollectionConverters.*

object BookStats:
  type Word = String
  type Chapter = Seq[Word]
  type Book = Seq[Chapter]

  val bookExample: Book =
    Vector(Vector("the", "quick", "brown", "fox", "is", "jumping", "over"), Vector("the", "lazy", "dog"))

  def length(b: Book): Int =
    ???

  def maxChapterLength(b: Book): Int =
    ???

  def countWord(b: Book, w: Word): Int =
    ???

  def containsWord(b: Book, w: Word): Boolean =
    ???

  def longestWord(b: Book): Word =
    ???

  def mostCommonWord(b: Book): Word =
    ???
