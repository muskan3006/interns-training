package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem38 extends App {

  val logger = Logger(getClass)
  private val compareTotientFunctions = new CompareTotientFunctions
  logger.info("" + compareTotientFunctions.compare(10090))

}

class CompareTotientFunctions {
  def compare(number: Int): Boolean = {
    val totientFunction1 = new TotientFunction
    val totientFunction2 = new TotientFunction2
    val result = totientFunction1.totientFunction(number)
    val result2 = totientFunction2.getTotientFunction2(number)
    if (result == result2) true
    else false
  }
}