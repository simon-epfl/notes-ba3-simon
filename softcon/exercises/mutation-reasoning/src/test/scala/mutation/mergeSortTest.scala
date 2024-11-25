package mutation

class MergeSortTest extends munit.FunSuite:
  test("2 `merge` calls work on Array(16,1,12,4) with (startIndex: 0 and 2, width: 1)") {
    val a = List(16, 1, 12, 4).toArray
    val b = new Array[Int](a.size)
    merge(a, b, 0, 1)
    merge(a, b, 2, 1)
    assert(b.toList == List(1, 16, 4, 12))
  }

  test("`merge` works on Array(2,5,4,12) with width=2") {
    val a = List(2, 5, 4, 12).toArray
    val b = new Array[Int](a.size)
    merge(a, b, 0, 2)
    assert(b.toList == List(2, 4, 5, 12))
  }

  test("`sort` works on a randomized arrays of sizes 1, 2, 4, 8, 16 and 32") {
    import scala.util.Random

    for
      n <- 0 to 5
      k <- 1 to 5
    do

      val size = Math.pow(2, n).toInt
      val original = Seq.fill(size)(Random.nextInt(15))
      val a = original.toArray
      sort(a)
      assert(a.toList == a.toList.sorted)
  }
