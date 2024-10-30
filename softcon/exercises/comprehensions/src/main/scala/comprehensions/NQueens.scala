package comprehensions

def isSafe(col: Int, queens: List[Int]): Boolean =
  ???

def queens(n: Int) =
  def placeQueens(k: Int): Set[List[Int]] =
    if k == 0 then Set(List())
    else
      for
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      yield col :: queens
  placeQueens(n)
