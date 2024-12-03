package memo

def fib(n: Int): Int =
  if n <= 1 then 1 else fib(n - 1) + fib(n - 2)

import scala.collection.mutable.Map

def fibMemo(n: Int): Int =
  val cache: Map[Int, Int] = Map()
  def loop(idx: Int): Int =
    cache.getOrElseUpdate(
      idx,
      if idx <= 1 then 1
      else loop(idx - 1) + loop(idx - 2)
    )
  loop(n)

import scala.collection.mutable.Map

def fibIter(n: Int): Int =
  val cache: Map[Int, Int] = Map()
  for idx <- 0 to n do
    cache(idx) =
      if idx <= 1 then 1 else cache(idx - 1) + cache(idx - 2)
  cache(n)

import scala.collection.mutable.Map

def fibIterOpt(n: Int): Int =
  val cache: Map[Int, Int] = Map()
  for idx <- 0 to n do
    cache(idx) =
      if idx <= 1 then 1 else cache(idx - 1) + cache(idx - 2)
    cache.remove(idx - 2)
  cache(n)

import scala.collection.mutable.Map

def fibIterFinal(n: Int): Int =
  var f0 = 1
  var f1 = 1
  for idx <- 2 to n do
    val f = f0 + f1
    f0 = f1
    f1 = f
  f1
