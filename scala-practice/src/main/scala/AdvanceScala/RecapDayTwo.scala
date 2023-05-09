package com.knoldus
package AdvanceScala
import com.typesafe.scalalogging.Logger

object RecapDayTwo extends App{
  val logger = Logger(getClass)
  def curriedAdder(number1: Int)(number2: Int): Int = number1 + number2
  val adder: Int => Int = curriedAdder(3)
  println(adder(8))

  def incrementor: Int => Int = (number : Int) => number + 1
  logger.info("increment the list : " + List(2,3,4).map(incrementor))

  def simpleAddFunction:(Int, Int) => Int = (number1: Int, number2: Int) => number1 + number2   //curried function values
  def simpleAddMethod(number1: Int, number2: Int): Int = number1 + number2
  def curriedAddMethod(number1: Int)(number2: Int): Int = number1 + number2

  val addFunction = (number: Int)=> simpleAddFunction(7, number)
  val add = simpleAddFunction.curried
  val addMethod = simpleAddMethod(7, _: Int)
  val addcurried = curriedAddMethod(7)(_)

  logger.info("add by function :" +add)
  logger.info("add by method : "+ addMethod(4))

  def curriedFormatter(inputString: String)(number: Double): String = inputString.format(number)
  val myList = List(3.14, 6.22, 9.8, 1)

  val simpleFormatter = curriedFormatter("%4.5f")(_)
  logger.info("foramtter : " + myList.map(simpleFormatter))

  lazy val number: Int = {
    println("hello")
    42
  }
  println(number)
  println(number)

  def byNameMethod(inputnumber: => Int) : Int = {
    lazy val number = inputnumber
    number + number +  number
  }
  def retrieveValue: Int = {
    logger.info("print the value")
    42
  }
  logger.info("print the value using lazy val " +byNameMethod(retrieveValue))
}
