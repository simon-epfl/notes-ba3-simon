package parallelism
import scala.compiletime.uninitialized

import scala.collection.parallel.CollectionConverters.*

class Worker[B] (v: => B) extends Thread:
  var value: B = uninitialized;
  override def run(): Unit = value = v

extension [A](seq: Seq[A])
  def parMap[B](f: A => B): Seq[B] =
    if (seq.length < 20) seq.map(f)
    else
      val (left, right) = seq.splitAt(seq.length / 2)
      val workerL = Worker(left.parMap(f))
      val workerR = Worker(right.parMap(f))
      workerL.start()
      workerR.start()
      workerL.join()
      workerR.join()
      workerL.value ++ workerR.value
