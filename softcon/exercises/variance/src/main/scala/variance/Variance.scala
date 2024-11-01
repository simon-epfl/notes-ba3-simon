package variance

trait Stack[T]:
  /** Peek at the top of this stack */
  def peek(): Option[T]

  /** Create a new stack with one more entry, at the top */
  def push(t: T): Stack[T]
  /** Separate the top entry from the rest of the stack */
  def pop(): (Option[T], Stack[T])

def joinStacks[T](l: List[Stack[T]]): Stack[T] =
  ???

def mkStackInt(): Stack[Int] =
  ???

def mkStackString(): Stack[String] =
  ???

// Does this work?
// val tops = joinStacks(List(mkStackInt(), mkStackString()))

trait Drawer[T]:
  def get(): T
  def put(t: T): Drawer[T]

case class IncrementingDrawer(i: Int) extends Drawer[Int]:
  def get() = i - 1
  def put(j: Int) = IncrementingDrawer(j + 1)

trait Box[T]:
  /** Peek at the value inside the box */
  def unbox(): Option[T]

  /** Create a new box with the contents */
  def replace(t: T): Box[T]
  /** Create a new box by applying `f` to the contents of this one */
  def map[T2](f: T => T2): Box[T2]

trait HasTop[+T]:
  /** Peek at one value inside this container */
  def top: Option[T]

def joinTops[T](l: List[HasTop[T]]): List[T] =
  ???
