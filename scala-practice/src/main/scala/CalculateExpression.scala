package com.knoldus

import com.typesafe.scalalogging.Logger

object CalculateExpression extends App {
  val logger = Logger(getClass)
  logger.info("" + ExpressionCalculator.evaluate(Number(5)))
  logger.info("" + ExpressionCalculator.evaluate(Sum2(Number(10), Number(20))))
  logger.info("" + ExpressionCalculator.evaluate(Sum2(Sum2(Number(7), Number(8)), Number(13))))
  logger.info("" + ExpressionCalculator.evaluate(Mult2(Sum2(Number(1), Number(2)), Sum2(Number(5), Number(3)))))
  logger.info("" + ExpressionCalculator.evaluate(Minus2(Sum2(Minus2(Number(54), Number(96)), Number(17)), Mult2(Number(7), Number(9)))))
  logger.info("" + ExpressionCalculator.evaluate(Mult2(Sum2(Divide2(Number(100), Number(10)), Mult2(Number(15), Divide2(Number(50), Number(5)))), Minus2(Mult2(Number(69), Number(47)), Number(178)))))
  logger.info("" + ExpressionCalculator.evaluate(Divide2(Number(1), Number(0))))
}

abstract class Expression

case class Number(n: Int) extends Expression

case class Sum2(expression1: Expression, expression2: Expression) extends Expression

case class Minus2(expression1: Expression, expression2: Expression) extends Expression

case class Mult2(expression1: Expression, expression2: Expression) extends Expression

case class Divide2(expression1: Expression, expression2: Expression) extends Expression

object ExpressionCalculator {
  def evaluate(expression: Expression): Int = {
    expression match {
      case Number(value) => value
      case Sum2(value1, value2) => helperFunction(Sum2(value1, value2), "+")
      case Mult2(value1, value2) => helperFunction(Mult2(value1, value2), "*")
      case Minus2(value1, value2) => helperFunction(Minus2(value1, value2), "-")
      case Divide2(value1, value2) => helperFunction(Divide2(value1, value2), "/")
      case _ => 0
    }
  }

  // helper function return the result
  private def helperFunction(expression: Expression, operator: String): Int = {
    operator match {

      case "+" => val result1 = expression match {
        case Sum2(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case Sum2(_, expression2) => evaluate(expression2)
        }
        result1 + result2

      case "*" => val result1 = expression match {
        case Mult2(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case Mult2(_, expression2) => evaluate(expression2)
        }
        result1 * result2

      case "/" => val result1 = expression match {
        case Divide2(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case Divide2(_, expression2) => evaluate(expression2)
        }
        if (result2 == 0) 0 else result1 / result2

      case "-" => val result1 = expression match {
        case Minus2(expression1, _) => evaluate(expression1)
      }
        val result2 = expression match {
          case Minus2(_, expression2) => evaluate(expression2)
        }
        result1 - result2
      case _ => 0
    }
  }
}
