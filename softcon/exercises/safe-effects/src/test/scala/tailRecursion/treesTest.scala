package tailRecursion.trees

class TreesTest extends munit.FunSuite:
  import Tree.*

  val exampleRightLineTree = Node(Leaf(5), Node(Leaf(10), Node(Leaf(4), Leaf(10))))
  val exampleTree = Node(Node(Leaf(5), Leaf(10)), Node(Leaf(4), Node(Leaf(2), Leaf(2))))

  test("`sumRightLineTree` computes correctly the sum") {
    assert(sumRightLineTree(exampleRightLineTree) == 29)
  }

  test("`sumRotate` computes correctly the sum") {
    assert(sumRotate(exampleTree, 0) == 23)
  }

  test("`sumLoop` computes correctly the sum") {
    assert(sumLoop(exampleTree) == 23)
  }

  test("`postOrderTraversal` works on the example") {
    val tree =
      Node(
        Node(
          Leaf(1),
          Leaf(2)
        ),
        Leaf(3)
      )
    val expected =
      List(
        Leaf(1),
        Leaf(2),
        Node(Leaf(1), Leaf(2)),
        Leaf(3),
        Node(Node(Leaf(1), Leaf(2)), Leaf(3))
      )

    assert(postOrderTraversal(tree) == expected)
  }

  test("`reduceLoop` works with an example tree and addition") {
    assert(reduceLoop(exampleTree, _ + _) == 23)
  }

  test("`reduceLoop` works with an example tree and substraction") {
    assert(reduceLoop(exampleTree, _ - _) == -9)
  }
