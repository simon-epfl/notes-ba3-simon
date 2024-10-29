import patmat.*
import IntTreeOps.*
import IntTree.*

class IntTreeOpsTest extends munit.FunSuite:
  test("treeMap: identity") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, _, _) = generate(maxDepth = 10)
      val tree1 = treeMap(tree, x => x)
      assertEquals(tree, tree1)
  }

  extension (tree: IntTree)
    def sum: Int = treeReduce(tree, _ + _)

  test("treeMap: plus one") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, reducer, mapper) = generate(maxDepth = 10)
      val tree1 = treeMap(tree, x => x + 1)
      assertEquals(tree1, mapper(x => x + 1))

      val sum = tree.sum
      val sum1 = tree1.sum
      assertEquals(sum, sum1 - tree.size)
  }

  test("treeMap: reset 0") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, reducer, mapper) = generate(maxDepth = 10)
      val tree1 = treeMap(tree, x => 0)
      assertEquals(tree1, mapper(x => 0))
      assertEquals(tree1.sum, 0)
  }

  test("treeReduce: constant zero") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, _, _) = generate(maxDepth = 10)
      if tree.size > 1 then
        val t = treeReduce(tree, (_, _) => 0)
        assertEquals(t, 0)
  }

  test("treeReduce: sum") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, reducer, _) = generate(maxDepth = 10)
      val t = treeReduce(tree, _ + _)
      val answer = reducer(_ + _)
      assertEquals(t, answer)
  }

  test("treeReduce: max") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, reducer, _) = generate(maxDepth = 10)
      val t = treeReduce(tree, _ max _)
      val answer = reducer(_ max _)
      assertEquals(t, answer)
  }

  test("treeReduce: prod") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, reducer, _) = generate(maxDepth = 10)
      val t = treeReduce(tree, _ * _)
      val answer = reducer(_ * _)
      assertEquals(t, answer)
  }

  test("treeMap preserves the size of trees") {
    (0 until 100).foreach: _ =>
      val TreeConfig(tree, _, _) = generate(maxDepth = 10)
      val tree1 = treeMap(tree, x => x * x)
      assertEquals(tree.size, tree1.size)
  }

  test("treeMapReduce: printer") {
    val mapper: Int => String = _.toString
    val reducer: (String, String) => String = (x, y) => f"($x $y)"
    def show(t: IntTree): String = treeMapReduce(t, mapper, reducer)
    assertEquals(show(Leaf(10)), "10")
    assertEquals(show(Branch(Leaf(10), Leaf(20))), "(10 20)")
    assertEquals(show(Branch(Leaf(10), Branch(Leaf(20), Leaf(30)))), "(10 (20 30))")
  }

  test("treeMapReduceDouble: sum of inverses") {
    val DELTA = 0.00001
    val mapper: Int => Double = x => 1.0 / x.toDouble
    val reducer: (Double, Double) => Double = _ + _

    assertEqualsDouble(treeMapReduceDouble(Leaf(1), mapper, reducer), 1.0, DELTA)
    assertEqualsDouble(treeMapReduceDouble(Leaf(2), mapper, reducer), 1.0 / 2.0, DELTA)
    assertEqualsDouble(treeMapReduceDouble(Branch(Leaf(2), Leaf(3)), mapper, reducer), 1.0 / 2.0 + 1.0 / 3.0, DELTA)
  }
