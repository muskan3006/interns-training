
package com.knoldus

import com.typesafe.scalalogging.Logger

trait Animal {
  def eat(): Boolean
}

//generic Arithmetic operations
class ArithmeticOperations[A: Numeric] {
  def add(firstValue: A, secondValue: A): A = implicitly[Numeric[A]].plus(firstValue, secondValue)

  def subtraction(firstValue: A, secondValue: A): A = implicitly[Numeric[A]].minus(firstValue, secondValue)

  def multiply(firstValue: A, secondValue: A): A = implicitly[Numeric[A]].times(firstValue, secondValue)

  def divide(a: A, b: A)(implicit implicitValue: Integral[A]) = implicitValue.quot(a, b)
}


class FunctionsPractice {

  val partialFunction: PartialFunction[Int, Int] = {
    case anyValue if anyValue > 0 => anyValue * anyValue
  }


  val function1 = new Function2[Int, Int, Int] {
    override def apply(value: Int, value2: Int): Int = value2 + value
  }
  val function2: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(value: Int, value2: Int): Int = value + value2
  }

  def concatenateTwoString: (String, String) => String = new Function2[String, String, String] {
    override def apply(value1: String, value2: String): String = value1 + value2
  }

  def addingTwoNumber: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(value1: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(value2: Int): Int = value1 + value2
    }
  }

  def curryingFunction(value1: Int)(value2: Int)(value3: Int): Int = value1 + value2 + value3

  def partialAppliedFunction(value1: Int, value2: Int, value3: Int): Int = value3 + value2 + value1
}


class AnonymousFunctions {
  val doubleTheValue: (Int => Int) = (value: Int) => value * 2
  val squareTheValue: (Int => Int) = (value: Int) => value * value
  val stringToInt: (String => Int) = (stringValue: String) => stringValue.toInt
}


//
//class Hofs {
//
//  val list = List(2,3,4,5,6)
//  val resultForeach = list.foreach(f => f)
//
//}

object PracticeDay2 extends App {

  val logger = Logger(getClass)

  // Anonymous class
  private val anonymousClass = new Animal {
    override def eat(): Boolean = true
  }
  private val arithmeticOperations = new ArithmeticOperations[Int]
  private val addResult = arithmeticOperations.add(34, 23)
  private val subtractionResult = arithmeticOperations.subtraction(4, 23)
  private val multiplyResult = arithmeticOperations.multiply(4, 2)
  private val divideResult = arithmeticOperations.divide(34, 34)
  logger.info("Add Result =" + addResult)
  logger.info("Subtraction Result =" + subtractionResult)
  logger.info("Multiply  Result =" + multiplyResult)
  logger.info("Divide Result =" + divideResult)
  logger.info("Anonymous Class=" + anonymousClass.eat())


  private val functionsPractice = new FunctionsPractice
  private val resultFunction1 = functionsPractice.function1(2, 3)
  private val resultFunction2 = functionsPractice.function2(6, 6)
  private val resultOfConcatString = functionsPractice.concatenateTwoString("Hello", "World")
  private val resultOfAddingTwoNumber = functionsPractice.addingTwoNumber(2)(3)
  private val resultPartOneOfAddingTwoNumber = functionsPractice.addingTwoNumber(2)
  private val resultPartTwoOfAddingTwoNumber = resultPartOneOfAddingTwoNumber(3)

  private val resultOfCurryingFunction = functionsPractice.curryingFunction(2) _
  private val resultOfCurryingFunction2 = resultOfCurryingFunction(3)
  private val resultOfCurryingFunction3 = resultOfCurryingFunction2(4)
  private val resultOfPartialAppliedFunction = functionsPractice.partialAppliedFunction(4, _, _)
  private val resultOfPartialAppliedFunction2 = resultOfPartialAppliedFunction(4, _)
  private val resultOfPartialAppliedFunction3 = resultOfPartialAppliedFunction2(4)

  logger.info("Result of function1 =" + resultFunction1)
  logger.info("Result of function2 =" + resultFunction2)
  logger.info("Result of Concat Two String =" + resultOfConcatString)
  logger.info("Result of Adding two number =" + resultOfAddingTwoNumber)
  logger.info("Result of Adding Two number Part One=" + resultPartOneOfAddingTwoNumber)
  logger.info("Result of Adding Two number Part Two=" + resultPartTwoOfAddingTwoNumber)
  logger.info("Result of Currying Function =" + resultOfCurryingFunction)
  logger.info("Result of Currying Function2 =" + resultOfCurryingFunction2)
  logger.info("Result of Currying Function3 =" + resultOfCurryingFunction3)
  logger.info("Result of Partial Function =" + resultOfPartialAppliedFunction)
  logger.info("Result of Partial Function2 =" + resultOfPartialAppliedFunction2)
  logger.info("Result of Partial Function3 =" + resultOfPartialAppliedFunction3)

  private val anonymousFunctions = new AnonymousFunctions
  private val resultDoubleValue = anonymousFunctions.doubleTheValue(2)
  private val resultSquareValue = anonymousFunctions.squareTheValue(3)
  private val resultStringToInt = anonymousFunctions.stringToInt("3")
  logger.info("Result of Double Value =" + resultDoubleValue)
  logger.info("Result of SquareValue =" + resultSquareValue)
  logger.info("Result of String To Int =" + resultStringToInt)


}