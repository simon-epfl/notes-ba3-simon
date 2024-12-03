package memo
import scala.collection.mutable.Map

def choose(n: Int, k: Int): Int =
  ???

def chooseMemo(n: Int, k: Int): Int =
  ???

def chooseIter(n: Int, k: Int): Int =
  ???

def chooseIterFinal(n: Int, k: Int): Int =
  ???

def chooseIterFinalOpt(n: Int, k: Int): Int =
  if k <= 0 || k >= n then 1
  else
    var col = Array.fill(math.min(n, k) + 1)(1)
    for
      nn <- 2 to n
      kk <- math.min(k, nn - 1) until 0 by -1
    do
      col(kk) = col(kk - 1) + col(kk)
    col(k)

def chooseIterFinalGC(n: Int, k: Int): Int =
  if k <= 0 || k >= n then 1
  else
    val arrLen = n - k + 1
    val diag = Array.fill(arrLen)(1)
    for
      _ <- 1 to k
      i <- 1 until arrLen
    do
      diag(i) = diag(i) + diag(i - 1)
    diag(n - k)
