package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem38 extends App{
  val logger = Logger(getClass)
  logger.info("compare : " +compareEuclersToTient(315))

  import Problem34.eulersToTient
  import Problem37.improvedEuclersTotient

  def compareEuclersToTient(number: Int): Boolean = {
    val resultOne = eulersToTient(number)
    val resultTwo = improvedEuclersTotient(number)
    if(resultOne == resultTwo) true
    else
      false
  }
}
