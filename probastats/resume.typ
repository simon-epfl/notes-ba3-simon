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

== Distributions

"distribution function" #sym.equiv "cumulative distribution function"

Donc quand on nous demande la distribution function d'une variable c'est la fonction qui $forall t " donne " P(X <= t)$.

Quand on demande la PDF souvent c'est plus simple de trouver la CDF puis de dériver.

== Indicator function

$ I("some expression") = cases(
  1 "if the expression is true",
  0 "otherwise"
) $

=== Distribution Exponentielle et Poisson

Poisson est utilisé pour des variables aléatoires discrète. Il modélise la probabilité qu'un certain nombre d'évènements se produise durant une période de temps ou d'espace, à partir d'un taux $lambda$.

$ f_X (x) = lambda^x/x! e^(-lambda) $

Poisson est une approximation de la loi binomiale pour un $p$ très petit et un $n$ très grand (on a $lambda = n p$).

Le temps entre deux occurences est modélisé par une distribution exponentielle.
La distribution exponentielle est *memoryless*.

$ f_D (t) = cases(
  lambda e^(-lambda t) " pour " t > 0,
  0 " sinon "
) arrow.double.r F(t) = 1 - e^(-lambda t) $

#example[
  Si un client arrive toutes les 2 minutes, $lambda = 1/2$. La probabilité qu'un client arrive durant une période de 7 minutes est $1 - e^(-0.5 dot 7)$. La probabilité qu'un client arrive durant une période de 7 minutes *sachant que* 8 minutes se sont déjà écoulées est identique. Car les évènements sont *indépendants* entre eux (peu importe qui est venu avant au magasin).
]

== Moments

- the $r$th moment of $X$ is $E(X^r)$.

== P.D.F #sym.arrow.double.r.l CDF

On a la P.D.F $f(x)$ et on veut la C.D.F $G(y)$, avec $Y = 1/X$.

D'abord on définit nos fonctions pour passer de $x$ à $y$ :

$ r(x) = 1/x " et " s(y) = 1/y $

$ G(y) = P(Y <= y) = P(1/X <= y) = P(X >= 1/y) = 1 - P(X < 1/y) $
$ G(y) = 1 - F(1/y) $

$ (d G(y)) / (d y) = d(1 - F(1/y))/(d y) $

$ g(y) = - (d F)/(d y)(1/y)dot|-1/(y^2)| "(on s'intéresse à la croissance, on enlève le signe -") $

$ g(y) = - f(1/y) dot 1/y^2 $

Et ensuite pour trouver $G(y)$ on intègre.

== Expected Value

Continue : $intinf f_D (x) x d x$

Attention, c'est la P.D.F. qu'on intègre, parfois il faut dériver la C.D.F.

== Variance

$"var"(X) = E(X^2) - E(X)^2$

donc, quand continue : $intinf f_D (x) x^2 d x - E(X)^2$

Standard deviation : $ sigma = sqrt("var"(X)) $

== Normal distribution

Impossible de calculer la CDF $Phi$ ! c'est pour ça qu'il existe des tables

aussi appelée "courbe de Gauss", en cloche :

$ f_D (x) = 1/(sigma sqrt(2 pi)) exp(-(x - mu)^2/(2 sigma^2)) $


$mu$ est la moyenne, l'espérance de la distribution \
$sigma$ est l'écart-type

=== Standard Normal Distribution

$ f_D (x) = phi(x) $

quand $mu = 0$ (donc centré autour de 0), et que $sigma = 1$.

$ Phi(x) = integral f_D (x) "  (la cdf)" $

==== Convertir en Standard Normal Distrib.

$ F(x) = Phi((x - mu)/sigma) $

#image("posts/tablenorm.png")

Si on veut $Phi(1.51)$, on prend la ligne $1.5"(colonne)"$ et la colonne 1.

== Joint random variables

=== Conditional pdf (2 variables)

$ f_(X \/ Y) (x \/ y) = integral_(- infinity)^(+ infinity) f_(X, Y)(x, y)f_Y (y) d y $
