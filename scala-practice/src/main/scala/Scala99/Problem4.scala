package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem4 extends App {
  val logger = Logger(getClass)
  logger.info("number of elements in list : " + numberOfElements(List(2, 3, 4, 5, 6)))

  private def numberOfElements[T](list: List[T]): Int = {
    list match {
      case Nil => Int.MinValue
      case _ => list.length
    }
  }
}
