package poly

import poly.MyList.*

type NodeId = Int
type DirectedEdge = (NodeId, NodeId)
type DirectedGraph = MyList[DirectedEdge]
type Triangle = (NodeId, NodeId, NodeId)

def triangles(edges: DirectedGraph): MyList[Triangle] =
  ???
