package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem46 extends App{
  val logger = Logger(getClass)
  logger.info("and gate : " + and(false,true))
  logger.info("or gate : " + or(true,false))
  logger.info("nand gate : " + nand(true,false))
  logger.info("xor gate : " + xor(false,false))
  logger.info("xnor gate : " + xnor(false,true))

  def and(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne,expressionTwo) match {
      case (false,false) => false
      case (true,false) => false
      case (false,true) => false
      case (true,true) => true
    }
  }

  def or(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne, expressionTwo) match {
      case (false, false) => false
      case (true, false) => true
      case (false, true) => true
      case (true, true) => true
    }
  }

  def not(expression: Boolean): Boolean = {
    expression match{
      case true => false
      case false => true
    }
  }

  def nand(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne, expressionTwo) match {
      case (false, false) => true
      case (true, false) => true
      case (false, true) => true
      case (true, true) => false
    }
  }

  def xor(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne, expressionTwo) match {
      case (false, false) => false
      case (true, false) => true
      case (false, true) => true
      case (true, true) => false
    }
  }

  def impl(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne, expressionTwo) match {
      case (false, false) => true
      case (true, false) => false
      case (false, true) => true
      case (true, true) => true
    }
  }

  def xnor(expressionOne: Boolean, expressionTwo: Boolean): Boolean = {
    (expressionOne, expressionTwo) match {
      case (false, false) => true
      case (true, false) => false
      case (false, true) => false
      case (true, true) => true
    }
  }
}
