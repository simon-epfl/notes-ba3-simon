import patmat.*
import FuncContext.*
import EnumContext.LookupResult
import LookupResult.*

class FuncContextTest extends munit.FunSuite:
  test("lookup empty should yield `NotFound`") {
    assertEquals(lookup(empty, "a"), NotFound)
    assertEquals(lookup(empty, "x"), NotFound)
    assertEquals(lookup(empty, "123"), NotFound)
    assertEquals(lookup(empty, "000"), NotFound)
  }

  test("lookup should work for the context cons(\"a\", 1, cons(\"b\", 2, cons(\"c\", 3, empty)))") {
    val ctx = cons("a", 1, cons("b", 2, cons("c", 3, empty)))
    assertEquals(lookup(ctx, "a"), Ok(1))
    assertEquals(lookup(ctx, "b"), Ok(2))
    assertEquals(lookup(ctx, "c"), Ok(3))
    assertEquals(lookup(ctx, "d"), NotFound)
    assertEquals(lookup(ctx, "e"), NotFound)
  }

  test("lookup should work for cons(\"a\", 1, cons(\"a\", 2, cons(\"b\", 3, empty)))") {
    val ctx = cons("a", 1, cons("a", 2, cons("b", 3, empty)))
    assertEquals(lookup(ctx, "a"), Ok(1))
    assertEquals(lookup(ctx, "b"), Ok(3))
    assertEquals(lookup(ctx, "c"), NotFound)
  }

  test("erase: empty"):
    assertEquals(lookup(erase(empty, "a"), "a"), NotFound)
    assertEquals(lookup(erase(empty, "a"), "b"), NotFound)

  test("erase: singleton"):
    val ctx = cons("a", 1, empty)
    assertEquals(lookup(erase(ctx, "a"), "a"), NotFound)
    assertEquals(lookup(erase(ctx, "a"), "b"), NotFound)

  test("erase: length 2"):
    val ctx = cons("a", 1, cons("b", 2, empty))

    assertEquals(lookup(erase(ctx, "a"), "a"), NotFound)
    assertEquals(lookup(erase(ctx, "a"), "b"), Ok(2))
    assertEquals(lookup(erase(ctx, "a"), "c"), NotFound)

    assertEquals(lookup(erase(ctx, "b"), "a"), Ok(1))
    assertEquals(lookup(erase(ctx, "b"), "b"), NotFound)
    assertEquals(lookup(erase(ctx, "b"), "c"), NotFound)
