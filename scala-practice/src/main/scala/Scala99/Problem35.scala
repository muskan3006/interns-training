package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem35 extends App {

  val logger = Logger(getClass)
  private val primeFactorizations = new PrimeFactorizations
  logger.info("" + primeFactorizations.primeFactors(315))

}

class PrimeFactorizations {
  def primeFactors(number: Int): List[Int] = {
    @tailrec
    def getListOfFactors(counter: Int, resultNumber: Int, resultList: List[Int]): List[Int] = {
      if (counter > number) resultList
      else {
        if (resultNumber % counter == 0)
          getListOfFactors(counter, resultNumber / counter, resultList :+ counter)
        else
          getListOfFactors(counter + 1, resultNumber, resultList)
      }
    }

    getListOfFactors(2, number, List.empty)
  }
}