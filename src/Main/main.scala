package Main

object Main {

  import java.io._
  import java.util._

  sealed trait Logic
  sealed trait Expression extends Logic
  sealed trait Operator extends Logic
  sealed trait BinaryOp extends Operator
  sealed trait UnaryOp extends Operator

  case class LParen() extends Logic
  case class RParen() extends Logic
  case class And() extends BinaryOp
  case class Or() extends BinaryOp
  case class Not() extends UnaryOp
  case class Implies() extends BinaryOp
  case class Iff() extends BinaryOp
  case class Xor() extends BinaryOp
  case class Exp2(e1: Expression, op: BinaryOp, e2: Expression) extends Expression
  case class Exp1(op: UnaryOp, e: Expression) extends Expression
  case class Literal(ch: Char) extends Logic

  def main(args: Array[String]): Unit = {

    val reader = new BufferedReader(new FileReader(new File("equation.txt")))
    val line = reader.readLine()
    reader.close()

    val nnf = nnf(parse(line))

    println("TEST")
    println(parse(line))
  }

  def parse(str: String): ArrayList[Logic] = {

    var terms: ArrayList[Logic] = new ArrayList()

    var i = 0;
    while (i < str.length()) {
      str.charAt(i) match {
        case '(' => terms.add(new LParen()) // left paren
        case ')' => terms.add(new RParen()) // right paren
        case '-' => terms.add(new Implies()) // implies
        case '>' => {} // ignore, end of implies or iff
        case '<' => { // iff, increment i 
          terms.add(new Iff())
          i += 1
        }
        case '!' => terms.add(new Not())
        case '|' => terms.add(new Or()) // or
        case '&' => terms.add(new And()) // and
        case ' ' => {} // ignore space
        case 'x' => { // xor, increment i twice
          terms.add(new Xor())
          i += 2
        }
        case x => terms.add(new Literal(x))
      }
      i += 1
    }
    terms
  }

  def nnf(lst: ArrayList[Logic]): Expression = {
    var i = 0
    while (i < lst.size()){
      
      lst.get(i) match {
        case LParen() => null // start a new expression, need to get list through right paren
        case RParen() => null // end the new expression? not sure
        case Implies() => null // use as an operator in an expression
        case Iff() => null // use as an operator for Exp2
        case Not() => null // use as operator for Exp1
        case Or() => null // use as operator for Exp2
        case And() => null // use as operator for Exp2
        case Xor() => null // use as operator for Exp2
        case Literal(x) => null // use as 
      }
            
      i += 1
    }
    null
  }

}