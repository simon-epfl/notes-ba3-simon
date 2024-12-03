package tailRecursion.lists

import scala.collection.mutable.Stack
import scala.util.Random

class GroupByTest extends munit.FunSuite:

  test("groupByForeach: empty list") {
    assertEquals(
      groupByForeach[Int, Int](_ % 2)(Nil),
      Map.empty[Int, List[Int]]
    )
  }

  test("groupByFoldRight: empty list") {
    assertEquals(
      groupByFoldRight[Int, Int](_ % 2)(Nil),
      Map.empty[Int, List[Int]]
    )
  }

  test("groupByForeach: list of int and f is modulo 2") {
    val l = Random.shuffle((1 to 100).toList)
    val res = groupByForeach[Int, Int](_ % 2)(l)
    assertEquals(res.keySet, Set(0, 1))
    assertEquals(res(0).toSet, l.filter(_ % 2 == 0).toSet)
    assertEquals(res(1).toSet, l.filter(_ % 2 == 1).toSet)
  }

  test("groupByFoldRight: list of int and f is modulo 2") {
    val l = Random.shuffle((1 to 100).toList)
    val res = groupByFoldRight[Int, Int](_ % 2)(l)
    assertEquals(res.keySet, Set(0, 1))
    assertEquals(res(0).toSet, l.filter(_ % 2 == 0).toSet)
    assertEquals(res(1).toSet, l.filter(_ % 2 == 1).toSet)
  }

  test("groupByForeach: list of string and f is first char") {
    val l = List("hello", "world", "hi", "scala", "haskell")
    val res = groupByForeach[String, Char](_.head)(l)
    assertEquals(res.keySet, Set('h', 'w', 's'))
    assertEquals(res('h').toSet, Set("hello", "hi", "haskell"))
    assertEquals(res('w').toSet, Set("world"))
    assertEquals(res('s').toSet, Set("scala"))
  }

  test("groupByFoldRight: list of string and f is first char") {
    val l = List("hello", "world", "hi", "scala", "haskell")
    val res = groupByFoldRight[String, Char](_.head)(l)
    assertEquals(res.keySet, Set('h', 'w', 's'))
    assertEquals(res('h').toSet, Set("hello", "hi", "haskell"))
    assertEquals(res('w').toSet, Set("world"))
    assertEquals(res('s').toSet, Set("scala"))
  }
