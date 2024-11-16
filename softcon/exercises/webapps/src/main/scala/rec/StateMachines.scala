package rec

trait StateMachine[State, Event, Result]:
  def init: State
  def update(s: State, e: Event): State // Sometimes called *transition*
  def finish(s: State): Result

def processEvents[S, E, R](sm: StateMachine[S, E, R])(events: List[E]): R =
  sm.finish(events.foldLeft(sm.init)(sm.update))

object PatternMatching:
  case class State(lastWord: Option[String], occurencesCount: Int)

  type Event = String

  type Result = Int

  object PatternMatchingSM extends StateMachine[State, Event, Result]:
    def init = State(None, 0)

    def update(s: State, e: Event) =
      State(
        Some(e),
        s.occurencesCount
          + (if s.lastWord == Some("CS") && e == "214" then 1 else 0)
      )

    def finish(s: State) = s.occurencesCount

  val countMatchesSM: List[String] => Int =
    processEvents(PatternMatching.PatternMatchingSM)

  def countMatchesSM2(l: List[String]): Int =
    processEvents(PatternMatching.PatternMatchingSM)(l)

def isBalanced(str: List[Char]): Boolean =
  def loop(str: List[Char], numOpen: Int): Int =
    if numOpen < 0 then numOpen
    else
      str match
        case Nil           => numOpen
        case '(' :: next   => loop(next, numOpen + 1)
        case ')' :: next   => loop(next, numOpen - 1)
        case other :: next => loop(next, numOpen)
  loop(str, 0) == 0

object IsBalanced:

  val isBalancedSM: List[Char] => Boolean =
    processEvents(TODO)

case class WordCountState(count: Int, lastWasWS: Boolean)

def wordCount(l: List[Char]): Int =
  l.foldLeft[WordCountState](WordCountState(0, true))((state: WordCountState, c: Char) =>
    val cIsWS = c.isWhitespace
    val count = state.count + (if state.lastWasWS && !cIsWS then 1 else 0)
    WordCountState(count, cIsWS)
  ).count

object WordCount:

  val wordCountSM: List[Char] => Int =
    processEvents(TODO)
