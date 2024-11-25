package hoare

def abs(x: Int): Int = {
  if x < 0 then -x else x
} ensuring (res =>
  ???
)

def find(l: List[Int], p: Int => Boolean): Option[Int] = {
  def loop(l: List[Int]): Option[Int] =
    var li = l
    while !li.isEmpty do
      assert(true)
      if p(li.head) then
        return Some(li.head)
      li = li.tail
      assert(true)
    None
  loop(l)
}
  .ensuring(res => ???)

def maxLoopList(l: List[Int]): Int =
  require(!l.isEmpty)
  ???

def maxLoopArray(a: Array[Int]): Int =
  require(!a.isEmpty)
  ???

def maxLoopArrayWithInvariant(a: Array[Int]): Int =
  require(a.size > 0)
  ???

def maxLoopListWithInvariant(l: List[Int]): Int =
  require(!l.isEmpty)
  ???

