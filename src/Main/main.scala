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
  case class Literal(ch: Char) extends Expression

  def main(args: Array[String]): Unit = {

    val reader = new BufferedReader(new FileReader(new File("equation.txt")))
    val l = reader.readLine()
    reader.close()

    val line = parse(l)
    val exp = makeExpression(line)
    //val nnf = nnf(parse(line))

    println("TEST")
    println(parse(l))
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

  def makeExpression(lst: ArrayList[Logic]): Expression = {

    lst.get(0) match {
      case LParen() => { // start a new expression, need to get list through right paren
        var temp = new ArrayList[Logic]()
        var j = 1
        while (lst.get(j) != RParen()) { // make a flag for if no RParen() shows up
          temp.add(lst.get(j))
        }
        makeExpression(temp)
      }
      case RParen() => { // end the new expression? not sure
        println("SHOULD NOT HAVE GOTTEN HERE RPAREN")
      }
      case Implies() => { // use as an operator in an expression
        println("SHOULD NOT HAVE GOTTEN HERE " + Implies())
      }
      case Iff() => { // use as an operator for Exp2

      }
      case Not() => { // use as operator for Exp1
        
      }
      case Or() => { // use as operator for Exp2

      }
      case And() => { // use as operator for Exp2

      }
      case Xor() => { // use as operator for Exp2

      }
      case Literal(x) => { // check if solo, else make line to be processed recursively
        if (lst.size() == 1) Literal(x)
        else {
          var j = 0
          while (j < lst.size()) {

          }
        }
      }
    }
    null
  }

}