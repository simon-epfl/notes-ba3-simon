package comprehensions

def factorial(n: Int): Int =
  if n == 0 then 1 else factorial(n - 1) * n

def fastExp(base: Int, exp: Int): Int =
  if (exp == 0) then 1
  else if (exp == 1) then base
  else if exp % 2 == 0 then fastExp(math.pow(base, 2).toInt, exp/2) else base * fastExp(base, exp - 1)

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match
    case (Nil, _) => ys
    case (_, Nil) => xs
    case (xHead :: xTail, yHead :: yTail) =>
      if (xHead < yHead) xHead :: merge(xTail, ys)
      else yHead :: merge(xs, yTail)

def split[A](l: List[A]): (List[A], List[A]) =
  def splitHelper(l: List[A], i: Int): (List[A], List[A]) =
    l match
      case head :: next =>
        val s = splitHelper(next, i + 1)
        if i %2 == 0 then (head :: s._1, s._2) else (s._1, head :: s._2)
      case Nil => (Nil, Nil)

  splitHelper(l, 0)

def mergeSort(xs: List[Int]): List[Int] =
  xs match
    case head :: Nil => List(head)
    case Nil => Nil
    case head :: next =>
      val (left, right) = split(xs)
      merge(mergeSort(left), mergeSort(right))

def decimalToBaseN(number: Int, base: Int, acc: List[Int] = Nil): List[Int] =
  if (number == 0) then acc
  else decimalToBaseN(number/base, base, number % base :: acc)

def coinChange(coins: List[Int], amount: Int): Int =
  if (amount < 0 ) then 0
  else if (amount == 0) then 1
  else coins match
    case Nil => 0
    case head :: next => coinChange(next, amount) + coinChange(coins, amount - head)
