== Champ électrique

Seule la direction importe, le sens sera apporté par la charge sur laquelle on "appliquera" le champ.

Quand on a une surface avec une forme facile (symmétrique) on peut faire :

$ Phi_E = integral arrow(E(r)) dot d arrow(S) = Q_"int"/epsilon_0 $

En fait on va entourer nos charges avec une forme (par exemple une sphère), donc on aura $Q_"int"$ et on va calculer 
$d arrow(S)$ est toujours orthogonal à la surface par laquelle les charges passent (donc si le champ est dans le même sens alors le produit scalaire fera 1).

== Potentiel électrique 

Ce n'est pas un vecteur. C'est comparable à la hauteur en méca.

Comment calculer $V$ *en un point* ? Charge(s) ponctuelle(s) :

$ V(r) = sum_i^n k Q_i/r_i $

Pour une surface avec une distribution de charges continue :

$ V(r) = integral_S k d_q/r $

Attention $V$ est un scalaire, pas un vecteur !

$ E - nabla V $

== Conservation de l'énergie

$ E = K + U $

L'énergie cinétique et l'énergie potentielle d'une charge $q$ dans un potentiel électrique $V$ créé par d'autres charges :

$ K = 1/2 m v^2 $
$ U = V dot q $

U s'exprime toujours comme une énergie potentielle entre une charge et une ou plusieurs autres charges.

En méca, l'énergie potentielle dépend du champ dans lequel la charge est introduite (en méca $U = m g h$). En électromag pareil, elle dépend des autres charges présentes autour.

L'énergie potentielle est définie à une constante près. En méca on dit que $U("surface de la Terre") = 0$ pour simplifier les calculs. En électromag on dit $U(infinity) = 0$ (quand les deux charges sont éloignées à l'infini alors l'énergie potentielle est nulle).

$ W_(A arrow B) = Delta U $

(par exemple en méca $W_(A arrow B) = m g h_a - m g h_b$)

Si $nabla V = 0$, le potentiel est constant, ça signifie que le champ est nul dans la direction dans laquelle on effectue le travail, mais on peut avoir un champ perpendiculaire à la direction.

== Propriété des conducteurs dans un cas électrostatique

- $arrow(E) = 0$ à l'intérieur
- à l'intérieur ce n'est pas chargé (il y a un équilibre)
- $arrow(E)$ est $perp$, car c'est à la surface que toutes les charges se trouvent (et toute composante du champ parallèle ferait bouger les charges, ce qui n'est pas autorisé). 

== Formule de Poisson

On part de la formule de Gauss:

$ integral_S arrow(E) dot d arrow(S) = Q_"int"/epsilon_0 $

Intégrer sur la surface c'est comme intégrer sur le volume en dérivant le vecteur :

$ arrow.double.r.l integral_V arrow(nabla) dot arrow(E) dot d V = Q_"int"/epsilon_0 $

On retrouve la charge :

$ arrow.double.r.l arrow(nabla) dot arrow(E) integral_V d V = 1/epsilon_0 integral_V rho dot d V $

$ arrow.double.r.l arrow(nabla) dot arrow(E) integral_V d V = rho/epsilon_0 integral_V d V $

*$ arrow.double.r.l arrow(nabla) dot arrow(E) = rho/epsilon_0 $*

$ arrow.double.r.l arrow(nabla)^2dot arrow(V) = rho/epsilon_0 $

== Capacité

Dans le cas d'un condensateur, $Q = C dot V$

Ou $Q = C/(Delta V)$ pour un condensateur, avec $Delta V$ la différence de potentiel entre les deux plaques.

$ C = (epsilon A)/d  $

donc C ne dépend que de la géométrie du condensateur

$d$ distance entre les plaques (en mètres) \
$A$ l'aire des plaques (en mètres carrés) \ 
$epsilon$ permissivité du milieu entre les plaques (la capacité ne dépend donc pas uniquement de la géométrie mais aussi du facteur $chi_i$ du matériau)

$ E = E_0 / K $

$E_0$ le champ électrique si on était dans l'air \
$K$ la constante diélectrique du milieu

Calculer une différence de potentiel avec différents milieux:

$ V(A) - V(B) = integral_0^("fin du milieu A") arrow(E) d arrow(l) + integral_"fin du milieu A"^"fin du milieu B" arrow(E) d arrow(l) $
$ arrow.double.r.l V(A) - V(B) = E_0/K_A(d_A) + E_0/K_B(d_B) $

$U_"stocké"/V = 1/2 epsilon_0 E^2$ ???

Calculer la capacité des condensateurs en série :

$ 1/C_"tot" = sum_"capacité du condensateur i" 1/C_i $

Calculer la capacité des condensateurs en parallèle :

$ C_"tot" = sum_"capacité du condensateur i" C_i $

== Circuits

=== Règle des noeuds (pour un noeud donné)
$sum_k i_k = 0$ \
$sum_n i_"in" = sum_n
 i_"out"$ 

=== Règle des mailles (autour de chaque maille fermée)

$sum_k Delta V_k = 0$ \ 
On choisit un sens pour compter. \
On ajoute les tensions (de batterie par exemple) dans le sens dans lequel on va. \
On ajoute les résistances comme $plus.minus i_k dot R_k " "ohm$ en fonction du sens (si on compte dans le sens opposé au courant, on ajoute, sinon on enlève). donc le + des résistances est le - des tensions de batteries

=== Loi d'ohm

$V = R i$ (elle s'applique aux bornes d'un dipôle)

== Charger un condensateur

temps caractéristique d'un condensateur $tau = R C$.

On a qu'à l'état d'équilibre (quand le condensateur est chargé), le courant est nul :

$ C V = q arrow.r.double C (d V)/(d t) = (d q)/(d t) = i $
$ "donc " i = C (d q)/(d t) $
