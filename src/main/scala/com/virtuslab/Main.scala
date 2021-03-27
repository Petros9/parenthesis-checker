package com.virtuslab

import java.nio.file.Paths
import java.nio.file.Files
import scala.jdk.CollectionConverters._

/**
  * Main class, which an entry point to executing the code.
  */
object Main {

  def main(args: Array[String]) = {
    val code = "class A{ method(() }"
    println("### Input code")
    println(code)
    println()
    println("### Does it have correct parenthesis?")
    if (areCorrectParenthesis(code)) println("Yes!")
    else println("No!")
  }

  /** Utility method to read code from a file path.
    *
    * @param name path to the file
    * @return String code snippet
    */
  def readFromFile(name: String): String = {
    Files.readAllLines(Paths.get(name)).asScala.mkString("\n")
  }

  /** This function takes an arbitrary Scala code sample and returns information
    * about whether for every opening parenthesis `(` we have a correct closing one.
    *
    * TODO We should also return the position of the first parenthesis that is not closed properly.
    * This will require changing the signature of the method, there are multiple possible approaches here.
    *
    * @param code scala code to evaluate
    * @return Boolean answer to the the posed question.
    */
  def areCorrectParenthesis(code: String): Boolean = false

}
