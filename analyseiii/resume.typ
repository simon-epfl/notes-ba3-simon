== Line integrals

On veut intégrer $f(x, y) = z$ (en bleu) selon le cercle, que l'on paramétrise comme $arrow(r)(t) = g(t)arrow(i) + h(t)arrow(j)$.

#image("res_lineintegrals_bef.png", width: 50%)

On peut d'abord réécrire notre fonction comme $f(t) = f(g(t), h(t))$. Pourquoi ? Parce que les seuls points qui nous intéressent sont ceux selon $g(h), h(t)$ !

#image("res_lineintegrals_mid.png", width: 50%)

Notre fonction aurait pu être comme ça, mais on veut juste être sur les points du cercle.

#image("res_lineintegrals.png", width: 60%)

Ici on veut l'aire donc $ A_k = f(x_k, y_k)Delta s_k $
$ A_k = f(x_k, y_k)sqrt((Delta x_k)^2 + (Delta y_k)^2) $
$ arrow.double.r d A = f(g(t), h(t))sqrt(g'(t)^2 + h'(t)^2 )d t $

#image("gaussgreen.png")
#image("rotations.png")
#image("liresume.png")

#pagebreak()

== Trouver un potentiel

- compute  $integral_0^x F(t) d t$
- compute $integral_x^y F(t) d t$
- sum them

