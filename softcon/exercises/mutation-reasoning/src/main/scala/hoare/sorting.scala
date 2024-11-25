package hoare

def swap(a: Array[Int], i: Int, j: Int): Unit =
  val tmp = a(i)
  a(i) = a(j)
  a(j) = tmp

def ICantBelieveItCanSort(a: Array[Int]): Unit =
  for i <- 0 until a.length do
    for j <- 0 until a.length do
      if a(i) < a(j) then
        swap(a, i, j)

def insertionSort(a: Array[Int]): Unit =
  for i <- 1 until a.length do
    for j <- i until 0 by -1 do
      if a(j) < a(j - 1) then
        swap(a, j, j - 1)

def highlight(a: Array[Int], is: Int*) =
  a.toList.zipWithIndex.map((x, k) => if is.contains(k) then f"[$x]" else f" $x ").mkString(", ")

def ICantBelieveItCanSort_traced(a: Array[Int]): Unit =
  for i <- 0 until a.length do
    println(f">> i=$i")
    for j <- 0 until a.length do
      if a(i) < a(j) then
        println(f">  j=$j ${highlight(a, i, j)}")
        swap(a, i, j)
        println(f">  j=$j ${highlight(a, i, j)}")
