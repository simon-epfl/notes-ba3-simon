package comprehensions

import collection.immutable.List

type Triangle = (NodeId, NodeId, NodeId)
// Util function s.t.
// is_rotation((1,2,3), (2,3,1)) = true
def is_rotation(x1: Triangle, x2: Triangle) =
  x1 == x2 || (x1._1 == x2._2 && x1._2 == x2._3 && x1._3 == x2._1) || (x1._1 == x2._3 && x1._2 == x2._1 && x1._3 == x2._2)

class ForCompTest extends munit.FunSuite:
  val twoLetterWords: List[String] =
    List("at", "or", "be", "in", "to", "by")

  val threeLetterWords: List[String] =
    List("and", "tea", "ate", "for", "six", "try", "sin", "see")

  val fourLetterWords: List[String] =
    List("name", "tree", "list", "like")

  test("onlyThreeLetterWords: empty list returns empty list"):
    assertEquals(onlyThreeLetterWords(Nil), Nil)

  test("onlyThreeLetterWords: return the correct words in the right order"):
    assertEquals(onlyThreeLetterWords(threeLetterWords ++ twoLetterWords ++ fourLetterWords), threeLetterWords)

  test("onlyThreeLetterWords: returns empty list if no three letter words"):
    assert(onlyThreeLetterWords(twoLetterWords ++ fourLetterWords).isEmpty)

  test("louder: empty list returns empty list"):
    assertEquals(louder(Nil), Nil)

  test("louder: non-empty list returns non-empty list"):
    assertEquals(louder(List("a", "bc", "def", "ghij")), List("A", "BC", "DEF", "GHIJ"))

  test("echo(0): empty list returns empty list"):
    assertEquals(echo(Nil, 0), Nil)

  test("echo(1): empty list returns empty list"):
    assertEquals(echo(Nil, 1), Nil)

  test("echo(0): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 0), List())

  test("echo(1): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 1), List("a", "bc", "def", "ghij"))

  test("echo(2): non-empty list returns non-empty list"):
    assertEquals(echo(List("a", "bc", "def", "ghij"), 2), List("a", "a", "bc", "bc", "def", "def", "ghij", "ghij"))

  test("allTogether(0): empty list returns empty list"):
    assertEquals(allTogether(Nil, 0), Nil)

  test("allTogether(1): empty list returns empty list"):
    assertEquals(allTogether(Nil, 1), Nil)

  test("allTogether(0): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 0), List())

  test("allTogether(1): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 1), List("ALL", "NOW"))

  test("allTogether(2): non-empty list returns non-empty list"):
    assertEquals(allTogether(List("All", "together", "now"), 2), List("ALL", "ALL", "NOW", "NOW"))

  assert(is_rotation((1, 2, 3), (2, 3, 1)))
  assert(is_rotation((1, 2, 3), (3, 1, 2)))
  assert(is_rotation((1, 2, 3), (1, 3, 2)) == false)

  test("crossProduct: generate menu"):
    val mains = List("Burger", "Pizza", "Pasta")
    val sides = List("Salad", "Soup")
    val meals = List(
      ("Burger", "Salad"),
      ("Burger", "Soup"),
      ("Pizza", "Salad"),
      ("Pizza", "Soup"),
      ("Pasta", "Salad"),
      ("Pasta", "Soup")
    )
    assertEquals(crossProduct(mains, sides), meals)

  // The given example should be enough
  val example_edges = List((1, 2), (2, 3), (3, 1))

  test("triangles: return one triangle"):
    assertEquals(triangles(example_edges).size, 1)
  test("triangles: return the correct triangle"):
    assertEquals(triangles(example_edges)(0), (1, 2, 3))
