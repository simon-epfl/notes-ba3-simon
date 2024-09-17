== Combinatorics

We want to choose `k` elements among `n` elements.

#table(
  columns: (auto, auto, auto),
  table.header(
    [], [*Repetition not allowed*], [*Repetition allowed*], 
  ),
  [*Order does not matter*], [$ n!/((n-k)!k!) $ (`n` choices, then `n-1` choices, etc. and we stop at `n-k`, we also remove `n!` because order does not matter and `n!` is the number of permutations)], [ $ binom(n - 1 + r, n - 1) $ It's stars and bars method. We want `r` stars + `n` stars for each box. Then, we transform `n-1` of these stars into bars to separate the `r` stars into boxes.],
  [*Order matters*], [$ n! $ (`n` choices, then `n-1` choices, etc.)], [$ n^k $ Cartesian product.]
)

== Probabilities

=== Solving a probability problem

- list possible outcomes, define the probability space
- sometimes we keep a general $Omega$ and different $cal(F)$ depending on the point of view (colorblind/not colorblind, etc.)

=== Terminology

- $Omega$ is the *sample space*, containing all possible outcomes $omega$.
- $cal(F)$ is an *event space* (there are multiple event spaces!). It is a set of the subsets of $Omega$. The powerset of $Omega$ includes all $cal(F)$. $|cal(F)| = 2^(|Omega|)$ only if $Omega$ is finite.

$cal(F)$ is also called a sigma-algebra.

