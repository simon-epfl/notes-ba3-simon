package exceptions

class ExceptionTests extends munit.FunSuite:
  def testContains(contains: [T] => (List[T], T) => Boolean) =
    assert(!contains(List(), 1))
    assert(!contains(List(), 3))
    assert(contains(List(1, 2), 1))
    assert(contains(List(1, 2, 3), 1))
    assert(contains(List(1, 2, 3, 4), 4))

  test("containsRec"):
    testContains([T] => (l: List[T], t: T) => l.containsRec(t))

  test("containsFold"):
    testContains([T] => (l: List[T], t: T) => l.containsFold(t))

  test("containsExn"):
    testContains([T] => (l: List[T], t: T) => l.containsExn(t))

  test("containsBoundary"):
    testContains([T] => (l: List[T], t: T) => l.containsBoundary(t))

  def testFind(find: [T] => (List[T], T => Boolean) => Option[T]) =
    assertEquals(find(List(), _ == 1), None)
    assertEquals(find(List(), _ == 3), None)
    assertEquals(find(List(1, 2), _ == 1), Some(1))
    assertEquals(find(List(1, 2, 3), _ == 1), Some(1))
    assertEquals(find(List(1, 2, 3, 4), _ == 4), Some(4))

  test("findBoundary"):
    testFind([T] => (l: List[T], p: T => Boolean) => l.findBoundary(p))
