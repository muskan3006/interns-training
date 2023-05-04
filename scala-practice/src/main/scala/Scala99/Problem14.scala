package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem14 extends App {
  val logger = Logger(getClass)
  logger.info("Create the duplicate Elements :" + (createDuplicates(List(2, 3, 4, 5))))
  logger.info("Create the duplicate Elements :" + (createDuplicates(List())))

  def createDuplicates[T](list: List[T]): List[T] = {
    if (list.isEmpty) list
    list.flatMap(element => List(element, element))
  }
}
