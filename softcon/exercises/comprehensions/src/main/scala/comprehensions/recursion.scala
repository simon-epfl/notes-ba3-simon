package comprehensions

def factorial(n: Int): Int =
  if n == 0 then 1 else factorial(n - 1) * n

def fastExp(base: Int, exp: Int): Int =
  if (exp == 0) then 1
  else if (exp == 1) then base
  else if exp % 2 == 0 then fastExp(math.pow(base, 2).toInt, exp/2) else base * fastExp(base, exp - 1)

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  ???

def split[A](l: List[A]): (List[A], List[A]) =
  ???

def mergeSort(xs: List[Int]): List[Int] =
    ???

def decimalToBaseN(number: Int, base: Int, acc: List[Int] = Nil): List[Int] =
  if (number == 0) then acc
  else decimalToBaseN(number/base, base, number % base :: acc)

def coinChange(coins: List[Int], amount: Int): Int =
    ???
