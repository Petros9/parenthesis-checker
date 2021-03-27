package com.virtuslab

import java.nio.file.Paths
import java.nio.file.Files

import scala.annotation.tailrec
import scala.jdk.CollectionConverters._

/**
  * Main class, which an entry point to executing the code.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val code = readFromFile("C:\\Users\\Svatopluk\\Desktop\\Scala\\recruitment-main\\code-samples\\SimpleCorrect.scala")
    //val code = "class A { method( \") \"/*   ) */ ) () (/*(((())))))(((((*/) // ) }"
    println("### Input code")
    println(code)
    println()
    println("### Does it have correct parenthesis?")
    val (correctParenthesis, potentialPosition) = areCorrectParenthesis(CodeTokenizer.redundantTokenMapper(CodeTokenizer.tokenizeCode(code)), 0, 0, 0 )
    if (correctParenthesis) println("Yes!")
    else println("No! Wrong parenthesis at position: " + potentialPosition)
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
    * stack scala code to evaluate
    * @return Boolean answer to the the posed question.
    */

  // the solution bases on pseudo-buffer, whether we encounter valid '(' 1 is added to the buffer
  // and whether we encounter ')' 1 is subtracted from the buffer,
  // the function returns false if we encounter ')' with the "empty" buffer or the buffer in the end is not "empty"
  // the potential spot is set when the program reaches '(' or ')' with empty buffer
  @tailrec
  def areCorrectParenthesis(code: String, currentPosition: Int, pseudoStack:Int, potentialSpot:Int): (Boolean, Int) = {
    if (currentPosition.equals(code.length)) {
      (pseudoStack.equals(0), potentialSpot)

    } else if (code.charAt(currentPosition).equals('(')) {
      if (pseudoStack.equals(0)) Main.areCorrectParenthesis(code, currentPosition + 1, pseudoStack + 1, currentPosition)
      else Main.areCorrectParenthesis(code, currentPosition + 1, pseudoStack + 1, potentialSpot)

    } else if (code.charAt(currentPosition).equals(')')) {
      if (pseudoStack.equals(0)) Main.areCorrectParenthesis(code, code.length, pseudoStack + 1, currentPosition)
      else Main.areCorrectParenthesis(code, currentPosition + 1, pseudoStack - 1, potentialSpot)

    } else {
      Main.areCorrectParenthesis(code, currentPosition+1, pseudoStack, potentialSpot)
    }
  }
}
