package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem46  extends App{

  val logger = Logger(getClass)
  private val logicalExpressions = new LogicalExpressions
  logger.info("" + logicalExpressions.andOperation(expression1 = false, expression2 = true))
  logger.info("" + logicalExpressions.orOperation(expression1 = false, expression2 = true))
  logger.info("" + logicalExpressions.nandOperation(expression1 = true, expression2 = true))
  logger.info("" + logicalExpressions.norOperation(expression1 = false, expression2 = false))
  logger.info("" + logicalExpressions.xorOperation(expression1 = true, expression2 = true))
  logger.info("" + logicalExpressions.xorNorOperation(expression1 = true, expression2 = true))
  logger.info("" + logicalExpressions.implOperation(expression1 = true, expression2 = true))


}

class LogicalExpressions {

  def andOperation(expression1:Boolean ,expression2 :Boolean): Boolean={
    if(expression2 && expression1) true
    else
      false
  }

  def orOperation(expression1:Boolean ,expression2 :Boolean): Boolean={
    if(!expression1 && !expression2) false
    else
      true
  }

  def nandOperation(expression1:Boolean ,expression2 :Boolean): Boolean= {
    if(!andOperation(expression1,expression2))true
    else
      false
  }

  def norOperation(expression1: Boolean, expression2: Boolean): Boolean = {
    if (!orOperation(expression1, expression2)) true
    else
      false
  }

  def xorOperation(expression1: Boolean, expression2: Boolean): Boolean = {
    (expression1,expression2) match {
      case (true, true) => false
      case (true, false) => true
      case (false, true) => true
      case (false, false) => false
    }
  }

  def xorNorOperation(expression1: Boolean, expression2: Boolean): Boolean = {
    (expression1, expression2) match {
      case (true, true) => true
      case (true, false) => false
      case (false, true) => false
      case (false, false) => true
    }
  }

  def implOperation(expression1: Boolean, expression2: Boolean): Boolean = {
    (expression1, expression2) match {
      case (true, true) => true
      case (true, false) => false
      case (false, true) => true
      case (false, false) => true
    }
  }
//  def table2(f: (Boolean, Boolean) => Boolean) {
//    println("A     B     result")
//    for {a <- List(true, false);
//         b <- List(true, false)} {
//      printf("%-5s %-5s %-5s\n", a, b, f(a, b))
//    }
//  }
}
