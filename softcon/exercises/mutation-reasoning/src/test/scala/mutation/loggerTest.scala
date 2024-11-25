package mutation.logger

class LoggerTest extends munit.FunSuite:
  def removeLineBreaks(s: String) = s.replaceAll("\\r|\\n", "")
  def normalizeLineBreaks(s: String) = s.replaceAll("\\r|\\n", "\n")
  def indentSizes(output: String) =
    normalizeLineBreaks(output).split("test").flatMap(_.split("\n")).filter(_.size > 0).map(_.size)

  test("BufferedLogger: empty when initialized"):
    val l = new LoggerBuffered
    assert(l.getOutput.isEmpty)

  test("BufferedLogger: last logged message is at the end of the output"):
    val l = new LoggerBuffered

    l.log("Hello, world!")
    l.log("I do not know what to log.")
    l.log("Monads are monoids in the category of endofunctors!!!")

    val s = "Why are you looking at me?"
    l.log(s)
    assert(removeLineBreaks(l.getOutput).endsWith(s))

  test("BufferedLogger: there is no indentation if the depth is 0"):
    val l = new LoggerBuffered
    l.log("test", 0)
    val sizes = indentSizes(l.getOutput)
    assert(sizes.isEmpty || sizes(0) == 0)

  test("BufferedLogger: depth is actually shown as an indentation (either space/tab or any character)"):
    val l = new LoggerBuffered
    l.log("test", 1)
    val indents = normalizeLineBreaks(l.getOutput).split("test").flatMap(_.split("\n")).filter(_.size > 0)
    assert(!indents.isEmpty)

  test("BufferedLogger: depth is proportional to the indentations"):
    val l = new LoggerBuffered
    l.log("test", 1)
    l.log("test", 2)
    l.log("test", 3)
    val sizes = indentSizes(l.getOutput)
    assert(sizes(0) > 0)
    assert(sizes(0) * 2 == sizes(1))

class EvalLoggerTest extends munit.FunSuite:
  import mutation.logger.EvalLogging.*
  import mutation.logger.EvalLogging.Expr.*

  class MockLogger extends Logger:
    var logs: List[(String, Int)] = List()

    def log(output: String, depth: Int) =
      logs = logs :+ (output, depth)

  test("eval with logger: logs correctly a constant (initial depth is 0)"):
    testConstantLog(123, 0)

  test("eval with logger: logs correctly a constant (with different depths)"):
    testConstantLog(123, 1)
    testConstantLog(123, 2)
    testConstantLog(123, 152)

  test("eval with logger: Add(1, 2) returns the proper result"):
    val logger = new MockLogger
    assert(eval(Add(Constant(1), Constant(2)), logger) == 3)

  test("eval with logger: Sub(1, 2) returns the proper result"):
    val logger = new MockLogger
    assert(eval(Sub(Constant(1), Constant(2)), logger) == -1)

  test("eval with logger: Add(1, 2) logs properly"):
    val logger = new MockLogger
    eval(Add(Constant(1), Constant(2)), logger)
    assert(!logger.logs.isEmpty)
    val logs = logger.logs
    assert(logs(0) == ("Constant(1) + Constant(2) ->", 0))
    assert(logs(1) == ("Constant(1) = 1", 1))
    assert(logs(2) == ("Constant(2) = 2", 1))
    assert(logs(3) == ("= 3", 0))

  test("eval with logger: Sub(1, 2) logs properly"):
    val logger = new MockLogger
    eval(Sub(Constant(1), Constant(2)), logger)
    assert(!logger.logs.isEmpty)
    val logs = logger.logs
    assert(logs(0) == ("Constant(1) - Constant(2) ->", 0))
    assert(logs(1) == ("Constant(1) = 1", 1))
    assert(logs(2) == ("Constant(2) = 2", 1))
    assert(logs(3) == ("= -1", 0))

  test("eval with logger: Add(Constant(1), Sub(Constant(100), Constant(99))) evals to 2 and logs properly"):
    val logger = new MockLogger
    assert(eval(Add(Constant(1), Sub(Constant(100), Constant(99))), logger) == 2)
    assert(!logger.logs.isEmpty)
    val logs = logger.logs
    assert(logs(0) == ("Constant(1) + Sub(Constant(100),Constant(99)) ->", 0))
    assert(logs(1) == ("Constant(1) = 1", 1))
    assert(logs(2) == ("Constant(100) - Constant(99) ->", 1))
    assert(logs(3) == ("Constant(100) = 100", 2))
    assert(logs(4) == ("Constant(99) = 99", 2))
    assert(logs(5) == ("= 1", 1))
    assert(logs(6) == ("= 2", 0))

  def testConstantLog(n: Int, depth: Int) =
    val logger = new MockLogger
    eval(Constant(n), logger, depth)
    assert(!logger.logs.isEmpty)
    assert(logger.logs.size == 1)
    assert(logger.logs.contains((f"${Constant(n)} = $n", depth)))
