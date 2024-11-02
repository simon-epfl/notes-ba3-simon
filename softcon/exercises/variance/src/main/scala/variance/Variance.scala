package variance

trait Stack[T]:
  /** Peek at the top of this stack */
  def peek(): Option[T]

  /** Create a new stack with one more entry, at the top */
  def push(t: T): Stack[T]
  /** Separate the top entry from the rest of the stack */
  def pop(): (Option[T], Stack[T])

class MyStack[+T](data: List[T] = Nil) extends Stack[T] {

  def peek(): Option[T] = if data.isEmpty then None else Some(data.head)

  def pop(): (Option[T], Stack[T]) =
    return (peek(), MyStack(data.tail))

  def push[S >: T](t: S): Stack[S] =
    return MyStack(t :: data)

}

def joinStacks[T](l: List[Stack[T]]): Stack[T] =
  MyStack(l.map(subL => subL.peek()).filter(el => el.isDefined).map(el => el.get))

def mkStackInt(): Stack[Int] = MyStack((0 until 8).toList)

def mkStackString(): Stack[String] = MyStack((0 until 8).toList.map(el => "coucou"))

//val tops = joinStacks(List(mkStackInt(), mkStackString()))

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
