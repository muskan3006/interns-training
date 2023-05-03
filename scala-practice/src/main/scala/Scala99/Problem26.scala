package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem26 extends App{
  val logger = Logger(getClass)
  logger.info("combinations :" +combinations(4, List('a','b','c','d','e','f')))

  private def combinations[T](number: Int, list: List[T]): List[List[T]] = {
    if(number == 0) List(Nil)
    else list.combinations(number).toList
  }
}
