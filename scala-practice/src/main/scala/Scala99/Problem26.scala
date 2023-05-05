package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.util.Random

object Problem26 extends App{
  val logger = Logger(getClass)
  private val generateCombination = new GenerateCombination
  logger.info(""+generateCombination.generateCombinations(2, List('a', 'b', 'c')))

}

class GenerateCombination {
  val logger = Logger(getClass)
  val random = new Random

  @tailrec
  final def generateCombinations[A](distinctElements: Int, list: List[A]): List[List[A]] = {
    val listLength = list.length

    @tailrec
    def listOfCombinations(combination: BigInt, counter: Int, resultList: List[List[A]], list2: List[A]): List[List[A]] = {
      if (counter == combination) resultList
      else {
        listOfCombinations(combination, counter + 1, resultList :+ getListOfUniqueElements(distinctElements, list2, List.empty), list2)
      }
    }
    val combination = getCombination(listLength, distinctElements)
    val listOfCombination = listOfCombinations(combination, 0, List.empty, list)
    val distinctListOFCombination = listOfCombination.distinct

    if(listOfCombination == distinctListOFCombination) distinctListOFCombination
    else
      generateCombinations(distinctElements, list)
  }

  def getListOfUniqueElements[A](distinctElements: Int, list: List[A], resultList: List[A]): List[A] = {
    val randomNumber = new RandomNumber
    val listOfElements = randomNumber.extractRandom(distinctElements, list)
    val distinctElement = listOfElements.distinct
    if (listOfElements == distinctElement && distinctElement.length == distinctElements) {
      resultList ++ distinctElement
    }
    else getListOfUniqueElements(distinctElements, list, resultList)
  }

   def getCombination(firstValue: Int, secondValue: Int): BigInt = {
    if (secondValue < 0 || firstValue < secondValue) {
      Integer.MAX_VALUE
    }
    else {
      @tailrec
      def factorial(n: Int, accumulator: Int): BigInt = {
        if (n <= 1) accumulator
        else factorial(n - 1, n * accumulator)
      }
      factorial(firstValue, 1) / (factorial(secondValue, 1) * factorial(firstValue - secondValue, 1))
    }
  }
}


