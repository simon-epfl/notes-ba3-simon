#set text(font: "DejaVu Sans")
#show heading.where(level: 1): contents => text(size: 20pt, contents)
#show heading: contents => pad(bottom: 10pt, contents)
#set quote(block: true)
#set heading(numbering: (ignore_first, ..n) => {
  if (n.pos().len() != 0) {
    numbering("1.1.", ..n)
  }
})

= Tricks généraux

- utiliser le principe de superposition : quand il n'y a pas de charge, on peut dire qu'il y a en fait une charge positive et une négative.
- toujours justifier que le champ est uniforme car la distance entre les plaques est faible et les plaques sont grandes
- $P = E/(d t)$
- faire des matrices pour les équations loi mailles/noeuds
- dans une trajectoire circulaire, une force de $(m v^2)/R$ doit tirer vers le centre (centripète).
- vitesse angulaire $ omega = (2 pi)/T " et " f = 1/T$
- puissance dissipée : $P = R i^2$
- longueur d'onde : $lambda = c / f $
- volume d'une sphère de rayon $R$ : $V = 4/3 pi R^3$, surface : $S = 4 pi R^2$
- produit vectoriel $arrow(a) times arrow(b) = norm(arrow(a)) norm(arrow(b)) sin(theta) arrow(n)$ avec $arrow(n)$ le vecteur normal à $arrow(a)$ et $arrow(b)$.
- produit scalaire $arrow(a) dot arrow(b) = norm(arrow(a)) norm(arrow(b)) cos(theta)$
- oscillateur harmonique : $dot.double(theta) = -Omega^2 sin(theta)$, $Omega$ est la fréquence des oscillations

== Coordonnées

=== Cylindriques

$ arrow(r) = rho arrow(e_(rho)) + z arrow(e_z) $
intégration : $ integral.triple f(x, y, z) d x d y d z = integral.triple f(r cos (theta), r sin (theta), z) r d r d theta d z $

Un petit élément de surface est donné par $ d arrow(S) = r d r d theta arrow(e_r) times arrow(e_theta) $

=== Sphériques

$ arrow(r) = r arrow(e_r) $

intégration : $ integral.triple f(x, y, z) d x d y d z = integral.triple f(r sin (theta) cos (phi), r sin (theta) sin (phi), r cos (theta)) r^2 sin (theta) d r d theta d phi $

Un petit élément de surface est donné par $ d arrow(S) = r^2 sin (theta) d r d theta d phi arrow(e_r) $

= Électrostatique

== La loi de Coulomb (force électrique)

$ arrow(F)_(q_1 arrow q_2) = k (q_a q_b)/(r^2) arrow(r)_(1 arrow 2) " avec " k = 1/(4 pi epsilon_0) $

Méthode pour calculer la force exercée par la barre sur $q_0$.

#image("posts/exo1.png")

- écrire l'expression de la force selon un vecteur $arrow(r)$.
- ici, on sait que la force sur $y$ va se compenser, donc on intègre la force selon $arrow(x)$ pour trouver $F_"tot"$.

Attention, quand on intègre, il ne faut pas oublier de décomposer le vecteur $arrow(r)$ selon les différentes composantes (qui seront dans le calcul de l'intégrale !) :
$ arrow(r) = (D_1 arrow(e_r) + D_2 arrow(e_z))/(sqrt(D_1^2 + D_2^2)) $

== Le champ électrique

Champ électrique produit par une charge $Q$ (avec $arrow(r)$ le vecteur unitaire dirigé radialement, sortant de la source) :
$ arrow(E) = k Q/r^2 arrow(r) = integral_"distribution des charges" k (d q)/r^2 arrow(r) $

Seule la direction importe, le sens sera apporté par la charge sur laquelle on "appliquera" le champ.

$arrow(E) = 0$ à l'intérieur des conducteurs. Les lignes de champ vont de + à -.

Dans le cas d'un champ uniforme : $E = V / L$.

== Les dipôles électriques

Un dipôle c'est deux charges opposées séparées par une distance $d$ constante. Si on place un dipôle dans un champ électrique, il y a un moment de force (couple).

Moment dipolaire : $ arrow(p) = q arrow(d)$, il décrit la séparation des charges

Moment de force : $arrow(tau) = arrow(p) times arrow(E)$, il décrit la rotation que subit le dipôle

La force sur un dipôle dans un champ électrique E (externe): $arrow(F) = (arrow(p) dot arrow(nabla)) arrow(E)$, donc nulle si E uniforme.

Moment de force : $arrow(tau) = arrow(p) times arrow(E)$, permet de décrire la rotation du dipôle (une fois que le dipôle est parallèle à E, le moment de force devient nul).

Théorème du moment cinétique : $arrow(tau) = (d arrow(L_O))/(d t)$ avec $arrow(L_O) = sum_i arrow(r_i) times m_i arrow(v_i)$.

== Le flux électrique

Le flux électrique est une mesure de la "quantité de champ" qui est interceptée par une surface A.

$ Phi_E = integral.cont_"surface S" arrow(E) dot d arrow(A) $

$arrow(A)$ est la normale à la surface, orientée vers l'extérieur.

=== Gauss

Quand on a une surface avec une forme facile (symmétrique) on peut utiliser Gauss :

$ Phi_E = integral arrow(E(r)) dot d arrow(S) = Q_"int"/epsilon_0 $

En fait on va entourer nos charges avec une forme (par exemple une sphère), donc on aura $Q_"int"$ et on va calculer 
$d arrow(S)$ est toujours orthogonal à la surface par laquelle les charges passent (donc si le champ est dans le même sens alors le produit scalaire fera 1).

Ça simplifie le calcul de $E$; si on connaît $Q_"int"$ et que $Q$ est distribué uniformément alors on peut utiliser la formule vue plus haut.

attention à bien compter toutes les surfaces. ici pour le flux on ajoute un facteur 2 parce que si on ne considère que la surface A, on trouvera un champ deux fois trop petit :

#image("posts/2eps.png")

== Potentiel électrique 

Ce n'est pas un vecteur. C'est comparable au potentiel gravitationnel en méca (à la hauteur).

=== Rappels travail/énergie

$W_(A arrow B) = U(A) - U(B) = - Delta U$

Énergie potentielle : $U(r) = k (q_0 Q)/r$

=== Calculer le potentiel

$ V(r) = U(r)/q_0 = (k Q)/r $

Comment calculer $V$ *en un point* ? Charge(s) ponctuelle(s) ou surface continue.

$ V(r) = sum_i^n k Q_i/r_i " ou " V(r) = integral_S k d_q/r $

$ E = - nabla V arrow.double.r.l V = integral E arrow(d l) $

Si dans un circuit on a une différence de potentiel entre la borne + d'une résistance et la borne -, on sait qu'elle augmente/diminue linéairement (le champ étant constant).

== Surfaces équipotentielles

=== Effet de pointe

Deux sphères (une A petite, une B grande) connectées. Elles ont donc le même potentiel, mais une accumule une plus grande densité de charges !

=== Poisson

On part de la formule de Gauss:

$ integral_S arrow(E) dot d arrow(S) = Q_"int"/epsilon_0 $

Intégrer sur la surface c'est comme intégrer sur le volume en dérivant le vecteur :

$ arrow.double.r.l integral_V arrow(nabla) dot arrow(E) dot d V = Q_"int"/epsilon_0 $

On retrouve la charge :

$ arrow.double.r.l arrow(nabla) dot arrow(E) integral_V d V = 1/epsilon_0 integral_V rho dot d V arrow.double.r.l arrow(nabla) dot arrow(E) integral_V d V = rho/epsilon_0 integral_V d V arrow.double.r.l arrow(nabla) dot arrow(E) = rho/epsilon_0 $

$ arrow.double.r.l arrow(nabla)^2dot arrow(V) = rho/epsilon_0 $

== Capacité électrique

Plus de charge on met dans une sphère, plus on augmente son potentiel. Mais au fur et à mesure qu'on met de la charge, il devient de plus en plus difficile d'en mettre encore, parce qu'on doit la pousser pour vaincre la répulsion.

La capacité est définie du matériau et du milieu (p. ex. pour une sphère $C = 4 pi epsilon_0 R$ dans le vide -- avec $R$ le rayon).

On a la relation suivante : $C = Q/V$. Comme $C$ est constante, si on augmente le nombre de charges, on doit aussi augmenter le potentiel.

=== Capacité électrique et stockage d'énergie

condensateur : deux conducteurs séparés par un isolant (ou par la vide).

$ C = (epsilon A)/d " ou plus exactement " C = (epsilon_0 epsilon_r A)/d $

$epsilon_r$ (ou $K_f$) est la constante diaélectrique relative du matériau.
$A$ est l'aire des plaques, $d$ la distance entre elles, $epsilon_0$ la permissivité du vide.

$ U_"stockée" = 1/2 C V^2 = "(généralement) " 1/2 epsilon_0 E^2 A d $
$ arrow.double (d U)/(d V) = "densité énergie" = 1/2 epsilon_0 E^2 $

Si on veut l'énergie totale, on intègre $ integral_V 1/2 epsilon_0 E^2$.

$ E = E_0 / K_f " avec " K_f = epsilon_r = 1 + chi $

$E_0$ le champ électrique si on était dans l'air \
$K$ la constante diélectrique du milieu

Calculer une différence de potentiel avec différents milieux:

$ V(A) - V(B) = integral_0^("fin du milieu A") arrow(E) d arrow(l) + integral_"fin du milieu A"^"fin du milieu B" arrow(E) d arrow(l) $
$ arrow.double.r.l V(A) - V(B) = E_0/K_A(d_A) + E_0/K_B(d_B) $

Calculer la capacité des condensateurs en série :

$ 1/C_"tot" = sum_"capacité du condensateur i" 1/C_i $

Calculer la capacité des condensateurs en parallèle :

$ C_"tot" = sum_"capacité du condensateur i" C_i $

#pagebreak()

= Courant électrique

Fin de l'électrostatique : dorénavant les charges peuvent bouger. L'argument utilisé pour conclure que $arrow(E) = 0$ dans les conducteurs n'est plus valable.

$E = V/L$ dans le cas d'un champ uniforme.

$i = (d Q)/(d t)$, courant électrique, un scalaire.

La tension va généralement du - au + d'un générateur.

== Règle des noeuds (pour un noeud donné)

$sum_k i_k = 0$ \
$sum i_"in" = sum i_"out"$ 

== Règle des mailles (autour de chaque maille fermée)

$sum_k Delta V_k = 0$ \ 
On choisit un sens pour compter. \
On ajoute les tensions (de batterie par exemple) dans le sens dans lequel on va. \
On ajoute les résistances et les inductances comme $plus.minus i_k dot R_k " "ohm$ en fonction du sens (si on compte dans le sens opposé au courant, on ajoute, sinon on enlève). donc le + des résistances est le - des tensions de batteries

== Loi d'ohm

$V = R i$ (elle s'applique aux bornes d'un dipôle)

= Circuits RC

== Charger un condensateur

temps caractéristique d'un condensateur $tau = R C$.

On a qu'à l'état d'équilibre (quand le condensateur est chargé), le courant est nul :

$ C V = q arrow.r.double C (d V)/(d t) = (d q)/(d t) = i $
$ "donc " i = C (d q)/(d t) $

== Retrouver l'équation de charge

Partir de la loi $V_c$ (le générateur) $ + V_r$ (la tension générée par la résistance du condensateur) $ = 0$.

$ V_c + R C (d V)/(d t) = 0 $
$ Q / (R C) = (d V)/(d t) $
Résoudre. 

Exemples d'équation charge/décharge :

$ V_C (t) = epsilon (1 - exp(-t / (R C))) $
$ V_C (t) = epsilon exp(-t / (R C)) $

#pagebreak()

== Conservation de l'énergie

$ E = K + U $

L'énergie cinétique et l'énergie potentielle d'une charge $q$ dans un potentiel électrique $V$ créé par d'autres charges :

$ K = 1/2 m v^2 $
$ U = V dot q $

dans un circuit on considère que la vitesse est nulle dans un conducteur donc :
$ P = E/(d t) = (d U)/(d t) = V dot i $

U s'exprime toujours comme une énergie potentielle entre une charge et une ou plusieurs autres charges.

En méca, l'énergie potentielle dépend du champ dans lequel la charge est introduite (en méca $U = m g h$). En électromag pareil, elle dépend des autres charges présentes autour.

L'énergie potentielle est définie à une constante près. En méca on dit que $U("surface de la Terre") = 0$ pour simplifier les calculs. En électromag on dit $U(infinity) = 0$ (quand les deux charges sont éloignées à l'infini alors l'énergie potentielle est nulle).

$ W_(A arrow B) = Delta U $

(par exemple en méca $W_(A arrow B) = m g h_a - m g h_b$)

Si $nabla V = 0$, le potentiel est constant, ça signifie que le champ est nul dans la direction dans laquelle on effectue le travail, mais on peut avoir un champ perpendiculaire à la direction.

== Champ magnétique

#emoji.warning le champ créé par un objet c'est comme $omega$ (le vecteur rotation), ça dit dans quel sens ça tourne, pas vers quoi l'objet est attiré

=== Unités

$arrow(B)$ en Tesla (T) \
Gauss $equiv 10^(-4) T$ 

Si on a un courant i dans un fil de longueur $L$ et un champ magnétique $B$. La force est perpendiculaire au courant *et* au champ.

$ arrow(F_B) = i arrow(L) times arrow(B) $
$ =  (d q)/(d t) d arrow(l) times arrow(B) $
$ = (d q) arrow(v) times arrow(B) $

La force de Lorentz ne change pas la norme du vecteur vitesse mais la direction (pas de travai).

$ arrow(F_("Lorentz")) = q arrow(v) times arrow(B) $

Dans une trajectoire circulaire d'une charge de masse $m$:
$ (m v^2)/r = q v B $
donc :
$ R = (m v)/(q B) " et " "freq" = 1/T = v/(2 pi r) = (q B)/(2 pi m) $

$ omega = 2 pi f $

à distance $r$ d'une charge, on a le champ magnétique $ arrow(B(r)) = mu_0/(4 pi) q 
(arrow(v) times arrow(r))/(r^2) $

$mu_0 = 4 pi 10^(-2)$ (en Tm/A).

$ d B = mu_0/(4 pi) i (d arrow(l) times arrow(r))/(r^2) $

$ B_"tot" = integral_(- L)^(+ L) d B $ 

Norme du champ magnétique à distance $x$ du fil :

$ B = (mu_0 i)/(2 pi x sqrt(x^2 + L^2)) $

Pour $x << L$:

$ B = (mu_0 i)/(2 pi x) $

== Loi d'ampère

$ integral.cont_C arrow(B) arrow(d l) = mu_0 sum i_"entourés" $
Pour un cercle :
$ B(r) 2 pi r = mu_0 i $

== Moment magnétique

décrit la force et l'orientation d'un dipôle magnétique, comme une boucle de courant ou un aimant.

$ arrow(mu) = i arrow(A) $

où $norm(arrow(A))$ est la surface que le câble entoure et $arrow(A)$ pointe hors de la surface (comme le vecteur de rotation). Il essaye de s'aligner avec le champ magnétique.

== Couple magnétique

la force de rotation exercée sur un dipôle magnétique placé dans un champ magnétique non uniforme ou incliné.

$ arrow(tau) = arrow(mu) times arrow(B) $

Le couple magnétique tend à aligner le moment magnétique avec le champ magnétique.

== Loi de Lenz (flux magnétique)

$ epsilon = -d(Phi_B)/(d t) $

quand le flux change (la surface par exemple), la force élecromotrice doit générer un courant (donc un champ) qui s'oppose à celui qui la génère (donc à la différence de flux magnétique)

$ Phi_B = integral_S arrow(B) d arrow(A) $
Si B est constant sur la surface $Phi_B = B dot S$.


== Convertir et déplacer l'énergie

=== Transformateurs

$ epsilon_"grand"/epsilon_"petit" = N_"grand"/N_"petit" $

== Inductance

Il faut vraiment voir L (l'inductance) comme une bobine qui créé un champ magnétique.

$ L = Phi_B/i $

force électromotrice :

$ epsilon = - d(Phi_B)/(d t) = - d/(d t) i L = - L (d i)/(d t) $

== Inductance mutuelle

Quand on met deux bobines à côté l'une de l'autre, le champ magnétique de l'une va influencer l'autre :

$ M_(12) = M_(21) = Phi_B_1/i_2 $

L'énergie stockée dans l'inductance (la bobine) :

$ U_L = 1/2 L i^2 $

= Circuits RL

Un circuit RL est composé d'une résistance et d'une bobine. Lorsque le courant traverse la bobine, un champ magnétique est créé. Lorsque le courant est interrompu, le champ magnétique diminue jusqu'à zéro. Cela crée une force électromotrice qui s'oppose à la variation du courant.

== Charge

$ i(t) = (v_0/R) (1 - exp(-t/(L/R))) $
$ V_L (t) = V_0exp(-t/(L/R)) $

== Décharge

$ i(t) = (V_0/R) exp(-t/(L/R)) $
$ V_L (t) = - V_0 exp(-t/(L/R)) $

= Circuits AC et impédance complexe

L'impédance c'est une propriété du circuit, comme la résistance. Pour un rapport $V$ et $I$ donné, on a une impédance fixe.

$ R_"juste de la résistance" = V_"bornes" / I_"circuit" $
$ Z_"juste de la résistances" = R = V_"bornes" / I_"circuit" $
$ Z_"tot" = V_"circuit" / I_"circuit" $

En fait $Z$ c'est un peu une généralisation de la résistance pour tout un circuit, qui prend en compte les effets de la capacité et de l'inductance.

On sait que :
$ V(t) = V_0 (cos(w t) + i sin(w t))$
On peut écrire $V(t) = V_0 exp(i w t)$
$ d/(d t) V(t) = i w V(t) $
$ d^2/(d t^2) V(t) = - w^2 V(t) $

Impédance complexe : $ Z(t) = V(t)/I(t) $

== Pour la résistance :

$ V - I(t)R = 0 $
$ I(t) = V(t)/R $
$ Z_R (t) = V(t)/I(t) = V(t)/(V(t) / R) = R $

== Pour la capacité :

$ I(t) = (d Q(t)) / (d t) = (d (C V(t)))/(d t) = C (i omega V(t)) $
$ Z_C (t) = V(t) / (C i omega V (t)) = (1 dot i) / (i omega C dot i) = - i/(omega C) $

== Pour l'inductance :

$ V(t) - L (d I(t))/(d t) = 0 $
$ I(t) = V(t) / (i omega L) = - (i V(t))/(omega L) $
$ Z_L (t) = i L omega $

== Dans un circuit avec une résistance, une capacité et une inductance :

$ I(t) = V(t)/(Z_"tot" (t)) = V(t)/(R - i/(omega C) + i L omega) $
$ = (V_0 exp(i omega t) exp(- i phi_Z))/(norm(Z_"tot")) $ 

$norm(Z_"tot") = sqrt(R^2 + (omega L - 1/(omega C))^2) $

l'impédance totale (en série) est la somme des impédances.

En fonction des conditions initiales on décide si on garde la partie réelle (cos) ou la partie imaginaire (sin). p. ex. s'il n'y a pas de courant initialement, on prend la partie imaginaire.

=== Conditions particulières

//- quand $omega arrow 0$, $I(t) = V(t) IL EST PASSE OU LE R$
//- quand $omega arrow infinity, I(t) = (V_0 e^(i omega t)e^(-i pi/2))/(omega L)$
- quand $ omega L = 1/(omega C) = 0$, résonance, $I(t) = V(t)/R$

== Courant de déplacement

$ i_D = epsilon_0 d/(d t) epsilon_A arrow(E) dot d(arrow(A)) $

== Dernière équation de Maxwell

à revoir, to do

$ integral.cont_"C (frontière)" arrow(B) d arrow(l) = mu_0 i_"entourés" + 1/C^2 d/(d t) (integral arrow(E) d arrow(A)) $

$ integral.cont_"A (surface)" (arrow(nabla) times arrow(B)) d arrow(A) = integral integral mu_o J + 1/C^2 d/(d t) arrow(E) d arrow(A) $

avant :

$  arrow(nabla) times arrow(B) = mu_0 arrow(J) $

après avoir ajouté le courant de déplacement :

$  arrow(nabla) times arrow(B) = mu_0 arrow(J) + 1/(C^2) d/(d t) arrow(E) $

TODO on les trouve d'où ces énergies ?

énergie magnétique :

$ U_B = 1/(2 mu_0) integral_V B^2 $

énergie électrique :

$ U_E = 1/(2 epsilon_0) integral_V E^2 $

TODO :

== Ondes électromagnétiques

$ (partial^2 E_x)/(partial z^2) = 1/(C^2) (partial^2 E)/2(partial t^2) $

$ E_X(z, t) = g(z - c t) + h(z + c t) $

La forme de l'onde reste la même :

On veut que $g(z_1 - c t_1) = g(z_1 + delta z - c(t_1 + delta t))$. On a donc $delta z = c delta t$.

$ E(z, t) = E_0 cos(k z - omega t) $

Soit $lambda$ la longueur d'onde, on a $lambda = c T$.

Numéro d'onde : $ k = (2 pi) / lambda$

=== Densité d'énergie dans une onde électromagnétique

Densité des champs électromagnétique : $ u = 1/(2 mu_0) B^2 + 1/2 epsilon_0 E^2 $

mais dans les ondes électromagnétiques, on a $ B = E/c $, donc : $ u = epsilon_0 E^2$

Vecteur de Pointing, indique dans quelle direction se propage l'énergie d'une onde électromagnétique : $ arrow(S) = 1/(mu_0) arrow(E) times arrow(B) $

$arrow(S)$ mesure le flux instantané d'énergie.
