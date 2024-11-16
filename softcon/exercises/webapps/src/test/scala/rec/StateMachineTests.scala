package rec

class PatternMatcherTests extends munit.FunSuite:
  import PatternMatching.{countMatchesSM, countMatchesSM2}

  test("countMatchesSM: Nil"):
    assertEquals(countMatchesSM(Nil), 0)

  val noMatches =
    "CS 200 is Computer Architecture.  214 is triacontakaiheptagonal".split(" ").toList
  test("countMatchesSM: No match"):
    assertEquals(countMatchesSM(noMatches), 0)

  val twoMatches =
    "CS 214 is Software Construction.  The website is not CS 214 . epfl . ch.".split(" ").toList
  test("countMatchesSM: Two matches"):
    assertEquals(countMatchesSM(twoMatches), 2)

abstract class IsBalancedTestsT(name: String, isBalanced: List[Char] => Boolean) extends munit.FunSuite:
  for (input, output) <- List(
      "(((())))" -> true,
      "((()))" -> true,
      "(((()))" -> false,
      "((())))" -> false,
      "(o_()" -> false,
      ":-)" -> false,
      "())(" -> false,
      "(if (zero? x) max (/ 1 x))" -> true,
      "I told him (that it's not (yet) done). (But he wasn't listening)" -> true
    )
  do
    test(f"$name: \"$input\" → $output"):
      assertEquals(isBalanced(input.toList), output)

class IsBalancedTests
    extends IsBalancedTestsT("isBalanced", isBalanced)
class IsBalancedTeststs
    extends IsBalancedTestsT("isBalancedSM", IsBalanced.isBalancedSM)

abstract class WordCountTestsT(name: String, wordCount: List[Char] => Int) extends munit.FunSuite:
  test(f"$name: empty string"):
    assertEquals(wordCount(Nil), 0)

  test(f"$name: 1 word with one space before"):
    assertEquals(wordCount(" hello".toList), 1)

  test(f"$name: 1 word with two spaces before"):
    assertEquals(wordCount("  hello".toList), 1)

  test(f"$name: 1 word with one space after"):
    assertEquals(wordCount("hello ".toList), 1)

  test(f"$name: 1 word with two spaces after"):
    assertEquals(wordCount("hello  ".toList), 1)

  test(f"$name: 1 word with one space before and after"):
    assertEquals(wordCount(" hello ".toList), 1)

  test(f"$name: 2 words with one space between"):
    assertEquals(wordCount("hello world".toList), 2)

  test(f"$name: 2 words with two spaces between"):
    assertEquals(wordCount("hello  world".toList), 2)

  test(f"$name: 2 words with one space before and after"):
    assertEquals(wordCount(" hello world ".toList), 2)

  test(f"$name: 3 words with one space between"):
    assertEquals(wordCount("hello world again".toList), 3)

class WordCountTests
    extends WordCountTestsT("wordCount", wordCount)
class WordCountSMTests
    extends WordCountTestsT("wordCountSM", WordCount.wordCountSM)
