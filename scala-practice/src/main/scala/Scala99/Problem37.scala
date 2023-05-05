package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.math.pow

object Problem37 extends App {

  val logger = Logger(getClass)
  val totientFunction2 = new TotientFunction2
  logger.info("" + totientFunction2.getTotientFunction2(315))
}

class TotientFunction2 {

  private val primeFactorization2 = new PrimeFactorization2
  def getTotientFunction2(number: Int): Int = {
    val result = primeFactorization2.primeFactors(number)

    @tailrec
    def resultOfTotientfunction(number: Int, list: List[(Int, Int)]): Int = {
      list match {
        case Nil => number
        case head :: Nil => number * helperFunction(head)
        case head :: tail => resultOfTotientfunction(number * helperFunction(head), tail)
      }
    }

    resultOfTotientfunction(1, result)
  }

  private def helperFunction(number: (Int, Int)): Int = {
    val result = (number._1 - 1) * pow(number._1, number._2 - 1)
    result.toInt
  }
}