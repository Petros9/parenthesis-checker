package com.virtuslab

import java.nio.file.Paths
import java.nio.file.Files
import java.util

import scala.annotation.tailrec
import scala.jdk.CollectionConverters._

/**
  * Main class, which an entry point to executing the code.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val code = "class A{ method(() }"
    println("### Input code")
    println(code)
    println()
    println("### Does it have correct parenthesis?")
    val stack = new util.Stack[Int]
    if (areCorrectParenthesis(code, 0, stack)) println("Yes!")
    else println("No! Wrong parenthesis at position: " +  stack.get(0))
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

  def addToStack(stack: util.Stack[Int], number: Int): util.Stack[Int] = {
    stack.push(number)
    stack
  }

  def takeFromStack(stack: util.Stack[Int]): util.Stack[Int] = {
    stack.pop()
    stack
  }

  @tailrec
  def areCorrectParenthesis(code: String, currentPosition: Int, stack: util.Stack[Int]): Boolean = {
    if (currentPosition.equals(code.length)) {
        stack.empty()

    } else if (code.charAt(currentPosition).equals('(')) {
      Main.areCorrectParenthesis(code, currentPosition + 1, addToStack(stack, currentPosition))

    } else if (code.charAt(currentPosition).equals(')')) {
      if (stack.empty()) Main.areCorrectParenthesis(code, code.length, addToStack(stack, currentPosition))
      else Main.areCorrectParenthesis(code, currentPosition + 1, takeFromStack(stack))

    } else {
      Main.areCorrectParenthesis(code, currentPosition+1, stack)
    }
  }

}
