package parallelism

import scala.collection.parallel.CollectionConverters.*

object BookStats:
  type Word = String
  type Chapter = Seq[Word]
  type Book = Seq[Chapter]

  val bookExample: Book =
    Vector(Vector("the", "quick", "brown", "fox", "is", "jumping", "over"), Vector("the", "lazy", "dog"))

  def length(b: Book): Int =
    b.map(chapter => chapter.length).reduce((acc, currEl) => acc + currEl)

  def maxChapterLength(b: Book): Int =
    b.map(chapter => chapter.length).max

  def countWord(b: Book, w: Word): Int =
    b.map(chapter => chapter.count(word => word == w)).reduce((acc, el) => acc + el)

  def containsWord(b: Book, w: Word): Boolean =
    b.map(chapter => chapter.exists(word => word == w)).contains(true)

  def longestWord(b: Book): Word =
    b.flatten.groupBy(_.length).maxByOption(_._1).get._2.head

  def mostCommonWord(b: Book): Word =
    // from 8s to 2s by adding .par!
    b.par.flatten.groupBy(countWord(b, _)).toList.maxByOption(_._1).get._2.head
