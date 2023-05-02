package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem15 extends App {
  val logger = Logger(getClass)
  logger.info("Create the duplicate elements given number of times :" + duplicatesNumberOfTimes(2, List(2, 3, 4, 5)))

  def duplicatesNumberOfTimes[T](numberOfTimes: Int, list: List[T]): List[T] = {
    if(list.isEmpty) list
    list.flatMap{
      List.fill(numberOfTimes)(_)
    }
  }
}
