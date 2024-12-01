== Week 1

Call by value first resolves the "values" before calling the function, while call by name first calls the function, gets the results and then resolves them.

== Week 2

=== Take a function as a parameter:

```scala
def sum(f: Int => Int, a: Int, b: Int): Int =
  if a > b then 0
  else f(a) + sum(f, a + 1, b)
```

=== We can also generate functions using functions:

```scala
def sum(f: Int => Int): (Int, Int) => Int =
  def sumF(a: Int, b: Int): Int =
    if a > b then 0
    else f(a) + sumF(a + 1, b)
  sumF
```

```scala
def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorials = sum(fact)
```

```scala
sumCubes(1, 10) + sumFactorials(10, 20)
```

Generalization:

It's the same as creating a function that takes the `n-1` arguments, and one takes the last one:

```scala
def f(ps1)...(psn-1) = (psn ⇒ E)
```

=== Types

```
Type = SimpleType | FunctionType
FunctionType = SimpleType '=>' Type
| '( ' [ Types ] ') ' '= > ' Type
SimpleType = Ident
Types = Type { ' , ' Type }
```

=== Several ways of writing functions that return functions

```scala
def isGreaterThanBasic(x: Int, y: Int): Boolean =
  x > y
val isGreaterThanAnon: (Int, Int) => Boolean =
  (x, y) => x > y
val isGreaterThanCurried: Int => Int => Boolean =
  x => y => x > y // Same as `x => (y => x > y)`
def isGreaterThanCurriedDef(x: Int)(y: Int): Boolean =
  x > y
```

#sym.triangle Curried signifie que la fonction prend ses arguments un par un ! (en fait elle renvoie une nouvelle fonction à chaque fois)
C'est utile si on veut appliquer des transformations partielles (fixer le premier argument et retarder l'application du second).

== Week 3

#image("./posts/classsub.png", width: 80%)
#image("./posts/classsub2.png", width: 80%)

#image("./posts/extension.png", width: 80%)
#image("./posts/uextension.png", width: 80%)

#image("./posts/infixmethods.png", width: 80%)

Déterminée en fonction du caractère qui démarre l'opérateur:

#image("./posts/precedencerules.png", width: 80%)

#image("./posts/functionmethods.png", width: 80%)

== Types

Contravariance : quand un type plus général est utilisé pour un autre type
Covariance : quand un type plus précis est utilisé pour un autre type

```Scala
trait Printer[-A] {
  def print(value: A): Unit
}

val animalPrinter: Printer[Animal] = (animal: Animal) => println(s"Printing an animal: $animal")
val dogPrinter: Printer[Dog] = animalPrinter // ok, Printer[Animal] is a supertype of Printer[Dog]
```

== Mutations

*invariants* : propriétés qui doivent être vraies à chaque étape de l'exécution du programme (p. ex. dans une fonction qui calcule le maximum, un invariant pourrait être que le maximum doit être plus grand que tous les éléments déjà traités dans la liste ET présent dans la liste déjà traitée).
