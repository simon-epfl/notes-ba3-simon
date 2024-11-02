- récursion sur des `IntList`, ne pas oublier `IntCons(head, tail) =>` et pas `head :: tail -=>` comme dans une liste normale.

- on peut faire un `case IntCons(head, tail) if head > 0 =>` (ajouter un test supplémentaire dans le case).

- on utilise pas `Math.max` mais `scala.math.max`.

- ne pas oublier que les chaînes de caractères `String` disposent des propriétés `.head`, `.tail`, etc.

- ne pas oublier les `.toList` sur les `for comprehensions`.

- on peut créer des contextes :
```scala
enum Context:
  case Empty
  case Cons(name: String, value: Int, rem: Context)
```
Une clef associée à une valeur dans un contexte est appelée un "Binding".

- quand on a une fonction qui a besoin d'être polymorphique mais que les paramètres disposent d'une propriété (par exemple comparer les éléments entre eux comme dans le `mergeSort`, c'est bien de prendre en paramètre une fonction en plus, comme `mergeSort(t: List[T], lt: (x: T, y: T) => Boolean))`.

- ne pas oublier le `seq.splitAt`.

== Folds

#image("posts/folds.png")

Le fold right demande une base (qui sera un accumulateur), ici c'est 0.

== Reducers

#image("posts/reducers.png", width: 90%)

== Scala docs

=== Traits, Class, companion objects

Un trait est similaire à une interface Java :
```scala
trait EtreVivant {
  def respirer(): String
}
```
Une classe peut implémenter un ou plusieurs traits :
```scala
class Humain(val nom: String) extends EtreVivant {
  def respirer(): String = s"$nom est un humain qui respire."
  
  def marcher(): String = s"$nom est en train de marcher."
}
```
Un companion object permet de définir l'équivalent des méthodes statiques en Java :
```scala
object Humain {
  def apply(nom: String): Humain = new Humain(nom)

  // l'équivalent d'une méthode statique en Java
  def descriptionGenerale(): String = "Les humains sont des êtres vivants qui respirent et peuvent marcher."
}
```

=== Case class

```scala
case class WordCountState(count: Int, lastWasWS: Boolean)
```

automatiquement l'égalité par valeur (pas référence)

== Variance

=== Covariance

```scala
enum MyList[+A] {
  case Nil
  case Cons(head: A, tail: MyList[A])
}
```

ça nous permet d'écrire :

```scala
MyList[Chien] listeChiens = ... // blabla
MyList[Animal] listeAnimaux = listeChiens;
// compile ! ne compilerait pas en Java, ou sans le `+`. 
```

=== Contravariance

```scala
class Veterinaire[-A] {
  def heal(animal: A): Unit = animal.heal()
}
```

ça nous permet d'écrire :

```scala
class Animal {
  def heal(): Unit = println("Animal heals")
}

class Dog extends Animal {
  override def heal(): Unit = println("Dog heals")
}

val animalVeterinaire: Veterinaire[Animal] = new Veterinaire[Animal]
val dogVeterinaire: Veterinaire[Dog] = animalVeterinaire

dogVeterinaire.heal(new Dog()) // accepte des dog!
```

=== Invariance

Par défaut les `Array` scala sont invariants.

```scala
class Container[A](value: A) {
  def get: A = value
}
```

Par défaut, les types en scala sont invariants :

```scala
val dogContainer: Container[Dog] = new Container(new Dog)
val animalContainer: Container[Animal] = dogContainer  // Erreur de compilation
```

=== Bounds

```scala
S <: IntSet // S est un sous-type de IntSet ou un InSet lui-même
S >: IntSet // S est un super-type de IntSet ou un IntSet lui-même
S >: NonEmpty <: IntSet // S est un super-type de NonEmpty mais un sous-type de IntSet
```

=== Functions

Le sous-typage est en effet contravariant sur le type des paramètres et covariant sur le type de retour.

If `A2 <: A1` and `B1 <: B2`, alors `A1 => B1 <: A2 => B2`. \
"si ce que tu prends en entrée est plus large, et ce que tu donnes en sortie est plus précis, tu es un type plus large".

=== Variance in class

- covariant type parameters can only appear in method results.
- contravariant type parameters can only appear in method parameters.
```scala
val cats: List[Cat] = new List[Cat] { /* implémentation */ }
val animals: List[Animal] = cats  // Possible grâce à la covariance

animals.add(new Dog)  // Ceci serait permis si `add` acceptait un `T`
```
- invariant type parameters can appear anywhere.

== Tail recursion

(reverse )
