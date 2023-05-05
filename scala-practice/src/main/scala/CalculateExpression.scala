package com.knoldus

import com.typesafe.scalalogging.Logger

object CalculateExpression extends App {
  val logger = Logger(getClass)
  logger.info("" + ExpressionsCalculator.evaluate(Numbers(5)))
  logger.info("" + ExpressionsCalculator.evaluate(SumTwoNumber(Numbers(10), Numbers(20))))
  logger.info("" + ExpressionsCalculator.evaluate(SumTwoNumber(SumTwoNumber(Numbers(7), Numbers(8)), Numbers(13))))
  logger.info("" + ExpressionsCalculator.evaluate(MultiplyTwoNumber(SumTwoNumber(Numbers(1), Numbers(2)), SumTwoNumber(Numbers(5), Numbers(3)))))
  logger.info("" + ExpressionsCalculator.evaluate(MinusTwoNumber(SumTwoNumber(MinusTwoNumber(Numbers(54), Numbers(96)), Numbers(17)), MultiplyTwoNumber(Numbers(7), Numbers(9)))))
  logger.info("" + ExpressionsCalculator.evaluate(MultiplyTwoNumber(SumTwoNumber(DivideByNumber(Numbers(100), Numbers(10)), MultiplyTwoNumber(Numbers(15), DivideByNumber(Numbers(50), Numbers(5)))), MinusTwoNumber(MultiplyTwoNumber(Numbers(69), Numbers(47)), Numbers(178)))))
  logger.info("" + ExpressionsCalculator.evaluate(DivideByNumber(Numbers(1), Numbers(0))))
}

abstract class Expressions

case class Numbers(n: Int) extends Expressions

case class SumTwoNumber(expression1: Expressions, expression2: Expressions) extends Expressions

case class MinusTwoNumber(expression1: Expressions, expression2: Expressions) extends Expressions

case class MultiplyTwoNumber(expression1: Expressions, expression2: Expressions) extends Expressions

case class DivideByNumber(expression1: Expressions, expression2: Expressions) extends Expressions

object ExpressionsCalculator {
  def evaluate(expression: Expressions): Int = {
    expression match {
      case Numbers(value) => value
      case SumTwoNumber(value1, value2) => helperFunction(SumTwoNumber(value1, value2), "+")
      case MultiplyTwoNumber(value1, value2) => helperFunction(MultiplyTwoNumber(value1, value2), "*")
      case MinusTwoNumber(value1, value2) => helperFunction(MinusTwoNumber(value1, value2), "-")
      case DivideByNumber(value1, value2) => helperFunction(DivideByNumber(value1, value2), "/")
      case _ => 0
    }
  }

  // helper function return the result
  private def helperFunction(expression: Expressions, operator: String): Int = {
    operator match {

      case "+" => val result1 = expression match {
        case SumTwoNumber(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case SumTwoNumber(_, expression2) => evaluate(expression2)
        }
        result1 + result2

      case "*" => val result1 = expression match {
        case MultiplyTwoNumber(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case MultiplyTwoNumber(_, expression2) => evaluate(expression2)
        }
        result1 * result2

      case "/" => val result1 = expression match {
        case DivideByNumber(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case DivideByNumber(_, expression2) => evaluate(expression2)
        }
        if (result2 == 0) 0 else result1 / result2

      case "-" => val result1 = expression match {
        case MinusTwoNumber(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case MinusTwoNumber(_, expression2) => evaluate(expression2)
        }
        result1 - result2
      case _ => 0
    }
  }
}
