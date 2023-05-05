package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.math.pow
import Problem36.primeFactorMultiplicity
object Problem37 extends App{
  val logger = Logger(getClass)
  logger.info("improved Eucler's Totient :"+improvedEuclersTotient(315))

  def improvedEuclersTotient(number: Int): Double = {
    def helper(remainingList: List[(Int, Int)], result: Double): Double = {
      remainingList match {
        case Nil => result.toInt
        case head:: tail => helper(tail, (result*((head._1-1)*pow(head._1,head._2-1))))
      }
    }
    helper(primeFactorMultiplicity(number), 1)
  }
}
