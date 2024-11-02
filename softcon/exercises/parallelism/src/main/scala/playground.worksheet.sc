import parallelism.*
import ParMap.*
import ParSum.*
import ParMatMul.*

Vector(1, 5, 3, 8, -1).map_vector(x => x + 1)
Array(1, 5, 3, 8, -1).map_array_par2(x => x + 1)(new Array(5))
Array(1, 5, 3, 8, -1).map_array_parN(x => x + 1)(new Array(5))
List(1, 5, 3, 8, -1).map_list(x => x + 1)

Vector(1, 5, 3, 8, -1).sum_vector
Array(1, 5, 3, 8, -1).sum_array

val shifter = Matrix(Array(
  Array(2, 0, 0, 2, 0),
  Array(0, 2, 0, 0, 2),
  Array(0, 0, 2, 0, 0)
), 3, 5)

val arrow = Matrix(Array(
  Array(1, 0, 0),
  Array(0, 2, 0),
  Array(0, 0, 3),
  Array(0, 0, 3),
  Array(0, 2, 0),
  Array(1, 0, 0)
), 6, 3)

ParMatMul.matmul(arrow, shifter)

ParCumSum.cumsum_sequential(Vector(1, 5, 3, 8, -1))
ParCumSum.cumsum_par2(Vector(1, 5, 3, 8, -1))

