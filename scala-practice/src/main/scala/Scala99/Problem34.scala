package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem34 extends App {
  val logger = Logger(getClass)
  private val totientFunction = new TotientFunction
  logger.info("" + totientFunction.totientFunction(10))
}

class TotientFunction {

  val gcd = new GCD
  def totientFunction(number: Int): Int = {

    @tailrec
    def getTotientResult(counter: Int, result: Int): Int = {
      if (counter == number) result
      else {
        if (gcd.gcd(counter, number) == 1)
          getTotientResult(counter + 1, result + 1)
        else
          getTotientResult(counter + 1, result)
      }
    }

    getTotientResult(0, 0)
  }
}