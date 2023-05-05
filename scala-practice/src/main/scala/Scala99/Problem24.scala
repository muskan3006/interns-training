package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem24 extends App {

  val logger = Logger(getClass)
  private val generateRandomNumberUpToMth = new GenerateRandomNumberUpToNthNumber
  logger.info("" + generateRandomNumberUpToMth.randomNumberFromSet(6, 20))
}

class GenerateRandomNumberUpToNthNumber {

  /*  RandomNumber from  Problem 23
   it contains method extractRandom which gives the list of
   random number from a given list of defined size
   */
  val randomNumber = new RandomNumber

  def randomNumberFromSet(numbers: Int, mthValue: Int): List[Int] = {
    @tailrec
    def listOfRandomNumber(list: List[Int], counter: Int): List[Int] = {
      if (mthValue == counter) list
      else {
        listOfRandomNumber(list :+ counter, counter + 1)
      }
    }
    randomNumber.extractRandom(numbers, listOfRandomNumber(List.empty, 0))
  }
}
