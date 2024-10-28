package recursion

def treeSize(t: IntTree): Int =
  ???

def treeDepth(t: IntTree): Int =
  t match
    case IntBranch(value, left, right) => 1 + scala.math.max(treeDepth(left), treeDepth(right))
    case IntEmptyTree() => 0

def treeSum(t: IntTree): Int =
  t match
    case IntBranch(value, left, right) => value + treeSum(left) + treeSum(right)
    case IntEmptyTree() => 0

def treeAllEven(t: IntTree): Boolean =
  ???

def treeIncrement(t: IntTree): IntTree =
  t match
    case IntBranch(value, left, right) => IntBranch(value + 1, treeIncrement(left), treeIncrement(right))
    case IntEmptyTree() => IntEmptyTree()

def treeShow(t: IntTree): String =
  t match
    case IntBranch(value, left, right) =>
      value.toString + "\n" + treeShow(left) + treeShow(right)
    case IntEmptyTree() => ""
  

def treeShowPostOrder(t: IntTree): String =
  t match
    case IntBranch(value, left, right) =>
      treeShow(left) + treeShow(right) + value.toString + "\n"
    case IntEmptyTree() => ""
