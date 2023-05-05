package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem31  extends App {

  val logger =Logger(getClass)

  logger.info(""+isPrime(24))

  def isPrime(number: Int): Boolean = {
    if (number <= 1) {
      false
    } else {
      @tailrec
      def isPrimeHelper(incrementer: Int): Boolean = {
        if (incrementer > math.sqrt(number)) {
          true
        } else if (number % incrementer == 0) {
          false
        } else {
          isPrimeHelper(incrementer + 1)
        }
      }
      isPrimeHelper(2)
    }
  }
}

