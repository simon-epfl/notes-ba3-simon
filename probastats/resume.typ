#let intinf = $integral_(-infinity)^(+infinity)$

#let stick-together(a, threshold: 3em) = {
  block(a + v(threshold), breakable: false)
  v(-1 * threshold)
}

#let note_block(body, class: "Block", fill: rgb("#FFFFFF"), stroke: rgb("#000000")) = {

  locate(loc => {
        
    v(2pt)

    stick-together(
      text(12pt, weight: "bold")[Exemple] +
      v(-8pt) +
      block(fill:fill,
        width: 100%,
        inset:8pt,
        radius: 4pt,
        stroke:stroke,
        body)
    )
  })
}

#let example(body) = note_block(
  body, class: "Exemple", fill: rgb("#FFF4E0"), stroke: rgb("#F4B183")
)

= Rappels utiles

== Valeur d'une somme

$ sum_(x=0)^(∞) q^x = 1/(1 - q) " si " |q| < 1 $

== Indicator Function

$ I("some expression") = cases(
  1 "if the expression is true",
  0 "otherwise"
) $

== Conditional probability

$ P(A|B) = P(A sect B) / P(B) $

= Distributions

- *probability mass function* pour les distributions discrètes (binomiale, poisson, etc), *probability density function* pour les distributions continues (exponentielle, normale, etc).
- "distribution function" #sym.equiv "cumulative distribution function". Donc quand on nous demande la distribution function d'une variable c'est la fonction qui $forall t " donne " P(X <= t)$.
- Quand on demande la PDF souvent c'est plus simple de trouver la CDF puis de dériver.

= P.D.F #sym.arrow.double.r.l CDF

On a la P.D.F $f(x)$ et on veut la C.D.F $G(y)$, avec $Y = 1/X$.

D'abord on définit nos fonctions pour passer de $x$ à $y$ :

$ r(x) = 1/x " et " s(y) = 1/y $

$ G(y) = P(Y <= y) = P(1/X <= y) = P(X >= 1/y) = 1 - P(X < 1/y) $
$ G(y) = 1 - F(1/y) $

$ (d G(y)) / (d y) = d(1 - F(1/y))/(d y) $

$ g(y) = - (d F)/(d y)(1/y)dot|-1/(y^2)| "(on s'intéresse à la croissance, on enlève le signe -") $

$ g(y) = - f(1/y) dot 1/y^2 $

Et ensuite pour trouver $G(y)$ on intègre.

#pagebreak()

= Expected Value

Continue : $ intinf f_D (x) x d x $

Attention, c'est la P.D.F. qu'on intègre, parfois il faut dériver la C.D.F.

= Variance

$ "var"(X) = E(X^2) - E(X)^2 $

donc, quand continue : $ "var"(X) = intinf f_D (x) x^2 d x - E(X)^2 $

Standard deviation : $ sigma = sqrt("var"(X)) $

if $X_1$ et $X_2$ independent:
$ "var"(X_1 + a X_2) = "var"(X_1) + a^2"var"(X_2) $

== Covariance

$ "cov"(X, Y) = E(X Y) - E(X)E(Y) $

if $X, Y$ are independent then the covariance is zero (the converse is false!).

Linearité de la covariance :
$ "cov"(X+Y,Z+W)="cov"(X,Z)+"cov"(X,W)+"cov"(Y,Z)+"cov"(Y,W) $

Nous permet de réécrire la variance de la somme de variables aléatoires :
$ "var"(a + b X + c Y) = b^2"var"(X) + 2 b c "cov"(X, Y) + c 2 "var"(Y) $

== Correlation

$ "corr"(X, Y) = "cov"(X, Y)/({"var"(X)"var"(Y)}^(1/2)) $

#pagebreak()

= Moments

On appelle $E(X^r)$ le $r$th moment de $X$.

== Moment Generating Function 

$ psi(t) = E(e^(t X)) $

$ = integral_(-infinity)^(+infinity) e^(t x) f_X (x) d x $

Comme on sait que dériver l'espérance de X revient à prendre l'espérance de la dérivée de X (ça apparemment ça marche pas dans tous les cas mais ici oui) :

$ E(X^n) = phi^((n)) (0) $

Comme ça le `t` s'annule et il reste juste tous les facteurs $X$ devant qui s'accumulent.

$ E(X) = psi' (0) " et " E(X^2) = psi^'' (0) $
$ "var"(X) = psi''(0) - (ψ'(0))^2 $

On sait que si $X$ et $Y$ sont indépendantes alors $E(f(X) dot g(Y)) = E(f(X)) dot E(g(Y))$ (prouver avec l'intégrale de $x y f_(X,Y)(x, y)$) donc on peut souvent exprimer la MGF d'une variable aléatoire comme le produit des MGF de ses composantes.

#pagebreak()

= Central Limit Theorem

is a formal statement of how normal distributions can approximate
distributions of general sums or averages of i.i.d. random variables.

The simple version of the central limit theorem that we give in this section says that whenever a random sample of size n is taken from any distribution with mean $mu$ and variance $sigma^2$, the sample average $X_n$ will have a distribution that is approximately normal with mean $mu$ and variance $sigma^2/n$.

#pagebreak()


== Joint random variables

=== Conditional pdf (2 variables)

$ f_(X \/ Y) (x \/ y) = integral_(- infinity)^(+ infinity) f_(X, Y)(x, y)f_Y (y) d y $

#pagebreak()

== Law of total variance

$ "var"(Z) = E_N ("var"(Z|N)) + "var"_N (E(Z|N)) $
