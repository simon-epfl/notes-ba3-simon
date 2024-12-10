#show link: underline
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

== Théorème Spectral

On peut décomposer une matrice symétrique $A$ en $A = Q Lambda Q^T$ où $Q$ est une matrice orthogonale (rotation) et $Lambda$ est une matrice diagonale (scalation).

== Série de Taylor

Expontielle : $ e^x = sum_(n=0)^(∞) x^n / n! $

== Valeur d'une somme

$ sum_(x=0)^(∞) q^x = 1/(1 - q) " si " |q| < 1 $

== Indicator Function

$ I("some expression") = cases(
  1 "if the expression is true",
  0 "otherwise"
) $

== Analyse dimensionnelle

Si on intègre $f_X$ on trouve une probabilité, donc par exemple une CDF.

Si on intègre $f_(X Y)$ une fois, on trouve une autre fonction de densité de probabilité (de $X$ ou de $Y$), qu'on peut intégrer pour trouver une probabilité.21

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

$ "var"(X + Y) = "var"(X) + "var"(Y) + 2 "cov"(X, Y) $

== Covariance

$ "cov"(X, Y) = E(X Y) - E(X)E(Y) $

if $X, Y$ are independent then the covariance is zero (the converse is false!).

Linearité de la covariance :
$ "cov"(X+Y,Z+W)="cov"(X,Z)+"cov"(X,W)+"cov"(Y,Z)+"cov"(Y,W) $

Nous permet de réécrire la variance de la somme de variables aléatoires :
$ "var"(a + b X + c Y) = b^2"var"(X) + 2 b c "cov"(X, Y) + c 2 "var"(Y) $

=== Covariance matrix

Pour un vecteur de variables aléatoires $(X_1, ..., X_p)$

$ "var"(X) = Omega = mat(
  "var"(X_1), "cov"(X_1, X_2), ..., "cov"(X_1, X_p);
  "cov"(X_2, X_1), "var"(X_2), ..., "cov"(X_2, X_p);
  ..., ..., ..., ...;
  "cov"(X_p, X_1), "cov"(X_p, X_2), ..., "var"(X_p);
) $

Sachant que $"cov"(X_i, X_j) = "(notamment)" "corr"(X_i, X_j) sigma_i sigma_j$

Pour un vecteur $(X_1, X_2)$ de correlation $p$ et de variance $sigma_1, sigma_2$ :

$ Omega = mat(
  sigma_1^2, p sigma_1 sigma_2;
  p sigma_1 sigma_2, sigma_2^2
) $

== Correlation

$ "corr"(X, Y) = "cov"(X, Y)/({"var"(X)"var"(Y)}^(1/2)) $
$ "corr"(X, Y) = (E(X Y) - E(X)E(Y)) / {"var"(X)"var"(Y)}^(1/2) $

toujours entre -1 et 1. \
une corrélation de 0 ne signifie pas que les variables sont indépendantes (il peut y avoir d'autres types de corrélation).

#pagebreak()

= Moments

On appelle $E(X^r)$ le $r$th moment de $X$.

== Moment Generating Function 

$ psi(t) = E(e^(t X)) $

$ = E(sum_(n=0)^(∞) (X^n t^n) / n!) = sum_(n=0)^(∞) t^n/n! E(X^n) $

(on peut sortir les $t$ et $n$ de l'espérance car ils ne dépendent pas de $X$)

$ = integral_(-infinity)^(+infinity) e^(t x) f_X (x) d x $

Comme on sait que dériver l'espérance de X revient à prendre l'espérance de la dérivée de X (ça apparemment ça marche pas dans tous les cas mais ici oui) :

$ E(X^n) = phi^((n)) (0) $

Comme ça le `t` s'annule et il reste juste tous les facteurs $X$ devant qui s'accumulent.

$ E(X) = psi' (0) " et " E(X^2) = psi^'' (0) $
$ "var"(X) = psi''(0) - (ψ'(0))^2 $

On sait que si $X$ et $Y$ sont indépendantes alors $E(f(X) dot g(Y)) = E(f(X)) dot E(g(Y))$ (prouver avec l'intégrale de $x y f_(X,Y)(x, y)$) donc on peut souvent exprimer la MGF d'une variable aléatoire comme le produit des MGF de ses composantes.

=== Pour un vecteur

Soit $X in RR^p$ un vecteur aléatoire et $t in RR^p$ :

En fait les $t$ c'est juste des points dans l'espace par rapport auxquels on va dériver. On utilise que $t = 0$ pour avoir la valeur.

On transpose $t$ pour pouvoir faire le produit scalaire.

$ psi(t) = E(e^(t^T X)) = E(e^(t_1 X_1 + ... + t_p X_p)) = E(e^(t_1 X_1)...e^(t_p X_p)) $
$ = psi_1(t_1) ... psi_p (t_p) $

L'espérance de la ième composante du vecteur $X$ : $ (partial psi(t)) / (partial t_i) |_(t = 0) = E(X_i)$ \
Le vecteur d'espérance est : $nabla psi(t)|_(t = 0) = E(X)$

=== Cumulant Generating Function

$ K(t) = log(psi(t)) $

Pratique car moins de calcul que la MGF pour trouver :
$ K'(0) = E(X) = mu " et " K''(0) = "var"(X) = sigma^2 $

#pagebreak()

= Central Limit Theorem

is a formal statement of how normal distributions can approximate
distributions of general sums or averages of i.i.d. random variables.

The simple version of the central limit theorem that we give in this section says that whenever a random sample of size n is taken from any distribution with mean $mu$ and variance $sigma^2$, the sample average $X_n$ will have a distribution that is approximately normal with mean $mu$ and variance $sigma^2/n$.

(la variance diminue avec la taille de l'échantillon)

for sums of random variables, the central limit theorem says that the distribution of the sum will be approximately normal with mean $n mu$ and variance $n sigma^2$.

#emoji.warning attention quand on approxime avec des nombres petits on doit faire attention à utiliser les bonnes bornes
$ P(X <= x) eq.not 1 - P(X > x)$ mais $ P(X <= x) eq 1 - P(X < x + epsilon)$
(ou $epsilon = 1$ dans le cas d'un entier)

#pagebreak()


== Joint random variables

=== Conditional pdf (2 variables)

$ f_(X \/ Y) (x \/ y) = integral_(- infinity)^(+ infinity) f_(X, Y)(x, y)f_Y (y) d y $

#pagebreak()

== Law of total variance

$ "var"(Y) = E["Var"(Y|X)] + "Var"(E[Y|X]) $

Le premier terme a du sens : la variance de $Y$ c'est la moyenne des variances de $Y$ sachant que $X$ est égal à une valeur particulière. Mais on doit aussi prendre en compte que le fait que $Y\/X$ varie beaucoup ou soit lisse influence aussi la variance de $Y$. \
#link("https://math.stackexchange.com/questions/1742578/law-of-total-variance-intuition")[See this thread].

#pagebreak()

= Multivariate normal distributions

Le vecteur $X$ suit une distribution normale multivariée si toute combinaison linéaire de ses composantes suit une distribution normale univariée, c-a-d $forall u in RR^p$:

$ u^T X tilde cal(N)(u^T mu, u^T Omega u) $

== Combinaisons linéaires de normales

Les combinaisons lin de variables normales sont normales :

$ a_(r times 1) + B_(r times p) X tilde cal(N)(a + B mu, B Omega B^T) $

== indépendants

Si on a $X_1, .., X_n$ indépendants #sym.tilde $cal(N)(mu, sigma^2)$ then $X_(n times 1) = (X_1, ..., X_n)^T tilde cal(N)_n(mu 1_n, sigma^2 I_n)$

Le $1_n$ c'est pour transformer la moyenne en un vecteur de taille $n$. \
Le $I_n$ c'est pour avoir une matrice diagonale de taille $n$ (parce que comme les variables sont indépendantes, la matrice de covariance est diagonale).

// Si on a $V = u + N(0, Omega) => V tilde N_p(u, Omega) $

// $D^(-1/2)u^t (V - u)$ donne une distrib normale $N(u, I)$

=== Conditional

Let $ X tilde cal(N)(mu_(p times 1), Omega_(p times p)) $ (en bref, $X$ est une variable aléatoire normale de dimension $p$).

Maintenant, si on connaît une ou plusieurs des composantes (normales, donc) de $X$, on peut calculer la distribution conditionnelle des autres composantes. Et ce sera une distribution normale aussi.

Mettons qu'on connaisse l'ensemble $cal(B)$ des composantes et qu'on cherche la distribution conditionnelle des autres, on obtient 
$ (X_cal(A)|X_cal(B) = x_(cal(B))) tilde cal(N)(mu_A + Omega_(A, B)Omega_(B, B)^(-1)(x_(cal(B)) - mu_B), Omega_(A, A) - Omega_(A, B)Omega_(B, B)^(-1)Omega_(B, A)) $

où $Omega_(A, B)$ est la matrice des covariances où on garde les lignes $A$ et les colonnes $B$.

#emoji.warning Parfois $Omega_(A, A)$ s'écrit $Omega_A$.

= Transformations

p. ex. on veut savoir si le res du dé est pair ou non :

$ {1, 2, 3, 4, 5, 6} = g^-1(cal(B))$
$ {0, 1} = cal(B)$

On prend un sous-ensemble de $B$.

= Markov inequality

If $X$ takes only real positive values.
Let $a in RR^star$. Then :
$ P(X > a) <= E(X)/a $

= Convolution

$ f_Z(z) = integral_(- infinity)^(+ infinity) f_X (z - y) f_Y (y) d y $

En fait là on cherche tous les moyens d'arriver à un certain $z$ donc on ne fait varier que $y$, et après on complète avec le $x$ qui reste.

maintenant, si on cherche :

$ F_Z(z) = P(Z <= z) $
$ = integral_0^z integral_0^(z - y) f_X (z - y) f_Y (y) d x d y $

= Inequalities

Let $X$ a random variable, $a > 0$, $h$ a non-negative function and $g$ a convex function.

Basic inequality : $ P(h(X) > a) <= E(h(X))/a $
Markov's inequality : $ P(|X| > a) <= E(|X|)/a $
Chebyshov's inequality : $ P(|X| > a) <= E(X^2)/a^2 $
or $ P(|X - E(X)| > a) <= "var"(X)/a^2 $
Jensen's inequality : $ E(g(X)) >= g(E(X)) $

#pagebreak()

= Convergence

From the strongest to the weakest.

== in mean square

$ lim_(n -> infinity) E((X_n - X)^2) = 0 $ where $E(X_n^2), E(X^2) < infinity$

== in probability

$ lim_(n -> infinity) P(|X_n - X| > epsilon) = 0 $ for all $epsilon > 0$

(square it and use Markov's inequality to prove that mean square convergence implies convergence in probability)

== in distribution

$ lim_(n -> infinity) F_n (x) = F(x) $ for all $x$ where $F$ is continuous.

== conv. probability #sym.arrow.double.not conv. mean square

On prend $X_n$ telle que la proba d'être zéro est forte et la proba d'être très grand est faible et $X = 0$.
- $PP(X_n = 0) = 1 - 1/n$
- $PP(X_n = n) = 1/n$

On a $PP(|X_n - X| > epsilon) = PP(|X_n - 0| > epsilon) = P(1/n > epsilon)$ qui tend vers $0$ à l'infini donc $X_n$ converge en probabilité vers $0$.

($E((X_n - X)^2) = E(X_n^2) = 1/n dot n^2 = n$ donc $X_n$ ne converge pas en moyenne quadratique).

== conv. in distribution #sym.arrow.double.not conv. in probability

On prend $X_0$ choisi uniformément entre $0$ et $1$ et $X_(2n) = X_0$ (donc $X_(2n)$ est constant). On prend $X_(2n + 1) = 1 - X_0$.

$X_(2n)$ suit donc une distribution uniforme $tilde U[0, 1]$ et $X_(2n + 1) tilde U[0, 1]$ aussi (montrons-le avec la CDF, si on veut la probabilité que $X_(2n + 1) <= 0.2$ on veut la probabilité que $1 - X_0 <= 0.2$ on veut $X_0 >= 0.8$, or $X_0$ est uniforme donc $PP(X_0 <= 0.2) = PP(X_0 >= 0.8)$). Donc $X_n$ converge en distribution vers $X_0$.

Par contre, $X_n$ ne converge pas en probabilité : $ PP(|X_n - X_0| > epsilon) = PP(|X_(2n) - X_0| > epsilon and |X_(2n + 1) - X| > epsilon) $
$ = PP(|X_0 - X_0| > epsilon and |1 - X_0 - X_0| > epsilon) $
$ = 0 + q $

$q eq.not 0$ car il y a des exemples où $1- 2 X_0 eq.not 0$ (par exemple si $X_0 = 0.2$).

Donc $X_n$ ne converge pas en probabilité.

#pagebreak()

= Law of large numbers

Let $X_1, X_2, ..., X_n$ be i.i.d. random variables with $E(X_i) = mu$ (finite), then the sample average $X_n = (X_1 + ... + X_n)/n$ converges in probability to $mu$.

= Maximum and minimum distributions

$ P(min(X_1, ..., X_n) < x) $
$ = 1 - P(min(X_1, ..., X_n) >= x) $
$ = 1 - P(X_1 >= x, ..., X_n >= x) $
$ = 1 - P(X_1 >= x) ... P(X_n >= x) $
$ = 1 - (1 - F(x))^n $

= Statistics

$Y_1, ..., Y_n$ are i.i.d. random variables and $y_1, ..., y_n$ are the observed values.

We will assume that the distribution of $Y$ is $f(y, theta)$ where $theta$ is a parameter.

== Method of moments

We have this dataset from that we want to recover normal distribution parameters.

We know that theorically $E(Y) = mu$ and that $ 1/n sum_(i=1)^(n) y_i = mu $.
We also know that theorically $"var"(Y) = sigma^2$ and that $ 1/n sum_(i=1)^(n) (y_i - mu)^2 = sigma^2 $
Therefore we can estimate $mu$ and $sigma^2$ from the dataset.

== Maximum likelihood estimation (MLE)

The *likelihood* is defined as $L(theta) = f(x_1 sect x_2 sect ... sect x_n, theta) = product_(i=1)^(n) f(x_i, theta)$
(since all the $x_i$ are independent)

We want to find the value of $theta$ that maximizes the likelihood.

To do so, we usually take the log of the likelihood - because it's easier to work with and because the log is a monotonic function - and then we differentiate it with respect to $theta$ (e.g. with respect to $mu$ and $sigma^2$) and set it to zero, then solve for $theta$.

En fait en faisant ça on maximise la probabilité que les données observées soient générées par le modèle.

== M-estimation 

généralisation de la méthode du MLE

On utilise pas forcément L, mais n'importe quelle fonction $rho$.
Dans le cas du MLE $rho(x, theta) = log(f(x, theta))$.

$rho$ est souvent concave (comme ça on a un seul maximum) et différentiable.

On peut p. ex prendre $rho(x, theta) = -(x - mu)^2$ pour la "least squares estimation".

== Bias

$ "bias"(theta) = E(hat(theta)) - theta $

p. ex. pour une distrib normale :
$ "bias"(hat(mu)) = E(hat(mu)) - mu = E(1/n sum_(i=1)^(n) y_i) - mu = mu - mu = 0 $
mais 
$ "bias"(hat(sigma)^2) = E(hat(sigma)^2) - sigma^2 = ... = - sigma^2 / n $

For example,
an estimator that is equally likely to underestimate g(θ) by 1,000,000 units or to
overestimate g(θ ) by 1,000,000 units would be an unbiased estimator, but it would
never yield an estimate close to g(θ). Therefore, the mere fact that an estimator is
unbiased does not necessarily imply that the estimator is good or even reasonable.