package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem32 extends App{
  val logger = Logger(getClass)
  logger.info("Greatest common divisor :" + greatestCommonDivisor(36, 63))
  @tailrec
  def greatestCommonDivisor(numberOne: Int, numberTwo: Int): Int = {
    if(numberTwo == 0) numberOne
    else greatestCommonDivisor(numberTwo, numberOne % numberTwo)
  }
}
