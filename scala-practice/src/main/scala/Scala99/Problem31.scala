package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem31 extends App{
  val logger = Logger(getClass)
  logger.info("Number is prime or not :" +isPrime(17))

  private def isPrime(number: Int): Boolean = {
    @tailrec
    def helper(accumulator: Int): Boolean = {
      if(accumulator == 1) true
      else if(accumulator == 2) true
      else if (number % accumulator == 0) false
      else helper(accumulator - 1)
    }
    helper(number / 2)
  }
}