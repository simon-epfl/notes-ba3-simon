package parallelism
import BookStats.*

import java.nio.file.{Files, Paths}
import java.nio.charset.StandardCharsets
import cs214.PathMacro

import scala.collection.immutable.Map

class TestVectorSuite extends munit.FunSuite:
  case class TestVector(
      book: Book,
      length: Int,
      maxChapterLength: Int,
      countWord: Map[Word, Int],
      containsWord: Map[Word, Boolean],
      longestWords: Set[Word],
      mostCommonWords: Set[Word],
      desc: Option[String] = None
  ):
    def description: String = desc.getOrElse(book.toString)

  /** Removes diacritics and all non-alphabetic characters from `s`. */
  def normalizeString(str: String): String =
    java.text.Normalizer
      .normalize(str, java.text.Normalizer.Form.NFD)
      .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
      .replaceAll("[^a-zA-Z ]+", "")
      .toLowerCase(java.util.Locale.ROOT)
      .ensuring(_.forall(c => 'a' <= c && c <= 'z'))

  def splitChapter(c: String): Chapter =
    c.strip.split("[\\s\\-]+").map(normalizeString).filter(_ != "").to(Vector)

  def splitChapters(s: String): Book =
    s.split(";").to(Vector).map(splitChapter)

  object BrownFox:
    val testVector = TestVector(
      book = splitChapters("The quick brown fox ; jumps over ; the lazy dog"),
      length = 9,
      maxChapterLength = 4,
      countWord = Map("the" -> 2, "jumped" -> 0),
      containsWord = Map("brown" -> true, "red" -> false),
      longestWords = Set("quick", "brown", "jumps"),
      mostCommonWords = Set("the")
    )

  object LiquorJugs:
    val testVector = TestVector(
      book = splitChapters("Pack ; my box ; with five dozen liquor jugs"),
      length = 8,
      maxChapterLength = 5,
      countWord = Map("pack" -> 1, "box" -> 1),
      containsWord = Map("liquor" -> true, "six" -> false),
      longestWords = Set("liquor"),
      mostCommonWords = Set("pack", "my", "box", "with", "five", "dozen", "liquor", "jugs")
    )

  object AliceInWonderLand:
    val thisFilePath = Paths.get(PathMacro.sourcePath)
    val assetsPath = thisFilePath.getParent.getParent.getParent.getParent.getParent.resolve("assets")
    val originPath = assetsPath.resolve("alice_in_wonderland.txt").toString

    def readFileContent(path: String): String =
      new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8)

    def splitBook(text: String): Book =
      val matches = """\bCHAPTER\s+[IVXLCDM]+\b""".r.findAllMatchIn(text)
      val chapterStarts = matches.map(_.start).to(Vector)
      val chapters = (0 +: chapterStarts).zip(chapterStarts).map(text.substring(_, _))
      chapters.map(splitChapter)

    val testVector: TestVector = TestVector(
      book = splitBook(readFileContent(originPath)),
      length = 24560,
      maxChapterLength = 2669,
      countWord = Map(
        "alice" -> 364,
        "cat" -> 35,
        "tarts" -> 5
      ),
      containsWord = Map(
        "alice" -> true,
        "gimmick" -> false,
        "wonderful" -> false,
        "wonderland" -> true
      ),
      longestWords = Set("disappointment", "multiplication", "contemptuously", "affectionately"),
      mostCommonWords = Set("the"),
      desc = Some("AliceInWonderLand.testVector.book")
    )

  val testVectors = Vector(
    BrownFox.testVector,
    LiquorJugs.testVector,
    AliceInWonderLand.testVector
  )

  for t <- testVectors do
    test(f"bookstats: TestVector.length(${t.description})"):
      assertEquals(length(t.book), t.length)

    test(f"bookstats: TestVector.maxChapterLength(${t.description})"):
      assertEquals(maxChapterLength(t.book), t.maxChapterLength)

    for (w, n) <- t.countWord do
      test(f"bookstats: TestVector.countWord(${t.description}, \"$w\")"):
        assertEquals(countWord(t.book, w), n)

    for (w, r) <- t.containsWord do
      test(f"bookstats: TestVector.containsWord(${t.description}, \"$w\")"):
        assertEquals(containsWord(t.book, w), r)

    test(f"bookstats: TestVector.longestWords(${t.description})"):
      assert(t.longestWords.contains(longestWord(t.book)))

    test(f"bookstats: TestVector.mostCommonWords(${t.description})"):
      assert(t.mostCommonWords.contains(mostCommonWord(t.book)))
