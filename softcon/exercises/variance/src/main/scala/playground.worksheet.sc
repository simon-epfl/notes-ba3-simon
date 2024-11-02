import variance.*

// class Empty extends IntSet:
//   def contains(x: Int): Boolean = false
//   def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())
//   override def toString: String = "."

// class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
//     def contains(x: Int): Boolean =
//         if x < elem then left contains x
//         else if x > elem then right contains x
//         else true
//     def incl(x: Int): IntSet =
//         if x < elem then NonEmpty(elem, left incl x, right)
//         else if x > elem then NonEmpty(elem, left, right incl x)
//         else this
//     override def toString: String = "{" + left + elem + right + "}"

// class IntSet:
//     def contains(x: Int): Boolean
//     def incl(x: Int): IntSet

// val a: Array[NonEmpty] = Array(NonEmpty(1, Empty(), Empty()))
// val b: Array[IntSet] = a
// b(0) = Empty()
// val s: NonEmpty = a(0)
