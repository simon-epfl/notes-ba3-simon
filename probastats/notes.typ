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

==== Example for a fair die:

- *Sample space:* ${1,2,3,4,5,6}$
- *Events*: ${1}, {2}, {3}, {4}, {5}, {6}, {1, 2}, {1, 3}, ..., {1, 2, 3, 4, 5, 6}$ note that this is only for one throw! ${a,b}$ is read "getting $a$ or getting $b$".
- *Event space:* all events

=== Axioms

$ P(A union B) = P(A) + P(B) - P(A sect B)$

Generalization of the OR between events:

$ P(A_1) + P(A_2) + P(A_3) - P(A_1 sect A_2) - P(A_2 sect A_3) - P(A_1 sect A_3) + P(A_1 sect A_2 sect A_3) $
$ PP(union_(i = 1)^n A_i) = sum_(r = 1)^n (-1)^(r+1) sum_(1 <= i_1 < i_2 < ... < i_r < n) (A_i_1 sect ... sect A_i_r) $

(les $i_k$ doivent donc être différents)

Conditional probabilities:

$ P(A|B) = P(A sect B)/P(B) $

=== Law of total probability

Let ${B_i}_(i = 1)^infinity$ be pairwise disjoint events, and let $A subset union_(i = 1)^(infinity) B_i$ then:

$ P(A) = sum_(i = 1)^(infinity) P(A sect B_i) = sum_(i = 1)^(infinity) PP(A|B_i)PP(B_i) $

Bayes' Theorem:

$ PP(A|B) = (PP(B|A)PP(A))/(PP(B)) $

but we can replace $P(B)$ by what we know, low of total probability:

$ PP(A|B) = (PP(B|A)PP(A))/PP(B) = (PP(B|A)PP(A))/(PP(B|A)PP(A) + PP(B|A^c)PP(A^c)) $
