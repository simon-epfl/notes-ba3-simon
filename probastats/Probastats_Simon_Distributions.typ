#set page(width: 30cm, height: 50cm)

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

== Uniforme

#table(
  columns: (auto, auto, auto, auto, auto, auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [], [*Description*], [*E*], [*Var*], [*PDF/PMF*], [*CDF*], [*MFG*],
  ),
  "Uniforme",
  [Modélise une variable aléatoire *continue* qui prend des valeurs dans un intervalle $[a, b]$.],
  [$ (a + b)/2 $],
  [$ (b - a)^2/12 $],
  [$ 1/(b - a) $],
  [$ (x - a)/(b - a) $],
  [$ (x - a)/(b - a) " si " a <= x <= b $],
)

== Exponentielle, Gamma et Poisson

#table(
  columns: (auto, auto, auto, auto, auto, auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [], [*Description*], [*E*], [*Var*], [*PDF/PMF*], [*CDF*], [*MFG*],
  ),
  "Poisson",
  [Il modélise la probabilité qu'un certain nombre d'évènements (donc variable *discrète*) se produisent durant une période de temps ou d'espace, à partir d'un taux $lambda$. \ \ C'est une approximation de la loi binomiale pour un $p$ très petit et un $n$ très grand (on a $lambda = n p$)],
  [$ lambda $],
  [$ lambda $],
  [$ lambda^x/x! e^(-lambda) $],
  [$ e^(-lambda) sum_(k=0)^(x) (lambda^k)/k! $],
  [$ e^(lambda(e^t - 1)) $],
  "Exponentielle",
  [Modélise le temps entre deux évènements dans un processus de Poisson. Elle est *continue* et *memoryless*. #example[
  Si un client arrive toutes les 2 minutes, $lambda = 1/2$. La probabilité qu'un client arrive durant une période de 7 minutes est $1 - e^(-0.5 dot 7)$. La probabilité qu'un client arrive durant une période de 7 minutes *sachant que* 8 minutes se sont déjà écoulées est identique. Car les évènements sont *indépendants* entre eux (peu importe qui est venu avant au magasin).
]],
  [$ 1/lambda $],
  [$ 1/lambda^2 $],
  [$ lambda e^(-lambda t) $ si t > 0 sinon 0],
  [$ 1 - e^(-lambda t) $],
  [$ lambda/(lambda - t) " si " t < lambda $],
  "Gamma",
  [La distribution gamma est utilisée pour modéliser le temps d'attente avant $alpha$ évènements dans un processus de Poisson. L'exponentielle est un cas particulier de la gamma avec $alpha = 1$. $beta$ est le taux. $Gamma(alpha) = (alpha - 1)!$ si $alpha$ est un entier.],
  [$ alpha/beta $],
  [$ alpha/(beta^2) $],
  [$ (lambda^alpha)/(Gamma(alpha)) x^(alpha - 1)e^(-lambda x) $ si x > 0 sinon 0],
  [],
  [],
)

== Binomiale, Géométrique, Hypergéométrique

#table(
  columns: (auto, auto, auto, auto, auto, auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [], [*Description*], [*E*], [*Var*], [*PDF/PMF*], [*CDF*], [*MFG*],
  ),
  "Binomiale",
  [Modélise le nombre de succès dans $n$ essais indépendants (donc v.a. *discrète*), avec une probabilité $p$ de succès à chaque essai.],
  [$ n p $],
  [$ n p (1 - p) $],
  [$ binom(n,x) p^x (1 - p)^(n - x) $],
  [$ sum_(k=0)^(x) binom(n, k) p^k (1 - p)^(n - k) $],
  [$ (1 - p + p e^t)^n $],
  "Binomiale négative",
  [Modélise le nombre d'essais nécessaires (donc v.a. *discrète*) pour obtenir $r$ succès, avec une probabilité $p$ de succès à chaque essai.],
  [$ r(1-p)/p $],
  [$ r (1 - p)/p^2 $],
  [$ binom(x + r - 1, k) p^r (1 - p)^x$],
  [],
  [],
  "Géométrique",
  [Modélise le nombre d'essais nécessaires (donc v.a. *discrète*) pour obtenir un succès.],
  [$ 1/p $],
  [$ (1 - p)/p^2 $],
  [$ p (1 - p)^(x - 1) $],
  [$ 1 - (1 - p)^(floor(x)) $],
  [$ p e^t/(1 - (1 - p) e^t) $ for $t < -log(1 - p)$],
  "Hypergéométrique",
  [Modélise le nombre de succès dans un échantillon de taille $n$ sans remise (donc v.a. *discrète*), avec $K$ succès dans la population de taille $N$.],
  [$ n K/N $],
  [$ n K/N (N-K)/N (N- n)/(N - 1) $],
  [$ (binom(K, x) binom(N - K, n - x))/binom(N, n) $],
  [$ sum_(k=0)^(x) (binom(K, k) binom(N - K, n - k))/binom(N, n) $],
  [],
)

= Distribution normale 

aussi appelée "courbe de Gauss", distribution Gaussienne, en cloche :

#table(
  columns: (auto, auto, auto, auto, auto, auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [], [*Description*], [*E*], [*Var*], [*PDF/PMF*], [*CDF*], [*MFG*],
  ),
  "Normale",
  [Elle est symétrique autour de sa moyenne $mu$ et son écart-type $sigma$ contrôle la largeur de la cloche.],
  [$ mu $],
  [$ sigma^2 $],
  [$ 1/(sigma sqrt(2 pi)) e^(-(x - mu)^2/(2 sigma^2)) $],
  [$ Phi((x - mu)/sigma) $],
  [$ e^(mu t + sigma^2 t^2/2) $],
  "Normale standard",
  [La normale standard est centrée autour de 0 et a un écart-type de 1.],
  [$ 0 $],
  [$ 1 $],
  [$ 1/sqrt(2 pi) e^(-x^2/2) $],
  [$ Phi(x) $],
  [$ e^(t^2/2) $],
)

Si on veut $Phi(1.51)$, on prend la ligne $1.5"(colonne)"$ et la colonne 1.

#image("posts/tablenorm.png")

#table(
  columns: (auto, auto, auto, auto, auto, auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [], [*Description*], [*E*], [*Var*], [*PDF/PMF*], [*CDF*], [*MFG*],
  ),
  "Multinomiale",
  [Modélise la répartition de $n$ essais dans $k$ catégories avec probabilité $p_1, ..., p_k$],
  [$ (p_1 dot n, ..., p_k dot n) $],
  [],
  [],
  [],
  [],
  "Multivariate normale",
  [Un vecteur $X$ de normales suit une normale s'il existe des coefficients $u$ tel que $u^T X$ (la combinaison linéaire des normales) suit une normale $cal(N)(u^T mu, u^T Omega u)$],
  [$ (mu_1, ..., mu_k) $],
  [$ Omega $],
  [],
  [],
  [$ exp(t^T mu + 1/2 t^T Omega t) $],
)
