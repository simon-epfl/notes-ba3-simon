package comprehensions

import collection.immutable.List
import scala.util.Random.shuffle
import scala.util.Random.nextInt
import java.util.Locale

def onlyThreeLetterWords(words: List[String]): List[String] =
  ???

def louder(words: List[String]): List[String] =
  ???

def echo(words: List[String], n: Int): List[String] =
  ???

def allTogether(words: List[String], n: Int): List[String] =
  ???

def crossProduct[A, B](l1: List[A], l2: List[B]): List[(A, B)] =
  ???

type NodeId = Int
type DirectedEdge = (NodeId, NodeId)
type DirectedGraph = List[DirectedEdge]

def triangles(edges: DirectedGraph): List[(NodeId, NodeId, NodeId)] =
  ???
