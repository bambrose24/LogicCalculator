package test_package

object LogicCalculator{
  
package logic

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
case class And() extends Logic
case class Or() extends Logic
case class Not() extends Logic
case class Implies() extends Logic
case class Iff() extends Logic
case class Exor() extends Logic

object Main {
  def main(args: Array[String]): Unit = {

    val file = new File("line.txt")
    val reader = new BufferedReader(new FileReader(new File("line.txt")))
    val line = reader.readLine()
    reader.close()

    val nnf = solve(parse(line))

    println("TEST")
  }
}

}