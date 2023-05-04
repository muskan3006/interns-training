package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem5 extends App {
  val logger = Logger(getClass)
  logger.info("reverse a list : " + reverseAList(List(2, 3, 4, 5, 6)))

  private def reverseAList[T](list: List[T]): List[T] = {
    def reverseHelper(resultedList: List[T], remainingList: List[T]): List[T] = {
      remainingList match {
        case Nil => resultedList
        case head :: tail => reverseHelper(head :: resultedList, tail)
      }
    }
    reverseHelper(Nil, list)
  }
}
