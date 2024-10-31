package comprehensions

import collection.immutable.List
import scala.util.Random.shuffle
import scala.util.Random.nextInt
import java.util.Locale

def onlyThreeLetterWords(words: List[String]): List[String] =
  for
    word <- words
    if word.length() == 3
  yield word

def louder(words: List[String]): List[String] =
  for
    word <- words
  yield word.toUpperCase()

def echo(words: List[String], n: Int): List[String] =
  for
    word <- words
    i <- 0 until n
  yield word

def allTogether(words: List[String], n: Int): List[String] =
  for
    word <- words
    i <- 0 until n
    if word.length() == 3
  yield word.toUpperCase()

def crossProduct[A, B](l1: List[A], l2: List[B]): List[(A, B)] =
  for
    el <- l1
    el2 <- l2
  yield (el, el2)

type NodeId = Int
type DirectedEdge = (NodeId, NodeId)
type DirectedGraph = List[DirectedEdge]

def triangles(edges: DirectedGraph): List[(NodeId, NodeId, NodeId)] =
  for
    el1 <- edges
    if (el1._1 < el1._2)
    el2 <- edges
    if (el1._2 == el2._1 && edges.contains((el2._2, el1._1)))
    if (el1._1 < el2._2 && el2._1 != el2._2)
  yield (el1._1, el1._2, el2._2)
