package contextual

/** Exception thrown by `break` internally. */
private final class Break[T](val label: Label[T], val value: T) extends RuntimeException(
      /*message*/ null, /*cause*/ null, /*enableSuppression=*/ false, /*writableStackTrace*/ false
    )

/** Labels are targets indicating which boundary will be exited by a `break`. */
private final class Label[-T]

object naiveBoundary:
  /** Abort current computation and instead return `value` as the value of the
    * enclosing `boundary` call that created `label`.
    */
  def break[T](value: T)(label: Label[T]): Nothing =
    ???

  /** Run `body` with freshly generated label as argument. Catch any breaks
    * associated with that label and return their results instead of `body`'s
    * result.
    */
  inline def apply[T](inline body: Label[T] => T): T =
    ???

object boundary:
  /** Abort current computation and instead return `value` as the value of the
    * enclosing `boundary` call that created `label`.
    */
  def break[T](value: T)(using label: Label[T]): Nothing =
    ???

  /** Run `body` with freshly generated label as implicit argument. Catch any
    * breaks associated with that label and return their results instead of
    * `body`'s result.
    */
  inline def apply[T](inline body: Label[T] ?=> T): T =
    ???
