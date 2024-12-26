#set text(font: "DejaVu Sans")
#show heading.where(level: 1): contents => text(size: 20pt, contents)
#show heading: contents => pad(bottom: 10pt, contents)
#set quote(block: true)
#set heading(numbering: (ignore_first, ..n) => {
  if (n.pos().len() != 0) {
    numbering("1.1.", ..n)
  }
})

== Série 1

Méthode pour calculer la force exercée par la barre sur $q_0$.

#image("posts/exo1.png")

- écrire l'expression de la force selon un vecteur $arrow(r)$.
- ici, on sait que la force sur $y$ va se compenser, donc on intègre la force selon $arrow(x)$ pour trouver $F_"tot"$.

Attention, quand on intègre, il ne faut pas oublier de décomposer le vecteur $arrow(r)$ selon les différentes composantes (qui seront dans le calcul de l'intégrale !) :
$ arrow(r) = (D_1 arrow(e_r) + D_2 arrow(e_z))/(sqrt(D_1^2 + D_2^2)) $

== Série 2

Exo 1 : On veut calculer la valeur du champ $E$ engendré par une barre le long de l'axe $x$ sur une droite parallèle. En fait on peut le calculer en un point (avec comme coordonnées $x = L + d, y = 0$)! Ce sera la même valeur pour tous les points de la droite.

Exo 4 : placer le point O au centre du dipole pour calculer son moment cinétique.

Exo 6 : utiliser Gauss pour calculer E !
