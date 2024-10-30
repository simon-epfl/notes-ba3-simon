package comprehensions

import munit.FunSuite

class GlobTest extends FunSuite:
  def glob(pattern: String, input: String): Boolean =
    Glob.glob(pattern.toList, input.toList)

  test("glob(plain): true"):
    assert(glob("", ""))
    assert(glob("a", "a"))
    assert(glob("abcde", "abcde"))

  test("glob(plain): false"):
    assert(!glob("", "a"))
    assert(!glob("a", ""))
    assert(!glob("abcde", "abde"))

  test("glob(?): true"):
    assert(glob("?", "a"))
    assert(glob("a?c?e", "abcde"))
    assert(glob("?????", "abcde"))

  test("glob(?): false"):
    assert(!glob("?", "ab"))
    assert(!glob("a?c?e", "abde"))
    assert(!glob("a?c?e", "abcdef"))
    assert(!glob("?????", "abcdef"))

  test("glob(*): true"):
    assert(glob("*", ""))
    assert(glob("*", "a"))
    assert(glob("*", "abc"))
    assert(glob("a*b", "ab"))
    assert(glob("**", "abcde"))
    assert(glob("a**b", "ab"))
    assert(glob("a**b", "aabbb"))
    assert(glob("a*c*e", "abcde"))
    assert(glob("a*c*e", "aabbccddee"))
    assert(glob("abcdefg*", "abcdefg"))
    assert(glob("*abcdefg", "abcdefg"))

  test("glob(*): false"):
    assert(!glob("a*c*e", "abde"))
    assert(!glob("a*c*e", "abcdef"))
    assert(!glob("bcdefg*", "abcdefg"))
    assert(!glob("*abcdef", "abcdefg"))

  test("glob(all): true"):
    assert(glob("*?*?*", "ab"))
    assert(glob("20??-*.jp*", "2002-03-18T11:15.jpg"))
    assert(glob("20??-*.jp*", "2002-03-18 modified.jpeg"))
    assert(glob("20??-*.jp*g", "2002-03-18T11:15.jpg"))
    assert(glob("20??-*.jp*g", "2002-03-18 modified.jpeg"))

  test("glob(all): true"):
    assert(!glob("*?*?*?*", "ab"))
    assert(!glob("20??-*.jp*", "2002-03-18T11:15.xpg"))
    assert(!glob("20??-*.jp*", "1999-03-18 modified.jpeg"))
    assert(!glob("20??-*.jp*g", "2002-03-18T11:15.jbig2"))
    assert(!glob("20??-*.jp*g", "2002-03-18 modified.png"))
