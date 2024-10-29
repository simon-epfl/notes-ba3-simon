import patmat.*

import IntList.*
import IntIntList.*

abstract class IntListOpsTestBase extends munit.FunSuite:
  def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList

  test("zipWith: both empty"):
    val res = zipWith(IntNil, IntNil, _ + _)
    assertEquals(res, IntNil)

  test("zipWith: left empty"):
    val res = zipWith(IntNil, IntCons(1, IntNil), _ + _)
    assertEquals(res, IntNil)

  test("zipWith: right empty"):
    val res = zipWith(IntCons(1, IntNil), IntNil, _ + _)
    assertEquals(res, IntNil)

  test("zipWith: same length"):
    val x = IntCons(1, IntCons(2, IntNil))
    val y = IntCons(2, IntCons(3, IntNil))
    val res = zipWith(x, y, _ + _)
    assertEquals(res, IntCons(3, IntCons(5, IntNil)))

  test("zipWith: left longer"):
    val x = IntCons(1, IntCons(2, IntCons(10, IntNil)))
    val y = IntCons(2, IntCons(3, IntNil))
    val res = zipWith(x, y, _ + _)
    assertEquals(res, IntCons(3, IntCons(5, IntNil)))

  test("zipWith: right longer"):
    val x = IntCons(1, IntCons(2, IntNil))
    val y = IntCons(2, IntCons(3, IntCons(10, IntNil)))
    val res = zipWith(x, y, _ + _)
    assertEquals(res, IntCons(3, IntCons(5, IntNil)))

class IntListOpsTest extends IntListOpsTestBase:
  override def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
    patmat.zipWith(l1, l2, op)

  test("extractSecond: empty"):
    assertEquals(extractSecond(IntNil), ExtractResult.EmptyList)

  test("extractSecond: not long enough"):
    assertEquals(extractSecond(IntCons(1, IntNil)), ExtractResult.NotLongEnough)

  test("extractSecond: good"):
    assertEquals(extractSecond(IntCons(1, IntCons(2, IntNil))), ExtractResult.SecondElem(2))

class IntListZipTest extends IntListOpsTestBase:
  override def zipWith(l1: IntList, l2: IntList, op: (Int, Int) => Int): IntList =
    patmat.zipThenWith(l1, l2, op)

  test("unzip: empty"):
    assertEquals(unzip(IntIntNil), (IntNil, IntNil))

  test("unzip: non-empty"):
    assertEquals(
      unzip(IntIntCons((1, 2), IntIntCons((2, 3), IntIntNil))),
      (IntCons(1, IntCons(2, IntNil)), IntCons(2, IntCons(3, IntNil)))
    )

  test("movingWindow: empty"):
    assertEquals(movingWindow(IntNil), IntIntNil)

  test("movingWindow: non-empty"):
    assertEquals(
      movingWindow(IntCons(1, IntCons(2, IntCons(3, IntNil)))),
      IntIntCons((1, 2), IntIntCons((2, 3), IntIntNil))
    )
