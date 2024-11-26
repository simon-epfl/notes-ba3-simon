package hoare

def abs(x: Int): Int = {
  if x < 0 then -x else x
} ensuring (res =>
  res >= 0
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
  var idx = 1;
  var max = a(0)
  while idx < a.size do
    idx += 1
    if a(idx) > max then max = a(idx)
  max

def maxLoopArrayWithInvariant(a: Array[Int]): Int =
  require(a.size > 0)
  ???

def maxLoopListWithInvariant(l: List[Int]): Int =
  require(!l.isEmpty)
  def invariant (l: List[Int], processedSize: Int, currentMax: Int) =
    l.take(processedSize).forall(_ <= currentMax) && l.take(processedSize).contains(currentMax)
  var list = l.tail
  var max = l.head
  assert(invariant(l, l.size - list.size, max))
  while !list.isEmpty do
    if list.head > max then
      max = list.head
    list = list.tail
    assert(invariant(l, l.size - list.size, max))
  max

