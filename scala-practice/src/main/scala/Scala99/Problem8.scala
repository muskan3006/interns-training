package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem8 extends App {
  val logger = Logger(getClass)
  logger.info("remove consecutive elements :" + removeConsecutiveDuplicates(List(1, 2, 2, 3, 5, 2)))

  private def removeConsecutiveDuplicates[T](list: List[T]): List[T] = {
    list.foldRight[List[T]](Nil) {
      case (myList, newList) => {
        if (newList.isEmpty || newList.head != myList) myList :: newList
        else newList
      }
    }
  }
}
