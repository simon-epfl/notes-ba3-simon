package memo

enum Peg:
  case Left, Middle, Right

case class Move(from: Peg, to: Peg)

def hanoiHelper(src: Peg, dst: Peg, third: Peg, n: Int): Seq[Move] =
  ???

def hanoi(n: Int): Seq[Move] =
  ???

case class PegState(
    name: Peg,
    disks: Seq[Int] // from bottom to top
)

def viewMoves(ms: Seq[Move], n: Int) =
  val baseW = 2 * n + 1

  def center(s: String, w: Int, padding: String = " ") =
    require(padding.length == 1)
    val lr = w - s.length
    padding * (lr / 2) ++ s ++ padding * (lr - lr / 2)

  def base(name: Peg) =
    center(name.toString, baseW, "=")

  def disk(w: Int): String =
    center("-" * w ++ "|" ++ "-" * w, baseW, " ")

  val empty: String =
    center("|", baseW, " ")

  def peg(p: PegState): Seq[String] =
    base(p.name) +: (p.disks.map(disk) ++ Seq.fill(n - p.disks.size)(empty))

  def pegs(ps: List[PegState]): String =
    ps.map(peg).transpose.map(_.mkString(" ")).reverse.mkString("\n")

  def configuration(cnf: Map[Peg, Seq[Int]]): String =
    pegs(List(Peg.Left, Peg.Middle, Peg.Right).map(k => PegState(k, cnf(k))))

  def moves(ms: Seq[Move]) =
    var cnf = Map(
      Peg.Left -> (n to 1 by -1),
      Peg.Middle -> Seq(),
      Peg.Right -> Seq()
    )

    println(configuration(cnf))
    for Move(from, to) <- ms do
      println(f"\n$from → $to")
      assert(cnf(from).size > 0)
      assert(cnf(to).isEmpty || cnf(from).last < cnf(to).last)
      cnf = cnf
        .updatedWith(from)(v => Some(v.get.dropRight(1)))
        .updatedWith(to)(v => Some(v.get :+ cnf(from).last))
      println(configuration(cnf))

  moves(ms)
