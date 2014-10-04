package Main

object LogicCalculator {

  import java.io.File
  import java.io.FileReader
  import java.io.BufferedReader

  sealed trait Logic
  sealed trait Expression extends Logic
  sealed trait Operator extends Logic
  sealed trait BinaryOp extends Operator
  sealed trait UnaryOp extends Operator
  sealed trait Literal extends Logic

  case class LParen() extends Logic
  case class RParen() extends Logic
  case class And() extends BinaryOp
  case class Or() extends BinaryOp
  case class Not() extends UnaryOp
  case class Implies() extends BinaryOp
  case class Iff() extends BinaryOp
  case class Exor() extends BinaryOp
  case class Exp2(e1: Expression, op: BinaryOp, e2: Expression) extends Expression
  case class Exp1(op: UnaryOp, e: Expression)

  object Main {
    def main(args: Array[String]): Unit = {

      val file = new File("line.txt")
      val reader = new BufferedReader(new FileReader(new File("line.txt")))
      val line = reader.readLine()
      reader.close()

      //val nnf = nnf(parse(line))

      println("TEST")
      println()
    }
  }
  
  /*def parse(str: String): Expression = {
    
  }*/
  
  /*def nnf(e: Exp): Exp = e match {
    
  }*/

}