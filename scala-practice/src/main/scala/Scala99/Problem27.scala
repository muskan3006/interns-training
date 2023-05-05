package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem27 extends App {
  val logger = Logger(getClass)
  logger.info("group of disjoint subset :" +groupThree(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")))

  def groupThree[T](list: List[T]): List[List[List[T]]] =
    for {
      breakList <- combinations(2, list)
      combined = (list.toSet -- breakList.toSet).toList
      b <- combinations(3, combined)
    } yield List(breakList, b, (combined.toSet -- b.toSet).toList)

  def group[T](listOne: List[Int], listTwo: List[T]): List[List[List[T]]] = listOne match {
    case Nil => List(Nil)
    case number :: _ => combinations(number, listTwo) flatMap { element =>
      group(listOne, (listTwo.toSet -- element.toSet).toList) map {
        element :: _
      }
    }
  }

  private def combinations[T](number: Int, list: List[T]): List[List[T]] = {
    if (number == 0) List(Nil)
    else list.combinations(number).toList
  }
}


