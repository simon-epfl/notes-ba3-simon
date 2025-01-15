Mes notes de cours (simon.lefort@epfl.ch) basées sur le cours de Martin Licht (section IC, automne 2024).
## Rappels

La norme du produit vectoriel de $\vec{x}$ et $\vec{b}$ :
$$ norm(x and y) = det mat(

"", "+", "-", "+";

"+", "axe1", "axe2", "axe3";

"-", "vect1x", "vect1y", "vect1z";

"+", "vect2x", "vect2y", "vect2z";

) $$

$$ \text{div} F(x) = \sum_{i = 1}^n \frac{\partial F_i}{\partial x_i} (x) $$

La divergence est positive si elle se comporte comme une source, négative si elle se comporte comme un puits.

$$ RR^2, "rot" F(x, y) = (diff F_2)/(diff x) (x, y) - (diff F_1)/(diff y) (x, y) $$
$$ RR^3, "rot" F(x, y, z) = ( (diff F_3)/(diff y) - (diff F_2)/(diff z), (diff F_1)/(diff z) - (diff F_3)/(diff x), (diff F_2)/(diff x) - (diff F_1)/(diff y)) = det(nabla times F) $$

La première coordonnée du rotationnel donne l'intensité de la rotation autour de l'axe x, la deuxième autour de l'axe y, la troisième autour de l'axe z.

$$ \Delta f(\vec{x}) = \sum_{i = 1}^n \frac{\partial^2 f}{\partial x_i^2}(\vec{x}) $$

Si le laplacien est strictement négatif, alors $f(x_0)$ est plus grande que sa valeur moyenne au tour de $x_0$, si le laplacien est strictement positif, alors $f(x_0)$ est plus petite que sa moyenne.  

Un ensemble $Omega subset.eq RR^n$ est dit **ouvert** si, pour tout point $x in Omega$, il existe une petite "boule" autour de $x$ qui est entièrement contenue dans $Omega$.

Un ensemble $Omega subset.eq RR^n$ est dit **convexe** si, pour tous les points $x,y in Omega$, le segment qui relie $x$ à $y$ est entièrement contenu dans $Omega$.

Un ensemble $Omega subset.eq RR^n$ est dit **connexe** si on peut aller d'un point $x in Omega$  à un autre point $y in Omega$ en restant **entièrement à l'intérieur de $Omega$**, c'est-à-dire si $Omega$ est d'un seul "morceau". Un ensemble **simplement connexe** est **connexe** et n'a pas de trou.

Pour prouver la convexité, on pose $a, b in Omega$ et $t in [0, 1]$ et on montre que $t a + (1 - t) b in Omega$.

La convexité est plus forte (on utilise un segment pour relier les deux points) que la simple connexité (on les relie avec un segment ou une courbe). Par exemple un domaine en étoile est simplement connexe mais pas convexe.

(et la notation $overline(Omega)$ **n'est pas** le complément de $Omega$, c'est l'adhérence, le complément est $Omega^c$).

Soient $f : RR arrow RR$,  $g : RR arrow RR$.
- $f$ paire $arrow$ $f(-x) = f(x)$
- $f$ impaire $arrow$ $f(-x) = -f(x)$
- $f$ **et** $g$ de même parité $arrow$ $f g$ paire
- $f$ **et** $g$ paires ou impaires et de parité différente $arrow$ $f g$ impaire

Dans un V/F, on peut parfois borner l'intégrale (avec le théorème de la moyenne par exemple). $(b-a) dot "supp"(F) > integral_a^b F d t$.
### Coordonnées cylindriques
**Ne pas oublier le Jacobien!**
$$ \vec{r} = \rho \vec{e_{\rho}} + z \vec{e_z} $$
intégration : $$ integral.triple f(x, y, z) d x d y d z = integral.triple f(r cos (theta), r sin (theta), z) r d r d theta d z $$Un petit élément de **surface** est donné par $d \vec{S} = r d r d \theta \vec{e_r} \times \vec{e_\theta}$
### Coordonnées Sphériques
$$ \vec{r} = r \vec{e_r} $$
intégration : $$ integral.triple f(x, y, z) d x d y d z = integral.triple f(r sin (theta) cos (phi), r sin (theta) sin (phi), r cos (theta)) r^2 sin (theta) d r d theta d phi $$Un petit élément de **surface** est donné par $d \vec{S} = r^2 \sin (\theta) d \theta d \phi \vec{e_r}$
### Identités trigonométriques

- $sin(A + B) = sin(A)cos(B) + cos(A)sin(B)$
- $sin(A - B) = sin(A)cos(B) - cos(A)sin(B)$
	- donc $sin(A)cos(B)$, assez utile pour Fourier
		$= 1/2 (sin(A + B) + sin(A - B))$
- $cos(A + B) = cos(A)cos(B) - sin(A)sin(B)$
- $cos(A - B) = cos(A)cos(B) + sin(A)sin(B)$
- $sin(2A) = 2 sin(A)cos(A)$ 
- $cos(2A) = cos^2(A)- sin^2(A)$
- $cos(2A) = 2 cos^2(A) - 1$
- $cos(2A) = 1 - 2sin^2(A)$

- $sin(-a) = -sin(a)$
- $cos(-a) = cos(a)$

- $e^(- i alpha) = cos(alpha) - i sin(alpha)$
- $cos(alpha) = (e^(i alpha) + e^(-i alpha))/2$
- $sin(alpha) = (e^(i alpha) - e^(-i alpha))/(2 i)$
## Théorèmes de base
$$ "div"(nabla f) = laplace f $$
$$ "rot"(nabla f) = 0 $$
car $nabla$ F pointe vers la plus grande augmentation de $f$. Or si le rotationnel de $nabla$ F était différent de zéro, cela signifierait une augmentation de $f$ infinie (on tournerait en boucle!). 
$$ "div"("rot" F) = 0 $$
car le rotationnel de F est un champ de vecteurs qui tournent (et ne sortent ou ne rentrent pas dans la surface) donc la divergence, qui mesure cela, est nulle.
$$ nabla (f g) = f nabla g + g nabla f $$
## Intégrales curvilignes

On appelle $Gamma$ une courbe **régulière** s'il existe une fonction $gamma : [a, b] arrow RR^n$ continue, dont la dérivée n'est jamais nulle (elle ne doit jamais s'arrêter sur un point), t.q $gamma$ donne pour image tous les points de $Gamma$ pour un certain $t in [a, b]$.

Courbe **simple** : au moins une paramétrisation vérifie l'injectivité, $t_1 eq.not t_2 arrow.double gamma(t_1) eq.not gamma(t_2)$ *(on ne vérifie pas uniquement la coordonnée $y$ n'est-ce pas, on vérifie que le point $gamma(t_1)$ est différent du point $gamma(t_2)$).
Courbe **fermée** : toutes les paramétrisations vérifient $gamma(a) = gamma(b)$ 
Courbe **régulière par morceaux** : il existe des courbes régulières dont l'union est $Gamma$

Notons que l'on peut très bien trouver une paramétrisation en polaire ($[0, 2pi] arrow RR^2$ par ex.).

#### Formule

Pour une fonction $f$ scalaire :
$$ integral_Gamma f d l = integral_a^b f(gamma(t))|gamma quote.single (t)| d t in RR $$
Pour une fonction $F$ à plusieurs dimensions :
$$ integral_Gamma F dot d l = integral_a^b angle.l F(gamma(t)) ; gamma quote.single (t) angle.r d t in RR $$
#### Intuition

On veut intégrer $f(x, y) = z$ (en bleu) selon le cercle, que l'on paramétrise ($gamma$) comme $\vec{r}(t) = g(t)\vec{i} + h(t)\vec{j}$.

  ![[curve_integral.png|324]]

On peut d'abord réécrire notre fonction comme $f(t) = f(g(t), h(t))$. Pourquoi ? Parce que les seuls points qui nous intéressent sont ceux selon $g(t), h(t)$ ! Notre fonction aurait pu être comme ça (pleine), mais on veut juste être sur les points du cercle, pour les sommer (une intégrale... de courbe :).

![[f_without_param.webp|179]]

![[dsk_area.webp|183]]

Ici on veut l'aire donc $A_k = f(x_k, y_k)Delta s_k = f(x_k, y_k)sqrt((Delta x_k)^2 + (Delta y_k)^2)$
$arrow.double.r d A = f(g(t), h(t)) sqrt(g quote.single (t)^2 + h quote.single  (t)^2 ) d t$

#### Autres définitions utiles

**Longueur** de la courbe $Gamma$ : $integral_Gamma 1 d l$
### Champs qui dérivent d'un potentiel

Soit $Gamma subset.eq RR^n$ un ouvert et $F in C^0 (Omega, RR^n)$. 

$F$ **dérive d'un potentiel** sur $Omega$ s'il existe $f in C^1(Omega)$ telle que $nabla f = F$  dans $Omega$.

Par exemple $f$ est un paysage montagneux, alors $F$ décrit les directions et intensités des pentes du paysage.

Si $F$ dérive d'un potentiel, alors :
$$ integral_Gamma F dot d l = f(gamma(b)) - f(gamma(a)) $$
La somme totale du potentiel est égale à l'altitude au point d'arrivée moins celle au point de départ.
S'il existe un potentiel, il en existe une infinités ($plus.minus c in RR$).

#### Comment savoir si $F$ dérive d'un potentiel ?

**Condition nécessaire** : $forall 1 <= i, j <= n, forall x in Omega$ , on a :$$ \frac{\partial F_i}{\partial x_j}(x) = \frac{\partial F_j}{\partial x_i}(x) $$
**Condition suffisante** : on ajoute que $Omega$ est simplement connexe (ou plus fort, convexe).

**Méthode en pratique :**
- est-ce que $"rot" F eq.not 0$ ? si oui, **pas de potentiel** ! La condition nécessaire n'est pas respectée.
- si non, est-ce que le domaine est simplement connexe ? si oui, **il y a un potentiel** !
- si non, on choisit entre ces deux méthodes :
	- choisir une courbe $Gamma$ qui entoure un unique trou de $Omega$. est-ce que $integral_Gamma F dot d l eq.not 0$ ? Si oui, **pas de potentiel !** Sinon, on change de trou ou on change de méthode.
	- intégrer $f(x, y, z) = integral^x F_1 (t, x, y) d t$ et ajuster en ajoutant $alpha(y, z)$ pour que $nabla f = F$.

Note, on peut aussi poser $gamma: [0, 1], t arrow (t x, t y)$ . Avec ça, on peut trouver $f$ car on sait que $f(gamma(1)) - f(gamma(0)) = f(x, y) = integral_gamma f$.
### Théorème de Green
##### Définitions utiles

Soit $Omega subset.eq RR^n$ un ouvert borné.

Le **bord** de $Omega$ noté $diff Omega$ est défini comme $diff Omega = {x in RR^n : forall epsilon > 0, B_epsilon (x) sect Omega eq.not emptyset "et" B_epsilon (x) sect Omega^c eq.not emptyset}$, où $B_epsilon (x) = {y in RR^n : |x - y| < epsilon}$ (l'ensemble des points autour desquels chaque boule appartient à l'ensemble et à son complément)

Soit $Omega subset.eq RR^2$ un ouvert borné tel que $diff Omega$ est une courbe simple fermée régulière. Le bord est **orienté positivement** si on le paramétrise avec $gamma$ dont le sens de parcours laisse le domaine à gauche.

![[orientation_surf.webp]]

Un domaine $Omega subset.eq RR^2$ est **régulier** s'il existe $Omega_0, ..., Omega_n$ des ouverts bornés t.q :
- tous les $Omega_i$ sont contenus dans $Omega_0$
- ils ne se chevauchent pas
- $Omega = Omega_0 backslash U _(i = 1)^n overline(Omega_i)$ (on part de $Omega_0$ et on enlève les trous).
- $Gamma_j$ est une courbe fermée, simple et régulìere.
![[domaine_regulier.webp|364]]

#### Formule de Green

Soit $Omega subset.eq RR^2$ un domaine régulier dont le bord $diff Omega$ est orienté positivement et $F in C^1(Omega, RR^2)$.
$$ integral.double_Omega "rot" F (x, y) d x d y = integral_(diff Omega) F dot d l $$
#### Définition du vecteur normal

Soit $Omega subset.eq RR^2$ un domaine régulier et $x_0 in diff Omega$. Alors $nu_(x_0) in RR^2$ est la normale extérieure (le vecteur unité perpendiculaire au domaine, qui pointe vers l'extérieur). Il respecte les propriétés suivantes :
- $||nu_P|| = 1$
- si $gamma$ est une paramétrisation du bord et que $gamma(t_0) = x_0$ alors $gamma quote.single (t_0) dot nu_(x_0) = 0$ . (comme $gamma quote.single$ est le vecteur tangent au domaine)
- pour tout $epsilon > 0$, $P + epsilon nu_(x_0) in.not Omega$ (il va faire l'extérieur)

![[vecteur_normale_unit.webp|275]]

Si $gamma$ est une paramétrisation de $diff Omega$ qui laisse le domaine à gauche, alors :
$$ nu_gamma(t) = 1/(|gamma quote.single (t)|) (gamma_2 quote.single(t), - gamma_1 quote.single (t)) $$
Intuition :
![[90_deg_rot.webp|215]]

#### Formule (théorème de la divergence)

Soit $Omega subset.eq RR^2$ un domaine régulier et $F in C^1 (overline(Omega), RR^2)$ , alors :
$$ integral.double_Omega "div" F(x, y) d x d y = integral_(diff Omega) angle.l F, nu angle.r d l  $$
  Souvent il n'y a pas besoin de calculer la norme $|y quote.single (t)|$ car l'intégrale sur $diff Omega$ fait apparaître le terme (voir intégrales curvilignes, on a la dérivée de $gamma$ qui apparaît).

##### Corollaire pour le calcul d'une aire
On pose $F(x, y) = (-y , x) ", " G(x, y) = (-y, 0) ", " H(x, y) = (0, x)$.
Alors, on a $"Aire"(A) = integral.double_Omega 1 d x d y = 1/2 integral_(diff Omega) F dot d l = integral_(diff Omega) G dot d l = integral_(diff Omega) H dot d l$
car $"rot" F(x, y) = 1 - (-1) = 2 ", " "rot" G(x, y) = - (-1) = 1 ", " "rot" H(x, y) = 1$
#### Identités utiles

- $integral.double_Omega laplace u d x d y = integral_(diff Omega) angle.l nabla u; nu angle.r d l$ (car la divergence de $nabla u$ est le laplacien de $u$)
- $integral.double_Omega (v laplace u + angle.l nabla u; nabla v angle.r) d x d y = integral_(diff Omega) angle.l v dot nabla u; nu angle.r d l$ 
- $integral.double_Omega (u laplace v - v laplace u) d x d y = integral_(diff Omega) angle.l u nabla v - v nabla u, nu angle.r d l$ 
(pareil on applique la règle des produits pour retrouver la divergence à gauche)

## Intégrales de surface

Quelques notations : $f_x = (diff f)/(diff x)$, et $g = (g^1, ..., g^n)$.

$Sigma subset.eq RR^3$ est une **surface régulière** si :
- $exists A subset.eq RR^2$ un ouvert borné tel que $diff A$ est une courbe régulière par morceaux simple et fermée. Ce sera l'ensemble de définition de notre paramétrisation $sigma$.
- $exists sigma : overline(A) arrow RR^3$ telle que $sigma in C^1(overline(A), RR^3), sigma(overline(A)) = Sigma$ et $sigma$ est injective sur $A$.
- on veut $sigma_u and sigma_v eq.not 0$.

Le **vecteur normale unité** au point $u, v$ est :$$ nu_(u, v) = (sigma_u and sigma_v)/(|sigma_u and sigma_v|) $$
$Sigma$ est régulière par morceaux s'il existe $Sigma_1, ..., Sigma_k$ telle que l'union forme $Sigma$.
$Sigma$, si régulière, est **orientable** s'il existe un champ de vecteurs normaux unitaires et continus $nu: Sigma arrow RR^3$. Un tel champ est appelé une orientation de $Sigma$.

![[from_omega_to_sigma.webp]]
Pour vérifier si $nu$ est orienté correctement, on peut tester avec des valeurs faciles ($theta = pi/2$) et visualiser.

On peut aussi trouver un vecteur normal en posant $G(x, y, z) = f(x, y, z)$ et en calculant le gradient de $G$.

#### Paramétrisations/Aires/Volume utiles

**Cône**:
$sigma: [0, 2pi] times [0, 1], (theta, z) arrow (z cos(theta), z sin(theta), z)$
$sigma_theta = (- z sin(theta), z cos(theta), 0) " et " sigma_z = (cos(theta), sin(theta), 1)$
$|sigma_theta times sigma_z| = (z cos (theta), z sin(theta), -z)$
Aire : $pi dot r^2 + pi r a$ ($a$ l’hypoténuse)
Volume : $(pi dot r^2 dot h)/3$

**Sphère**, aire : $4 pi r^2$, volume : $4/3 pi r^3$
### Formule

Pour une fonction f scalaire :
$$ integral.double_Sigma f d s = integral.double_A f(sigma(u, v)) dot |sigma_u (u, v) and sigma_v (u, v)| d u d v $$
Pour une fonction F à plusieurs dimensions :
$$ integral.double_Sigma F dot d s = integral.double_A angle.l F(sigma(u, v)); sigma_u (u, v) and sigma_v (u, v) angle.r d u  d v $$Si l’on compare ces définitions avec l’intégrale curviligne, nous remarquons que ce qui change essentiellement est le fait que $gamma(t)$ soit remplacée par $sigma(u, v)$ et $gamma quote.single (t)$ soit remplacée par $sigma_u (u, v) and sigma_v (u, v)$.

### Formule (théorème de la divergence dans l'espace)

Soit $Omega subset.eq RR^3$ un domaine régulier, $nu : diff Omega arrow RR^3$ un champ de normales extérieures unités continu et $F in C^1 (Omega, RR^3)$. Alors :

$$ integral.triple_Omega "div" F(x, y, z) d x d y d z = integral.double_(diff Omega) angle.l F; nu angle.r d s $$
Encore une fois, si $diff Omega$ est un bout du bord, on a directement une simplification de $nu$ (pas besoin de la norme) :

$$ integral.double_(diff Omega) angle.l F; v angle.r d s = integral.double_(diff Omega) angle.l F(sigma(u, v)); sigma_u (u, v) and sigma_v (u, v) angle.r d u d v $$
### Théorème de Stokes

Soit $Sigma subset.eq RR^3$ une surface régulière orientable, $sigma: overline(A) arrow Sigma$ une paramétrisation (avec $diff A$ une courbe simple, fermée, régulière par morceaux). Le bord de $Sigma$ noté $diff Sigma$ est donné par $sigma(diff A)$, dont on enlève :
- les courbes qui sont parcourues dans deux sens opposées
- les parties qui sont réduites à un point

(mais si on ne les enlève pas, ça fonctionnerait quand même)

Le choix du sens de parcours sur $diff A$ 

un sens de parcours sur $diff Sigma$ par composition avec $sigma$. 

#### Formule

Soit $Omega subset.eq RR^3$ un ouvert, $Sigma subset.eq Omega$ une surface orientable régulière par morceaux, $F in C^1(Omega, RR^3)$, alors :
$$ integral.double_Sigma angle.l"rot" F(sigma(u, v)); nu angle.r d sigma = integral.cont_(diff Sigma) angle.l F; tau angle.r dot d l = (integral.cont_(diff ) F(sigma(gamma_i (t))) dot d/(d t) (sigma(gamma_i (t))) d t) $$
## Distributions

La dérivée est trop "forte" quand on considère les fonctions avec des sauts, des pics, mais alors, comment dériver ces fonctions ?
### Définitions utiles

Le **support** d'une fonction $f$ est le domaine sur lequel $f$ n'est pas zéro.
L'ensemble **D** des fonctions infiniment dérivables (lisses) dont le support est contenu dans un
certain intervalle.
### Dirac (fonction heaviside)

Par exemple la fonction heaviside  $H(x) = 1 "si" x > 0 "sinon" 0$. 
On appelle la dérivée $H quote.single (x) = epsilon(x)$. Elle sera quasiment nulle partout sauf en un point (le saut). Comment représenter la dérivée comme ça ? En fait, on peut considérer $epsilon(x)$ comme une distribution et utiliser une **test function** pour obtenir sa densité entre deux points.

![[testfunctions.webp|540]]

$$ phi arrow integral f(x)phi(x) d x $$

![[ordinaryfunction.webp|553]]

Comment savoir si $T$ est une distribution valide ? (si $T in D$).

* $T$ doit être **finie**, peu importe le $phi$ avec laquelle on la mesure, $forall phi in D : |T(phi)| < infinity$. (les fonctions continues sur un ensemble compact sont bornées, donc montrer la continuité implique la prop de finie).
* $T$ est **linéaire**.
- $T$ doit être **continue** :$$ forall [a, b] subset RR, exists C > 0 " (qui peut dépendre de a, b) t.q " forall phi in D " t.q supp" (phi) subset [a, b] $$ alors :
$$ |T(phi)| <= C sum_(i >= 0) max_(x in RR) |diff_x^i phi(x)| $$
Pour montrer ça on peut par exemple prendre $i = 0$ et si ça suffit on peut s'arrêter là.

$$ |(integral_(-infinity)^(infinity) phi(x) d x)| = |(integral_a^b phi(x) d x)| $$
$$ <= max_(x in RR) abs(phi(x)) integral_a^b 1 d x = (b - a) max_(x in RR) abs(phi(x)) $$
$$ <= (b - a) sum_(i >= 0) max_(x in RR) |(diff_x^i phi(x))| $$
### Dérivation des distributions

Le produit scalaire mesure à quel point deux vecteurs vont dans la même direction :
$$ angle.l X, Y angle.r = sum_(i = 0)^n x_i y_i $$
Généralisation à des fonctions continues :
$$ angle.l F_1, F_2 angle.r = integral_a^b F_1 (x) F_2 (x) d x$$
Dérivation des distributions :
$$ angle.l f quote.single, phi angle.r = - angle.l f, phi quote.single angle.r = - integral f(x) phi quote.single (x) d x $$
$$ = - [f(x) phi(x)]_0^(infinity) + integral phi(x)d x " or " phi(infinity) = 0 " (une test function vaut 0 en l'infini)" $$
$$ = integral phi (x) d x $$
#### Heaviside, Dirac Delta, Dirac Comb
$$ H(x) = cases(0 "if" x < 0, 1 "if" x >= 1)$$
$$ delta_0 : D arrow RR , phi -> phi(0) $$
$$ Delta_T (phi) -> sum_(n = -infinity)^(+infinity) phi(n T) $$
## Analyse de Fourier

### Séries de Fourier

#### Égalités utiles

Soient $n, m in NN^*$ et $T > 0$ alors :
$$ 2/T integral_0^T cos((2 pi)/T n x) cos ((2 pi)/T m x) d x = 2/T integral_0^T sin ((2 pi)/T n x) sin((2 pi)/T m x) d x = cases(
1 "si" n = m,
0 "sinon"
) $$
et 
$$ integral_0^T sin((2 pi)/T n x )cos((2 pi)/T m x) = 0 $$
#### Définition

On veut écrire $f : RR arrow RR$ T-périodique sous cette forme:
$$ f(x) = a_0/2 + sum_(k = 1)^infinity [a_k cos((2 pi)/T k x) + b_k sin ((2 pi)/T k x)] $$
$$ $$
Pour ça, on choisit :
$$ a_0/2 = 1/T integral_0^T f(x) d x $$
(on note que si f continue par morceaux, on peut calculer $a_0$ en évaluant $a_k$ avec $k = 0$ mais **très généralement** en calculer les $a_k$ il y a un facteur $c/n$ qui apparaît et on doit poser l'hypothèse que $a_k$ tient uniquement $forall n >= 1$) : $$ a_k = 2 /T integral_0^T f(x) cos((2 pi)/T k x) d x $$
$$ b_k = 2/T integral_0^T f(x) sin ((2 pi)/T k x) d x $$
#### Théorème de Dirichlet

Soit $f : RR arrow RR$ T-périodique et $C^1$ par morceaux. Alors, $forall x in RR$:
$$ F f(x) = lim_(t = 0) (f(x - t) + f(x + t))/2 $$
(c'est-à-dire que même si la fonction n'est pas parfaitement continue, on assigne la moyenne des deux extrémités à gauche et à droite)

Si $f : RR arrow RR$ est continue (pas par morceaux) et bornée alors $F_N f$ converge vers $f$ quand $N arrow infinity$.

Note : c'est similaire pour les transformées de Fourier, en cas de discontinuité on prend la moyenne.
#### Coefficients de Fourier complexes
$$ c_n = 1/T integral_0^T f(x) e^(- i (2 pi)/T n x) d x $$$$ a_n = c_n + c_(- n) " et " b_n = i(c_n - c_(-n)) " ou (plus utile),  " c_n = a_n/2 - i b_n/2 " et " c_(-n) = a_n/2 + i (b_n)/2$$
$$ F f(x) = lim_(N arrow infinity) sum_(n = -N)^N c_n e^(i (2pi)/T n x) $$
#### Propositions utiles

- si $f$ est paire, $b_n = 0$, si $f$ impaire, $a_n = 0$

#### Identité de Parseval
Soit $f : RR arrow RR$ T-périodique et $C^1$ par morceaux.

$$ 2/T integral_0^T f(x)^2 d x  = a_0^2/2 + sum_(n = 1)^infinity (a_n^2 + b_n^2) = 2 sum_(n = - infinity)^infinity |c_n|^2 $$
#### Dérivation termes à termes
$$ F f quote.single(x) = sum_(n = 1)^infinity (2 pi)/T n (- a_n sin((2 pi)/T n x) + b_n cos((2 pi )/T n x)) = lim_(t arrow 0) (f quote.single(x - t) + f quote.single (x + t))/2 $$
#### Partir d'une série connue

Supposons que l'on connaisse la série de Fourier de $F$ de période $1$ telle que :
$$F(x) = cases(1 "si " 0 <= x <= 1/2, -1 "si " 1/2 <= x <1) arrow.double.long b_n = 4/(pi n) " si " n " impair, sinon" 0 $$
Et que l'on souhaite calculer :
$$F quote.single (x) = cases(1 "si " 0 <= x <= 1/2, 0 "si " 1/2 <= x <1) $$
Le plus difficile c'est d'exprimer $F quote.single$ en fonction de $F$ :
$$ F quote.single (x) = 1/2 + 1/2F(x)$$
et ensuite, on trouve que le $a_0/2$ est augmenté de $1/2$ et le coefficient $b_n$ est divisé par $2$.

Parfois il y a des cas un peu plus difficiles, avec un changement de fréquence par exemple. On revient alors à la formule avec l'intégrale. On connaît (période $1$) :
$$ G(x) = cases( 2 x "si" 0 <= x < 1/2, 2(1-x) "si" 1/2 < x <= 1) $$
On veut calculer (période $2 pi$) :
$$ G quote.single (x) = cases(x "si" 0 <= x < pi, 2 pi - x "si" pi <= x <= 2 pi) $$
On exprime :$$G quote.single = pi G(x/(2 pi)) "et on connaît " a_n^G = 2/1 integral_0^1 G(x)cos((2 pi)/1 n x) d x$$
Et on cherche :
$$a_n^(G quote.single) = 1/pi integral_0^(2 pi) G quote.single (x) cos(n x) d x = 1/pi integral_0^(2 pi) pi G(x /(2 pi)) cos(n x) d x $$
On pose $z = x/(2 pi)$ :
$$ = 1/pi integral_0^(2 pi) pi G(z) cos((2 pi)/(2 pi) n x) 2 pi d z = 2 pi integral_0^(2 pi) G(z) cos((2 pi)/(2 pi) n x) d x $$
Il apparaît clairement que les $a_n$ ont été multipliés par $pi$ et que la nouvelle période est $2 pi$!

#### Intégrale d'une fonction par sa série de Fourier
$$ integral_(x_0)^x f(x)d x = a_0/2(x- x_0) + sum_(n = 1)^infinity a_n integral_(x_0)^x cos((2 pi)/T n x) d x + b_n integral_(x_0)^x sin((2 pi)/T n x) d x$$
![[superp.webp|153]]

L'intégrale de notre fonction c'est la somme des intégrales de tous les cos et sin (en vert et bleu) qui la composent (+ ou - la valeur moyenne de la fonction, qui pour rappel est un shift vers le haut ou le bas).
### Transformée de Fourier

Soit $f : RR arrow RR$ une fonction continue par morceaux telle que $integral_(-infinity)^(infinity) |f(x)| < + infinity$.

Alors la transformée de Fourier noté $cal(F)[f]$ ou $\hat{f}$ est définie par :
$$ cal(F)[f] : RR arrow CC, cal(F)[f](alpha) = 1/(sqrt(2 pi)) integral_(-infinity)^infinity  f(x) e^(-i alpha x) d x $$
(parfois il est plus simple d'écrire $e^(-i alpha x)$ comme $cos(alpha x) - i sin(alpha x)$)

Dans un sens on décompose notre fonction $f$ en une somme de fonctions périodiques avec des fréquences différentes (et on obtient une fonction $cal(F)[f](alpha)$ qui nous donne les coefficients de Fourier de ces fonctions périodiques en fonction de la fréquence). Et dans l'autre sens on reconstruit notre fonction $f$ en sommant ces fonctions périodiques.

**Transformée inverse**
$$ cal(F)^(-1) [Phi] : RR arrow CC, cal(F)^(-1) [Phi](x) = 1/(sqrt(2 pi)) integral_(-infinity)^infinity Phi(alpha)e^(i alpha x) d alpha $$

#### Propriétés utiles
Soient $f, g : RR arrow RR$ continues par morceaux telles que $integral_(-infinity)^(infinity) |f(x)| < + infinity$ et $integral_(-infinity)^(infinity) |g(x)| < + infinity$.

- $forall a, b in RR$, on a $cal(F)[a dot f + b dot g] = a cal(F)[f] + b cal(F)[g]$
- Si $f$ paire, alors $cal(F)$ réelle et paire.
- Si $f$ impaire, alors $cal(F)$ imaginaire pure et impaire.
- si $a, b in RR$, $a eq.not 0$ et $g(x) = f(a x + b)$ alors :$$ \hat{g}(\alpha) = \frac{e^{i \frac{b}{a} \alpha}}{|a|} \hat{f}(\frac{\alpha}{a}) $$
- si $g(x) = e^(-i b x) f(x)$ alors $\hat{g}(\alpha) = \hat{f}(\alpha + b)$
- si $g(x) = x^n f(x)$ alors $\hat{g}(\alpha) = i^n \frac{d^n \hat{f}(\alpha)}{d \alpha^n}$
#### Identité de Plancherel
 
 Soit $f : RR arrow RR$ continue par morceaux telles que $integral_(-infinity)^(infinity) |f(x)| < + infinity$ et $integral_(-infinity)^(infinity) f(x)^2 < + infinity$.
 Alors :$$ \int_{-\infty}^{\infty} f(x)^2 d x = \int_{-\infty}^{\infty} |\hat{f}(\alpha)|^2 d \alpha $$
#### Transformée de la dérivée
 Soit $f : RR arrow RR$ continue par morceaux telles que $integral_(-infinity)^(infinity) |f(x)| <= infinity$ et pour $n in NN^*, forall k 1 <= k <= " on a " integral_(-infinity)^(infinity) |f^((k))(x)| < + infinity$.
$$ cal(F)[f^((n))](alpha) = (i alpha)^(n) cal(F)[f] $$
### Produit de convolution
Soient $f, g : RR arrow RR$ continues par morceaux telles que $integral_(-infinity)^(infinity) |f(x)| < + infinity$ et $integral_(-infinity)^(infinity) |g(x)| < + infinity$. On définit le produit de convolution comme :
$$ f * g(x) = integral_(-infinity)^infinity f(x - t)g(t) d t = integral_(- infinity)^infinity f(t)g(x - t) d t $$
Exemple de convolution, on veut calculer $integral_(-infinity)^(+infinity) f(z)g(x - z) d z$. On choisit une fonction qui bouge, et une fonction qui reste fixe. On va séparer notre intégrale en plusieurs intervalles. Si on a $g$ constante qui est $eq.not 0$ entre $-1$ et $1$, on trouve $x - 1 <= t <= x + 1$. On sait que notre $t$ va varier entre $x - 1$ et $x+1$ (en fait de $-infinity$ à $+infinity$ mais le produit sera 0 à cause de $g$). On pose $x$ le centre de notre $g$ et on trouve tous les intervalles qui font appel à des définitions différentes de $f$ puis on calcule les intégrales (à la fin en fonction de $x$).

**Transformée de $f * g$**

$$ \int_{-\infty}^{\infty} |f * g| d x < \infty \text{ et } \mathcal{F}[f * g](\alpha) = \sqrt{2 \pi} \hat{f}(\alpha) \cdot \hat{g}(\alpha) $$
$$ \mathcal{F}[{f \cdot g}](\alpha) = \frac{1}{\sqrt{2 \pi}}(\mathcal{F}[f](\alpha) * \mathcal{F}[g](\alpha)) $$
![[cheatsheet.webp]]![[potential.webp]]

### Problème de Poisson

#### Séries de Fourier

On fait une odd extension de la fonction $f$.
Pour la condition $-laplace u = f(x)$,
$$ b_n = 2/L integral_0^L f(x) sin((pi n)/L x) $$
$$ u^f = sum_(n = i)^infinity b_n L^2/(pi^2 n^2) sin((pi n)/L x) $$
Pour la condition $u^g (a) = g^a$ et $u^g (b) = g^b$ et $laplace u = 0$,
$$ u^g (x) = C_1 x + C_2 $$
$$ u = u^f + u^g $$
#### Transformées de Fourier

$$ -u''(x) + k^2 u(x) = f(x) $$
$$ arrow.double cal(F)[u](alpha) = 1/(k^2 + alpha^2) cal(F)[f](alpha) = cal(F)[g](alpha) dot cal(F)[f](alpha) " et " g(x) = sqrt(pi/2) e^(-k |x|)/k $$
$$ u(x) = 1/(sqrt(2 pi)) g * f(x) $$
$$ u(x) = 1/(2 k) (e^(-k|x|) * f(x)) $$
### Séries de Fourier remarquables

$$ f(x) = x " pour " 0 <= x <= 1 $$
$$ f(x) = 1/2 + sum_(n = 1)^infinity -1/(pi n) sin( 2 pi n x) $$

$$ g(x) = cases(1 "        si " 0 <= x < 1/2, -1 "     si " 1/2 <= x < 1) $$
$$ g(x) = sum_(n = 1)^infinity b_n^g sin(2 pi n x) " et "  b_n^g = 4/(pi n) " si " n "odd" $$
