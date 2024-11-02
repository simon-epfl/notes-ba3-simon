package parallelism

import scala.collection.parallel.mutable.ParArray
import org.openjdk.jmh.annotations.Benchmark
import parallelism.*

class TabulateBench:
  @Benchmark
  def studentTabulate =
    val f: Int => Int = x => 2 * x
    val limit = 10_000
    ParArray.parTabulate(limit)(f)
