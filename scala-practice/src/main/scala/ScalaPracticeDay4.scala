package com.knoldus

import com.typesafe.scalalogging.Logger

object ScalaPracticeDay4 extends App {
  val logger = Logger(getClass)
  logger.info("evaluate number class : " + ExpressionCalculatorShrasti.evaluate(TakeNumber(5)))
  logger.info("evaluate Sum class : " + ExpressionCalculatorShrasti.evaluate(SumOfTwoNumbers(TakeNumber(10), TakeNumber(20))))
  logger.info("evaluate Sum class : " + ExpressionCalculatorShrasti.evaluate(SumOfTwoNumbers(SumOfTwoNumbers(TakeNumber(7), TakeNumber(8)), TakeNumber(13))))
  logger.info("evaluate Multiply Class: " + ExpressionCalculatorShrasti.evaluate(MultiplyOfTwoNumbers(SumOfTwoNumbers(TakeNumber(1), TakeNumber(2)), SumOfTwoNumbers(TakeNumber(5), TakeNumber(3)))))
  logger.info("evaluate minus class: " + ExpressionCalculatorShrasti.evaluate(MinusOfTwoNumbers(SumOfTwoNumbers(MinusOfTwoNumbers(TakeNumber(54), TakeNumber(96)), TakeNumber(17)), MultiplyOfTwoNumbers(TakeNumber(7), TakeNumber(9)))))
  logger.info("evaluate Divide Class : " + ExpressionCalculatorShrasti.evaluate(MultiplyOfTwoNumbers(SumOfTwoNumbers(DivideOfTwoNumbers(TakeNumber(100), TakeNumber(10)), MultiplyOfTwoNumbers(TakeNumber(15), DivideOfTwoNumbers(TakeNumber(50), TakeNumber(5)))), MinusOfTwoNumbers(MultiplyOfTwoNumbers(TakeNumber(69), TakeNumber(47)), TakeNumber(178)))))
}

abstract class ExpressionShrasti

case class TakeNumber(n: Int) extends ExpressionShrasti

case class SumOfTwoNumbers(expression1: ExpressionShrasti, expression2: ExpressionShrasti) extends ExpressionShrasti

case class MinusOfTwoNumbers(expression1: ExpressionShrasti, expression2: ExpressionShrasti) extends ExpressionShrasti

case class MultiplyOfTwoNumbers(expression1: ExpressionShrasti, expression2: ExpressionShrasti) extends ExpressionShrasti

case class DivideOfTwoNumbers(expression1: ExpressionShrasti, expression2: ExpressionShrasti) extends ExpressionShrasti

object ExpressionCalculatorShrasti {
  def evaluate(expr: ExpressionShrasti): Int = expr match {
    case TakeNumber(n) => n
    case SumOfTwoNumbers(expression1, expression2) => evaluate(expression1) + evaluate(expression2)
    case MinusOfTwoNumbers(expression1, expression2) => evaluate(expression1) - evaluate(expression2)
    case MultiplyOfTwoNumbers(expression1, expression2) => evaluate(expression1) * evaluate(expression2)
    case DivideOfTwoNumbers(expression1, expression2) =>
      if (evaluate(expression2) == 0) 0
      else evaluate(expression1) / evaluate(expression2)
  }
}

