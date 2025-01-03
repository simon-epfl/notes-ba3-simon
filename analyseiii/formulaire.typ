== Définitions de base

$ norm(arrow(x) times arrow(y)) = det mat(
   "", "+", "-", "+";
   "+", "axe1", "axe2", "axe3";
   "-", "vect1x", "vect1y", "vect1z";
   "+", "vect2x", "vect2y", "vect2z";
) $

$ "div" F(arrow(x)) = sum_(i = 1)^n (partial F_i)/(partial x_i)(arrow(x)) $

La divergence est positive si elle se comporte comme une source, négative si elle se comporte comme un puit.

$$ \mathbb{R}^2, \text{rot} F(x, y) = \frac{\partial F_2}{\partial x} (x, y) - \frac{\partial F_1}{\partial y} (x, y) $$

$$ \mathbb{R}^3, \text{rot} F(x, y, z) = \left( \frac{\partial F_3}{\partial y} - \frac{\partial F_2}{\partial z}, \frac{\partial F_1}{\partial z} - \frac{\partial F_3}{\partial x}, \frac{\partial F_2}{\partial x} - \frac{\partial F_1}{\partial y} \right) $$

$ RR^2, "rot" F(x, y) = (partial F_2)/(partial x) (x, y) - (partial F_1)/(partial y) (x, y) $

$ RR^3, "rot" F(x, y, z) = ((partial F_3)/(partial y) - (partial F_2)/(partial z), (partial F_1)/(partial z) - (partial F_3)/(partial x), (partial F_2)/(partial x) - (partial F_1)/(partial y)) $

La première coordonnée du rotationnel donne l'intensité de la rotation autour de l'axe x, la deuxième autour de l'axe y, la troisième autour de l'axe z.

$ laplace f(arrow(x)) = sum_(i = 1)^n (partial^2 f)/(partial x_i^2)(arrow(x)) $

Si le laplacien est strictement négatif, alors $f(x_0)$ est plus grande que sa valeur moyenne au tour de $x_0$, si le laplacien est strictement positif, alors $f(x_0)$ est plus petite que sa moyenne.

== Théorèmes de base

$ "div"(nabla f) = laplace f $
$ "rot"(nabla f) = 0 $
car $nabla$ F pointe vers la plus grande augmentation de $f$. Or si le rotationnel de $nabla$ F était différent de zéro, cela signifierait une augmentation de $f$ infinie (on tournerait en boucle!). \
$ "div"("rot" F) = 0 $
car le rotationnel de F est un champ de vecteurs qui tournent (et ne sortent ou ne rentrent pas dans la surface) donc la divergence, qui mesure cela, est nulle.

$ nabla (f g) = f nabla g + g nabla f $

== Formules

Pour une fonction $f$ scalaire :
$ integral_Gamma f d l = integral_a^b f(gamma(t))|gamma quote.single (t)| d t in RR $
Pour une fonction $F$ à plusieurs dimensions :
$ integral_Gamma F dot d l = integral_a^b angle.l F(gamma(t)) ; gamma quote.single (t) angle.r d t in RR $
