package hoare

import scala.util.Random

class HoareTest extends munit.FunSuite:

  test("maxLoopList: list with one element returns that element"):
    assertEquals(maxLoopList(List(1)), 1)

  test("maxLoopList: list with two elements returns the max"):
    assertEquals(maxLoopList(List(1, 2)), 2)
    assertEquals(maxLoopList(List(2, 1)), 2)

  test("maxLoopList: list with 30 elements returns the max"):
    val list = Random.shuffle((1 to 30).toList)
    assertEquals(maxLoopList(list), 30)

  test("maxLoopArray: array with one element returns that element"):
    assertEquals(maxLoopArray(Array(1)), 1)

  test("maxLoopArray: array with two elements returns the max"):
    assertEquals(maxLoopArray(Array(1, 2)), 2)
    assertEquals(maxLoopArray(Array(2, 1)), 2)

  test("maxLoopArray: array with 30 elements returns the max"):
    val array = Random.shuffle((1 to 30)).toArray
    assertEquals(maxLoopArray(array), 30)
