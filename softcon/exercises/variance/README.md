A, B, C, D: A <: B and C <: D.

A2 <: A1 and B1 <: B2
A <: B C <: D
B => C <: A => D

List[Banana] <: List[Fruit]
List[A]	<: List[B]
Banana => Juice	:> Fruit => Juice
Banana => Juice	<: Banana => Liquid
A => C X B => D
List[Banana => Liquid] :> List[Fruit => Juice]
List[A => D] :> List[B => C]
(Fruit => Juice) => Liquid <: (Banana => Liquid) => Liquid
(B => C) => D	<:	(A => D) => D
Fruit => (Juice => Liquid) RIEN Banana => (Liquid => Liquid)
B => (C => D)	RIEN	A => (D => D)

for each:

- case class C[-A](a: A)

```scala
C[Dog] a = C(someRandomAnimal)
Dog a = a.a // erreur?
```

- trait C[-A]:
  def foo(f: A => Int): Int

```scala
C[Liquid] a = ...
a.foo(juice => int) // erreur!
```

- trait F[+A]:
  def f(a: A): A

```scala
F[Dog] f = ..
F[Animal] = f
f.f(animal) // oops
```

- trait Foldable1[+A]:
  def fold(a: A)(f: (A, A) => A): A

```scala
Foldable1[Dog] = ...
Foldable1[Animal] = fold(fox)(..) // erreur!
```
