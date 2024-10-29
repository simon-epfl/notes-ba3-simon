package patmat

object TriBoolOps:
  import TriBool.*

  def neg(b: TriBool): TriBool =
    b match
      case Yes => No
      case No => Yes
      case Maybe => Maybe

  def and(b1: TriBool, b2: TriBool): TriBool =
    (b1, b2) match
      case (No, _) => No
      case (_, No) => No
      case (Maybe, _) => Maybe
      case (_, Maybe) => Maybe
      case (Yes, Yes) => Yes

  def or(b1: TriBool, b2: TriBool): TriBool =
    (b1, b2) match
      case (Yes, _) => Yes
      case (_, Yes) => Yes
      case (No, No) => No
      case _ => Maybe

  def nand(b1: TriBool, b2: TriBool): TriBool =
    (b1, b2) match
      case (No, _) => Yes
      case (_, No) => Yes
      case (Yes, Yes) => No
      case _ => Maybe
