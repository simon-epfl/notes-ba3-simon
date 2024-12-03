package exceptions

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@Warmup(iterations = 10, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 50, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
@Fork(1)
class SimpleBenchmark:
  // Use this file to define a benchmark and measure the relative performance of
  // the various implementations of `contains` that you've written!

  @Benchmark
  def exampleBenchmark =
    1 + 1

