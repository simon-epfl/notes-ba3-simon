== Line integrals

On veut intégrer $f(x, y) = z$ (en bleu) selon le cercle, que l'on paramétrise comme $arrow(r)(t) = g(t)arrow(i) + h(t)arrow(j)$.

#image("./posts/res_lineintegrals_bef.png", width: 50%)

On peut d'abord réécrire notre fonction comme $f(t) = f(g(t), h(t))$. Pourquoi ? Parce que les seuls points qui nous intéressent sont ceux selon $g(h), h(t)$ !

#image("./posts/res_lineintegrals_mid.png", width: 50%)

Notre fonction aurait pu être comme ça, mais on veut juste être sur les points du cercle.

#image("./posts/res_lineintegrals.png", width: 60%)

Ici on veut l'aire donc $ A_k = f(x_k, y_k)Delta s_k $
$ A_k = f(x_k, y_k)sqrt((Delta x_k)^2 + (Delta y_k)^2) $
$ arrow.double.r d A = f(g(t), h(t))sqrt(g'(t)^2 + h'(t)^2 )d t $

#image("./posts/gaussgreen.png")
#image("./posts/rotations.png")
#image("./posts/liresume.png")

#pagebreak()

== Trouver un potentiel

- compute  $integral_0^x F(t) d t$
- compute $integral_x^y F(t) d t$
- sum them

== Calculer une intégrale avec le Green's theorem

- bien choisir un sens pour la bordure (par ex)

#image("./posts/int_sens.png", width: 40%)

- $ integral_(delta Omega) F dot d arrow(s) = integral integral_omega "div"(F) d omega $

== Calculer une aire d'un graph

$ "par exemple, " Phi(t) = sqrt(s^2 + t^2) $
$ "on définit " arrow(r) = (s, t, Phi(t)) $

Calculer l'aire du graphe de $Phi$ sur $Omega$:

$ integral_Omega 1 norm((d arrow(r))/(d s) times (d arrow(r))/(d t)) d s d t $

$ (d arrow(r))/(d s) times (d arrow(r))/(d t) = 
mat(
  arrow(i), arrow(j), arrow(k);
  1, 0, (d Phi)/(d s);
  0, 1, (d Phi)/(d t)
) = (-(d Phi)/(d s), -(d Phi)/(d t), 1) $

$ arrow.double.r " (when taking the norm) " integral_omega sqrt(1 + ((d Phi)/(d s))^2 + ((d Phi)/(d t))^2) d s d t $


== Divergence Theorem

Il fonctionne en 2D et en 3D.

$ integral integral_(partial Omega) arrow(F) dot arrow(n) " " d arrow(S) = integral integral integral_(Omega) "div"(F) d x_1 d x_2 d x_3 $

$ integral integral_(partial Omega) arrow(F(Phi(arrow(x)))) dot arrow(n) dot norm(arrow(partial_s Phi) times arrow(partial_t Phi)) " " d arrow(S) = integral integral integral_(Omega) "div"(F) d x_1 d x_2 d x_3 $

Avec $arrow(n)$ le vecteur normal par rapport à la surface en chaque point. \
On définit une paramétrisation du volume $phi(x, y)$, et $Phi(x, y) = (x, y, phi(x, y))$. 

Note : on ajoute $norm(arrow(partial_s Phi) times arrow(partial_t Phi))$ comme on ajoute la dérivée, parce que comme $s$ et $t$ sont perpendiculaires, le cross-product $arrow(a) times arrow(b) = norm(a) dot norm(b) dot sin(hat(a b))$ avec $hat(a b) = pi/2$ donc juste $norm(partial_s Phi) dot norm(partial_t Phi)$. 

Pour trouver le vecteur normal :

$ arrow(n) = (partial_x Phi(arrow(x)) times partial_y Phi(arrow(x)))/(norm(partial_x Phi(arrow(x)) times partial_y Phi(arrow(x)))) $

$ arrow(n) = (partial_phi Phi(arrow(x)) times partial_y Phi(arrow(x)))/(norm(partial_x Phi(arrow(x)) times partial_y Phi(arrow(x)))) $

== Green's Theorem

Il fonctionne en 2D uniquement. On regarde sur la bordure comment ça tourne.

$ integral_(partial Omega) arrow(F) dot arrow(J) d l  = integral integral_(Omega) "curl" arrow(F)(x_1, x_2) d x_1 d x_2  $

avec $arrow(tau)$ la dérivée de la 

== Stoke's Theorem

Il fonctionne en 3D.

#image("posts/rotr.png")

== Déterminant Jacobienne

En coordonnées sphériques :

$ det = r^2 sin(theta)$

En coordonées polaires 

$ det = r$

#pagebreak()

= Distributions

La dérivée est trop "forte" pour considérer les fonctions avec des pics, mais alors comment dériver ces fonctions ?

== Dirac H

Par exemple, la Heaviside function : $H(x) = 1 " if " x >= 0 " else " 0$

La dérivée $H'(x) = epsilon(x)$ sera quasiment partout 0 sauf en un point (le jump). Comment avoir une fonction $H'$ comme ça ? En fait on peut considérer cette fonction comme une distribution.

On utilise ensuite une *test function* pour obtenir la densité entre deux points.

#image("posts/phitest.png", width: 80%)

$ phi arrow integral f(x) phi(x) d x $

#image("posts/phidistrib.png", width: 70%)

$D$ c'est l'ensemble des fonctions infinement dérivables (lisses) dont le support est contenu dans un certain intervalle.

== Montrer que T est une distribution

- montrer que $T$ est finite :
$ forall phi in D : |T(phi)| < infinity $

- montrer que $T$ est continue :
$ forall [a, b] subset R " " exists C > 0 " (peut dépendre de a, b) t.q " forall phi in D " t.q supp" (phi) subset [a, b] : $

$ |T(phi)| <= C sum_(i >= 0) max_(x in RR) |partial_x^i phi(x)| $

Pour montrer ça on peut par exemple prendre $i = 0$ et si ça suffit on peut s'arrêter là.

$ abs(integral_(-infinity)^(infinity) phi(x) d x) = abs(integral_a^b phi(x) d x) $
$ <= max_(x in RR) abs(phi(x)) integral_a^b 1 d x = (b - a) max_(x in RR) abs(phi(x)) $
$ <= (b - a) sum_(i >= 0) max_(x in RR) abs(partial_x^i phi(x)) $

Note : le support c'est le domaine de la fonction n'est pas zéro. \
Note 2 : $T$ peut être négative et $phi$ aussi.

== Distribution derivative

Le produit scalaire mesure à quel point deux vecteurs vont dans la même direction :

$ <X, Y> = sum_(i = 0)^n x_i y_i  $

Généralisation pour les fonctions continues :

$ <F_1, F_2> = integral_b^a F_1(x)F_2(x)d x $

Distribution derivative :

$ <f', phi> = - <f, phi'> = - integral f(x) phi'(x) d x $
$ = - [f(x) phi(x)]_0^(infinity) + integral phi(x)d x " or " phi(infinity) = 0 " (une test function vaut 0 en l'infini)" $
$ = integral phi (x) d x $

== Fourier series

Parseval's theorem :

$ 2 / T integral_0^T f(x)^2 d x = a_0^2/2 + sum_(n >= 1) (a_n^2 + b_n^2) $

== Dirichet

Dirichlet conditions (general version) : the Fourier series at $x$ converges whenever $f(x)$ is continuous at $x$.

$ F f(x_0) = lim_(h -> 0) 1/2 (f(x_0 + h) + f(x_0 - h)) $

== Coefficients

Pour trouver les coefficients :

$ a_0 = 1 / T integral_0^T f(x) d x $
$ a_n = 2 / T integral_0^T f(x) cos(2 pi n x / T) d x $
$ b_n = 2 / T integral_0^T f(x) sin(2 pi n x / T) d x $

(on intègre toujours là où la fonction est définie proprement, par exemple si on étend une fonction définie sur un intervalle fini, on étend de $-L$ à $L$ et pas de $0$ à $2L$, où il va y avoir un saut).

parce que ça se simplifie quand on multiplie :

$ integral_0^T cos((2 pi )/T n x) cos((2 pi )/T m x) d x $
$ = integral_0^T sin((2 pi )/T n x) sin((2 pi )/T m x) d x $
$ = cases(
  0 " if " n != m,
  T/2 " if " n = m
) $

== Complex Fourier series

instead of $cos$ and $sin$ we use $e^(i x)$ and $e^(-i x)$.

$ c_n = 1/T integral_0^T e^(-i (2 pi)/T n x) f(x) d x $

Liens entre $a_n$ et $b_n$ et $c_n$ :

$ c_n = a_n - i b_n $
$ a_n = (c_n + c_(-n))/2 $
$ b_n = (c_n - c_(-n))/(2 i) $

== Transformations de Fourier

Soit $f(x)$ une série de Fourier de coefficient $c_n$ pour une fonction de période $T$. Si on a une forme similaire, l'objectif c'est de toujours trouver une fonction $g(x)$ qui s'exprime en fonction de $f$.

Par exemple si on a :
$ f(x) = cases(
  2x " if " 0 < x < 0.5,
  2 - 2x " if " 0.5 < x < 1
) $

et $ g(x) = cases(
  x " if " 0 < x < pi,
  2 pi - x " if " pi < x < 2 pi
) $

Là on peut trouver que $g(x) = pi dot f(x / 2 dot 1/pi)$.

Le $1/(2 pi)$ c'est pour que la période soit $2 pi$.

Multiplier par $pi$ parce qu'on veut que ça aille pas de zero à 1 mais de 0 à pi.

Et on voit qu'en fait seule la multiplication par une constante change les coefficients de Fourier.

== Fourier Transform

$ cal(F)[f](alpha) = 1/sqrt(2 pi) integral_(-infinity)^(infinity) f(x)e^(-i alpha x) d x $

Inverse :

$ f(x) = 1/sqrt(2 pi) integral_(-infinity)^(infinity) cal(F)[f](alpha)e^(i alpha x) d alpha $

(the only change is the sign in the exponent)

En fait dans un sens on décompose notre fonction $f$ en une somme de fonctions périodiques avec des fréquences différentes (et on obtient une fonction $cal(F)[f](alpha)$ qui nous donne les coefficients de Fourier de ces fonctions périodiques en fonction de la fréquence). Et dans l'autre sens on reconstruit notre fonction $f$ en sommant ces fonctions périodiques.

== Dérivée

Transformée de Fourier à condition que $f$ tendent à 0 en l'infini (la preuve utilise l'intégration par partie et on utilise que $f(infinity) = f(-infinity) =  0$).

$ cal(F)[f'](alpha) = i alpha cal(F)[f](alpha) $

== Modulation

=== Scale in/out

$ g(t) = e^(-i b t) f(a t) $

$ arrow hat(g)(alpha) = 1/(|a|) hat(f)((alpha + b)/a) $

=== Intuition

Si on connaît $cal(F)[f](alpha)$. Soit $g(x) = f(2x)$.

$ cal(F)[g(x)](alpha) = 1/sqrt(2 pi) integral_(-infinity)^(infinity) f(2x)e^(-i alpha x) d x $

On pose $y = 2x$ donc $x = y/2$ et $d x = 1/2 d y$.

$ = 1/sqrt(2 pi) integral_(-infinity)^(infinity) f(y)e^(-i alpha y/2) 1/2 d y = 1/sqrt(2 pi) 1/2 integral_(-infinity)^(infinity) f(y)e^(-i alpha y/2) d y $
donc $alpha' = alpha / a$ et on multiplie par $1/(|a|)$.

Si on a $g(x) = f(x - b)$ alors $alpha' = alpha$ et on multiplie par $e^(-i b alpha)$.

=== Décalage

$ g(x) = f(x - b) $
$ arrow hat(g)(alpha) = e^(-i b alpha) hat(f)(alpha) $

=== Intuition

$ cal(F)[f(x - b)](alpha) = 1/sqrt(2 pi) integral_(-infinity)^(infinity) f(x - b)e^(-i alpha x) d x $

On pose $y = x - b$ donc $x = y + b$ et $d x = d y$.

$ = 1/sqrt(2 pi) integral_(-infinity)^(infinity) f(y)e^(-i alpha (y + b)) d y = 1/sqrt(2 pi) e^(-i b alpha) integral_(-infinity)^(infinity) f(y)e^(-i alpha y) d y $

#pagebreak()

Transformée de Fourier :

#table(
  columns: (auto, auto),
  inset: 10pt,
  align: horizon,
  table.header(
    [*F*], [*$hat(f)$*],
  ),
  $ 1/(t^2 + omega^2) $, $ hat(f) (alpha) = sqrt(pi / 2) e^(- omega |alpha|) $,
  $ e^(- omega |t|) / omega $, $ hat(f)(alpha) = sqrt(2 / pi) (1/(omega^2 + alpha^2)) $,
  $ sin(omega t) / t $, $ hat(f)(alpha) = cases(
    sqrt(pi / 2) " if " |alpha| < omega,
    0 " otherwise"
  ) $,
  $ cases(
    1 " if " |t| < b,
    0 " otherwise"
  ) $, $ hat(f)(alpha) = sqrt(pi / 2) sin(b alpha)/alpha $,
  $ e^(- omega^2 t^2) $, $ hat(f)(alpha) = 1/(sqrt(2) omega) e^(- ) $,
  $ t e^(- omega^2 t^2) $, $ hat(f)(alpha) = (- i alpha) / (2 sqrt(2) w^3) e^(- alpha^2 / (4 omega^2)) $,
  $ (4 t^2)/(omega^2 + t^2)^2 $, $ hat(f)(alpha) = sqrt(2 pi) (1/omega - |alpha|)e^(- omega |alpha|) $,
  $ cases(
    1 "if" b < t < c,
    0 "otherwise"
  ) $, $ hat(f)(alpha) = (e^(- i b alpha) - e^(- i c alpha))/(i alpha sqrt(2 pi)) $,
  $ cases(
    e^(- omega t) "if" t > 0,
    0 "otherwise"
  ) $, $ hat(f)(alpha) = 1/sqrt(2 pi) 1/(omega + i alpha) $,
  $ cases(
    e^(- omega t) "if" t > 0,
    0 "otherwise"
  ) $, $ hat(f)(alpha) = 1/(sqrt(2 pi) ( omega + alpha)) (exp(-(omega + i alpha)b) - exp(-(omega + i alpha)c)) $,
  $ cases(
    e^(- i omega t) "if" t > 0,
    0 "otherwise"
  ) $, $ hat(f)(alpha) = 1/(i sqrt(2 pi) ( omega + alpha)) (exp(-i (omega + alpha)b) - exp(-i (omega + alpha)c)) $,
)

#pagebreak()

== Poisson problem

=== Le petit.

Poisson problem : $ -Delta u = f$ with $a < x < b $ and $ u(a) = g_a$ and $ u(b) = g_b$.

Two auxiliary problems :
- $- Delta u^g (x) = 0$ with $u^g (a) = g_a $ and $ u^g (b) = g_b$. Le rôle de cette équation est de satisfaire les conditions limites. (I)
- $- Delta u^f (x) = f(x) $ with $u^f (a) = 0 $ and $ u^f (b) = 0$. Le rôle de cette équation est de satisfaire $- Delta u  = f$ sans modifier les conditions limites. (II)

If we solve these two problems, we can find the solution to the Poisson problem by $ u(x) = u^g (x) + u^f (x) $.

(I)
We know $- u'' (x) = 0 $ for all $x$ in $[a, b]$. So $u'(x) = c_1 $ and $u^g(x) = c_1 x + c_2 $. We can find $c_1$ and $c_2$ by the boundary conditions.

$ g_a = C_1 a + C_2$ and $g_b = C_1 b + C_2 $.

(II)
We use the Fourier series to solve this! For simplicity assume $[a,b] = [0, L]$ we extend $F$ to an odd period function with period $T=2L$. Odd periodic #sym.arrow only has sine terms. So we can write $f(x) = sum_(n >= 1) b_n sin(2 pi n x / T) $. Useful because odd function automatically satisfies $u^f (0) = u^f (L) = 0$. (because $sin(0) = 0$ and $sin(n pi) = 0$).

=== Le méchant.

$ - laplace u(x) + k^2 u(x) = f(x) $

On applique la Transformée de Fourier :

$ - cal(F)[laplace u(x)](alpha) + k^2 cal(F)[u(x)](alpha) = cal(F)[f(x)](alpha) $

$ - (i alpha)^2 cal(F)[u(x)](alpha) + k^2 cal(F)[u(x)](alpha) = cal(F)[f(x)](alpha) $

On factorise :

$ cal(F)[u(x)](alpha) = (cal(F)[f(x)](alpha)) dot 1 / (k^2 + alpha^2) $

On cherche $u(x)$ donc on applique la transformée inverse :

$ u(x) = 1 / sqrt(2 pi) integral_(-infinity)^(infinity) (cal(F)[f(x)](alpha)) dot 1 / (k^2 + alpha^2) e^(i alpha x) d alpha $

== Convolutions

On veut calculer $ integral_(-infinity)^(+infinity) f(z)g(x - z) d z $.

Là on choisit une fonction qui bouge, et une fonction qui reste fixe. On va donc séparer notre intégrale en plusieurs intervalles.

On sait qu'on veut $"borne_g_bas" <= x-z <= "borne_g_haut"$.

à partir de ça on sait que $ - "borne_g_haut" + x >= z >= - "borne_g_haut" + x $

(et on sait que le centre est en $x$). donc on va déplacer $x$ de telle sorte à ce que $- "borne_g_haut" + x <= x <= "borne_g_bas" + x$ soit sur une même définition de fonction de $g$.

=== Convolution Theorem

La transformée de Fourier de $f * g$ est $sqrt(2 pi) hat(f)(alpha) hat(g)(alpha)$. \
Et la transformée de Fourier de $cal(F)(f g)$ est $1/sqrt(2 pi) hat(f)(alpha) * hat(g)(alpha)$.
