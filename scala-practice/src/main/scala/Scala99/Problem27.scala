package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.collection.immutable._

object Problem27 extends App {
  val logger = Logger(getClass)
  private val disjointSubSet = new DisjointSubSet
  logger.info("" + disjointSubSet.getDisjointSetOfList(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")))
}

class DisjointSubSet {

  val generateCombination = new GenerateCombination
  def getDisjointSetOfList[A](list: List[A]): List[List[List[A]]] = {
    val fullSet = list.toSet
    for {
      first <- generateCombinations(2, list)
      noASet = fullSet -- first.toSet
      second <- generateCombinations(3, noASet.toList)
    } yield List(first, second, (noASet -- second.toSet).toList)
  }

  @tailrec
  private final def generateCombinations[A](distinctElements: Int, list: List[A]): List[List[A]] = {
    val listLength = list.length
    @tailrec
    def listOfCombinations(combination: BigInt, counter: Int, resultList: List[List[A]], list2: List[A]): List[List[A]] = {
      if (counter == combination) resultList
      else {
        listOfCombinations(combination, counter + 1, resultList :+ generateCombination.getListOfUniqueElements(distinctElements, list2, List.empty), list2)
      }
    }
    val combination = generateCombination.getCombination(listLength, distinctElements)
    val listOfCombination = listOfCombinations(combination, 0, List.empty, list)
    val distinctListOFCombination = listOfCombination.distinct

    if (listOfCombination == distinctListOFCombination) distinctListOFCombination
    else
      generateCombinations(distinctElements, list)
  }
}
