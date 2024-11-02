import comprehensions.*
import DesLettres.*, DesChiffres.*

//onlyThreeLetterWords(List("Java", "Scala", "Rust", "C++", "Coq", "Lean"))

def traceIfTrue(b: Boolean, label: String) =
  if b then println(label)
  b

def filter_tracedIfTrue(l: Seq[Int]): Seq[Int] =
  for
    n <- l
    if traceIfTrue(n % 5 == 0, f"$n is a multiple of 5!")
    if traceIfTrue(n % 3 == 0, f"  $n is also a multiple of 3!")
    if traceIfTrue(n >= 10, f"    $n is also greater than 10!")
  yield n
