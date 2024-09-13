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

=== 
