package serialization

import scala.util.{Try, Success, Failure}

class WireTest extends munit.FunSuite:
  test("FormulaWire.serialize and deserialize: Lit(true)"):
    val f = Formula.Lit(true)
    assertEquals(FormulaWire.deserialize(FormulaWire.serialize(f)), Success(f))

  test("FormulaWire.serialize and deserialize: Lit(false)"):
    val f = Formula.Lit(false)
    assertEquals(FormulaWire.deserialize(FormulaWire.serialize(f)), Success(f))

  test("FormulaWire.serialize and deserialize: Var(\"x\")"):
    val f = Formula.Var("x")
    assertEquals(FormulaWire.deserialize(FormulaWire.serialize(f)), Success(f))

  test("FormulaWire.serialize and deserialize: FnCall(\"f\", Nil)"):
    val f = Formula.FnCall("f", Nil)
    assertEquals(FormulaWire.deserialize(FormulaWire.serialize(f)), Success(f))

  test("FormulaWire.serialize and deserialize: FnCall(\"f\", List(Lit(true), Var(\"x\")))"):
    val f = Formula.FnCall("f", List(Formula.Lit(true), Formula.Var("x")))
    assertEquals(FormulaWire.deserialize(FormulaWire.serialize(f)), Success(f))

  test("FormulaWire.deserialize malformed inputs"):
    assert(FormulaWire.deserialize("notaformula").isFailure)
    assert(FormulaWire.deserialize("{\"parsing\" \"error ").isFailure)
    assert(FormulaWire.deserialize("{\"valid\": \"json\"}").isFailure)
    assert(FormulaWire.deserialize("{\"tag\": \"None\", \"value\": true}").isFailure)
    assert(FormulaWire.deserialize("{\"tag\": \"Var\"}").isFailure)
    assert(FormulaWire.deserialize(
      "{\"fn\": \"f\", \"args\": {\"tag\":\"Lit\", \"value\":true}}"
    ).isFailure)
    assert(FormulaWire.deserialize(
      "{\"fn\": \"f\", \"args\": [{\"tag\":\"Lit\", \"value\":true}]}"
    ).isFailure)
