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


