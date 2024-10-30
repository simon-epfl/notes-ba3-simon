package comprehensions

def filter_traced(l: Seq[Int]): Seq[Int] =
  for
    n <- l
    if n % 5 == 0
    _ = println(f"$n is a multiple of 5!")
    if n % 3 == 0
    _ = println(f"  $n is also a multiple of 3!")
    if n >= 10
    _ = println(f"    $n is also greater than 10!")
  yield n

def traceIfTrue(b: Boolean, label: String) =
  if b then println(label)
  b

def filter_tracedIfTrue(l: Seq[Int]): Seq[Int] =
  for
    n <- l
    if traceIfTrue(n % 5 == 0, f"$n is a multiple of 5!")
    if traceIfTrue(n % 3 == 0, f"  $n is also a multiple of 3!")
    if traceIfTrue(n >= 10, f"    $n is also greater than 10!")
  yield n

def badZip[T1, T2](l1: List[T1], l2: List[T2]): Seq[(T1, T2)] =
  for i <- (0 to math.min(l1.length, l2.length) - 1)
  yield (l1(i), l2(i))
