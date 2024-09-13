== Reminder: Euclidean spaces

- We work in n-dimensional space $x = (x_1, x_2, ..., x_n) $.
- 2D: $v = (x_1, x_2) = (x, y)$
- 3D: $v = (x_1, x_2, x_3) = (x, y, z)$

=== Scalar product

If we have $x = (x_1, ..., x_n) $ and $y = (y_1, ..., y_n) $, then:
$ x dot y = angle.l x,y angle.r = x_1y_1 + ... + x_n\y_n $

=== Cross product (3D)

$x = (x_1, x_2, x_3)$

$y = (y_1, y_2, y_3)$

$ x times y = (x_2y_3 - x_3y_2, x_3y_1 - x_1y_3, x_1y_2-x_2y_1) $


=== Scalar Field

A scalar field
$ F : RR arrow.r RR, x arrow.r F(x) $

assigns a scalar value to every point.

Examples: temperature, chemical concentration, pressure, probability distribution.

Given a scalar field $ F^n arrow.r RR$, the level set of the value $ c in RR$ is:
$ { x in RR^n : f(x) = c } $


=== Vector Field

A vector field  assigns a vector to each point in space:
$ F : RR^n arrow.r RR^n, x arrow.r (F_1(x), ..., F_n (x)) $

Examples:
- $F : RR^2 arrow.r RR^2, (x_1, x_2) arrow.r (-x_2, x_1)$
- $F : RR^2 arrow.r RR^2, (x_1, x_2) arrow.r (2x_1, x_2 + x_3, x_1x_2x_3)$

How to visualize vector fields? Put one arrow for each point in space.
- constant vector field
- rotational vector field
- source vector field

#pagebreak()

=== Gradient, Hessian, Laplacian

If $ F : RR^n arrow.r RR$ is a scalar field, then the gradient is the vector field

$ nabla F =  (partial x_1 f, partial x_2 f, ..., partial x_n f) $

$ nabla = mat(
  partial x_1;
  partial x_2;
  ...;
  partial x_n;
) $

$ "grad" f = nabla f = mat(
  partial x_1 f;
  partial x_2 f;
  ...;
  partial x_n f;
) $

Example:

$ f(x_1, x_2) = x_1^3 + x_1x_2^5 $
$ gradient f(x_1, x_2) = (3x_1^2 + x_2^5, x_1 dot 5x_2^4) $

- Geometrically, $ gradient f$ points in the direction of the steepest increae of $f$
- The directional derivative of $f$ in direction $v in RR^n$ is:
$ D_v f = gradient f dot v = partial x_1 f dot v + ... + partial x_n f dot v_n $

The value $ D_v f$ tells us how $f$ changes as we move in direction $v$.

- Along any level set line, the gradient is orthogonal.

Example:

$f(x_1, x_2) = x_1^2 + x_2^2$

$gradient f(x_1, x_2) = (2x_1, 2x_2)$

Level set of $c = 1$.

If $ F : RR^n arrow.r RR$ is a scalar field, then the Hessian of $f$ is a matrix field:

$ gradient^2 f = mat(
  partial_1 partial_1 f, partial_1partial_2 f, ..., partial_1partial_n f;
  ..., ..., ..., ...;
  partial_n partial_1 f, ..., ..., partial_n partial_n f
) $

- The Hessian is symmetric if all 2nd directives are continuous

- Physical/geometric interpretation contains information on the curvature of the scalar field

If $ F : RR^n arrow.r RR$ is a scalar field, then the Laplacian of $f$ is the scalar field:

$ laplace f = sum_(i = 1)^n partial_i partial_i f = partial_i partial_i f + partial_2 partial_2 f + ... + partial_n partial_n f $

- Sum of the diagonal entries of the Hessian

- Physically relevant in modeling diffusion

Poisson problem : $ - laplace u = f$ ($u$ is an unknown scalar field, while $f$ is known, it's a differential equation).

Example:

$ f(x, y, z) = x y^3e^z $
$ gradient f(x) = (y^3e^z, 3x\y^2e^z, x\y^3e^z) $

$ partial x partial x f = 0 $
$ partial x partial y f = 3y^2e^z $
$ partial x partial z f = y^3e^z $
$ partial y partial y f = 6x\ye^z $
$ partial y partial z f = 3x\y^2e^z $
$ partial z partial z f = x\y^3e^z $

$ nabla^2 f = mat(
  0, 3y^2e^z, y^3e^z;
  3y^2e^z, 6x\ye^z, 3x\y^2e^z;
  y^3e^z, 3x\y^2e^z, x\y^3e^z;
) $

$ laplace f = 0 + 6x\ye^z + x\y^3e^z = e^z\x\y(6 + y^2) $

Example:

$ F(x) = ||x|| = sqrt(sum_(i = 1)^n x_i^2), x in RR^n $

First partial derivatives:

$ partial_i F(x) = partial_i (sum_(i = 1)^n x_i^2)^(1/2) = 1/2 (sum_(i = 1)^n x_i^2)^(-1/2) dot 2x_i = 1/(||x||) x_i = x_i/(||x||) $

Notice the singularity at $x = 0$. It looks like the gradient is not defined but in fact it can be removed by continuous extension of the first derivatives.

Second partial derivatives (case disjunction):

$ partial_i partial_i f(x) = partial_i (x_i/(||x||)) = partial_i (x_i dot ||x||^(-1)) = 1/(||x||) + x_i dot (-1/(||x||^2)(partial_i ||x||)) $
$ = 1/(||x||) + x_i dot -1/(||x||^2) dot x_i/(||x||) = 1/(||x||) - x^2 dot 1/(||x||^3) $

$ partial_j partial_i f(x) = partial_j (x_i/(||x||)) = 0 + x_i dot -1/(||x||^2)(partial_j ||x||) = x_i dot -1/(||x||^2) (x_j)/(||x||) = (-x_i x_j)/(||x||^3) $

All partial derivatives of order 2, we can build the Hessiam matrix.

We want the Laplacian too:

$ laplace f(x) = sum_(i = 1)^n partial_i partial_i f(x) = sum_(i = i)^n 1/(||x||) - (x_i^2)/(||x||^3) = n/(||x||) - (sum_(i = 1)^n x_i^2)/(||x||^3) $
$ = n/(||x||) - (||x||^2)/(||x||^3) = (n-1)/(||x||) $

== Divergence

Given a vector field $ F : RR^n arrow.r RR^n, x arrow.r (F_1(x), ..., F_n(x))$

The divergence is the vector field:

$ "div" F = sum_(i = 1)^n partial_i F_i = partial_1 F_1 + partial_2 F_2 + ... + partial_n F_n $

- formally, $"div" F = nabla dot F $
- the Laplacian is the divergence of the gradient: $laplace F = "div" gradient F$

Example:

$ "div" (x_1^2x_2, x_2^3, e^(x_3)) = 2x_1x_2 + 3x_2^2 + e^(x_3) $

== Rotation or curl of vector fields

If $ F: RR^3 arrow.r RR^3$ is a 3D vector field, $F=(F_1, F_2, F_3)$, then the curl/rotation is a 3D vector field:

$ "curl" F = "rot" F = mat(
  - partial_3 F_2 + partial_2 F_3;
  - partial_1 F_3 + partial_3 F_1;
  - partial_2 F_1 + partial_1 F_2;
) $

Formally, $ "curl" F = nabla times F$.

Only works in 3D. There is a rotation in 2D:

If $F : RR^2 arrow.r RR^2$ is a 2D vector fireld, then the rotation/curl of $F$ is a scalar field.

$ "curl" F = "rot" F = - partial_2 F_1 + partial_1 F_2 $

Motivation: we formally extend the vector field with a third coordinate $F_3 = 0$.

$ tilde(F) = mat(
  F_1;
  F_2;
  0
) => "curl" F = mat(
  - partial_3 F_2 + partial_2 F_3;
  - partial_1 F_3 + partial_3 F_1;
  - partial_2 F_1 + partial_1 F_2;
) = mat(
  0;
  0;
  - partial_2 F_1 + partial_1 F_2;
) $

Examples: the divergence measures the presence of sinks and sources ("puits et sources"), while rotation measures the presence of a spin.
