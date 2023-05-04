package com.knoldus

import com.typesafe.scalalogging.Logger

object ScalaPracticeDay4 extends App {
  val logger = Logger(getClass)
  logger.info("evaluate number class : " + ExpressionCalculator.evaluate(Number(5)))
  logger.info("evaluate Sum class : " + ExpressionCalculator.evaluate(Sum2(Number(10), Number(20))))
  logger.info("evaluate Sum class : " + ExpressionCalculator.evaluate(Sum2(Sum2(Number(7), Number(8)), Number(13))))
  logger.info("evaluate Multiply Class: " + ExpressionCalculator.evaluate(Multiply2(Sum2(Number(1), Number(2)), Sum2(Number(5), Number(3)))))
  logger.info("evaluate minus class: " + ExpressionCalculator.evaluate(Minus2(Sum2(Minus2(Number(54), Number(96)), Number(17)), Multiply2(Number(7), Number(9)))))
  logger.info("evaluate Divide Class : " + ExpressionCalculator.evaluate(Multiply2(Sum2(Divide2(Number(100), Number(10)), Multiply2(Number(15), Divide2(Number(50), Number(5)))), Minus2(Multiply2(Number(69), Number(47)), Number(178)))))
}

abstract class Expression

case class Number(n: Int) extends Expression

case class Sum2(expression1: Expression, expression2: Expression) extends Expression

case class Minus2(expression1: Expression, expression2: Expression) extends Expression

case class Multiply2(expression1: Expression, expression2: Expression) extends Expression

case class Divide2(expression1: Expression, expression2: Expression) extends Expression

object ExpressionCalculator {
  def evaluate(expr: Expression): Int = expr match {
    case Number(n) => n
    case Sum2(expression1, expression2) => evaluate(expression1) + evaluate(expression2)
    case Minus2(expression1, expression2) => evaluate(expression1) - evaluate(expression2)
    case Multiply2(expression1, expression2) => evaluate(expression1) * evaluate(expression2)
    case Divide2(expression1, expression2) =>
      if (evaluate(expression2) == 0) 0
      else evaluate(expression1) / evaluate(expression2)
  }
}

