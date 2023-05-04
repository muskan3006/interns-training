package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec


object Problem16 extends App{
  val logger = Logger(getClass)
  logger.info("drop nth element from the list : " +dropNthElement(3, List(4,6,2,7,4,8)))
  private def dropNthElement[T](number: Int, list: List[T]): List[T] = {
    @tailrec
    def dropHelper(num: Int, remainingList: List[T], resultList: List[T]): List[T] = {
      (num, remainingList) match {
        case (_, Nil) => resultList.reverse
        case (1, _ :: tail) => dropHelper(number, tail , resultList)
        case (_ , head:: tail) => dropHelper(num - 1, tail , head :: resultList)
      }
    }
    dropHelper(number, list, Nil)
  }

}
