package comprehensions

import munit.FunSuite

import DesChiffres.*
import DesLettres.*

class DesLettresTest extends FunSuite:
  test("compatible: true cases"):
    assert(compatible("", ""))
    assert(compatible("", "AB"))
    assert(compatible("AB", "ABC"))
    assert(compatible("AC", "AC"))
    assert(compatible("ABC", "ABC"))
    assert(compatible("ABC", "ABCD"))

  test("compatible: false cases"):
    assert(!compatible("ABD", "ABC"))
    assert(!compatible("A", "D"))
    assert(!compatible("A", ""))
    assert(!compatible("AB", "AD"))

  test("scramble"):
    assertEquals(scramble(""), "")
    assertEquals(scramble("a"), "A")
    assertEquals(scramble("Ab"), "AB")
    assertEquals(scramble("bA"), "AB")
    assertEquals(scramble("Polytechnique"), "CEEHILNOPQTUY")

  test("scrambleList"):
    assertEquals(scrambleList(Set()), Map())
    assertEquals(
      scrambleList(Set("Polytechnique")),
      Map("CEEHILNOPQTUY" -> Set("Polytechnique"))
    )
    assertEquals(
      scrambleList(Set("Nale", "lean", "wasp", "swap")),
      Map("AELN" -> Set("Nale", "lean"), "APSW" -> Set("wasp", "swap"))
    )

  test("exactWord: true"):
    assertEquals(
      exactWord(Set("duck", "Stressed", "desserts"), "SSREDETS"),
      Set("Stressed", "desserts")
    )
    assertEquals(
      exactWord(Set("Polytechnique", "Eidgenössische"), "CEEHILNOPQTUY"),
      Set("Polytechnique")
    )

  test("exactWord: false"):
    assertEquals(
      exactWord(Set(), "ABC"),
      Set()
    )
    assertEquals(
      exactWord(Set("duck", "Stressed", "desserts"), "SSRENDETS"),
      Set()
    )
    assertEquals(
      exactWord(Set("Polytechnique", "Eidgenössische"), "RCEEHILNOPQTUY"),
      Set()
    )

  test("longestWord: true"):
    assertEquals(longestWord(Set(), "ABC"), Set())
    assertEquals(
      longestWord(Set("duck", "Stressed", "desserts"), "SSRENDETS"),
      Set("Stressed", "desserts")
    )
    assertEquals(
      longestWord(Set("Polytechnique", "Eidgenössische"), "RCEEHILNOPQTUY"),
      Set("Polytechnique")
    )
    assertEquals(
      longestWord(Set("duck", "Stressed", "desserts"), "SSREDETS"),
      Set("Stressed", "desserts")
    )
    assertEquals(
      longestWord(Set("Polytechnique", "Eidgenössische"), "CEEHILNOPQTUY"),
      Set("Polytechnique")
    )

class DesChiffresTest extends FunSuite:
  test("leCompteEstBon: empty list"):
    assertEquals(leCompteEstBon(List.empty[Int], 631), None)

  test("leCompteEstBon: easy feasible target"):
    assertEquals(leCompteEstBon(List(2, 3), 5).flatMap(_.value), Some(5))

  test("leCompteEstBon: easy infeasible target"):
    assertEquals(leCompteEstBon(List(2, 3), 7), None)

  test("leCompteEstBon: hard infeasible target"):
    assertEquals(leCompteEstBon(List(2, 2, 3, 4, 6, 10), 631), None)

  test("leCompteEstBon: hard feasible target"):
    assertEquals(leCompteEstBon(List(5, 9, 7, 4, 1, 6), 945).flatMap(_.value), Some(945))
