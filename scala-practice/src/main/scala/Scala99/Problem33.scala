package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import Problem32.greatestCommonDivisor

object Problem33 extends App{
  val logger = Logger(getClass)
  logger.info("numbers are coprime or not :" +coPrime(7,15))

  def coPrime(numberOne: Int, numberTwo: Int): Boolean = {
    val gcd = greatestCommonDivisor(numberOne,numberTwo)
    if(gcd == 1) true
    else false
  }
}
