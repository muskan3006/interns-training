package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem17 extends App{
  val logger = Logger(getClass)
  logger.info("split a list into two parts : " + splitAList(3,List(5,6,7,8,9,1)))
  def splitAList[T](splitNumber: Int, list: List[T]): (List[T], List[T]) = {
    def helper(num: Int, remainingList: List[T], resultList: List[T]): (List[T], List[T]) = {
      (num, remainingList) match {
        case (1, endList) => (resultList.reverse, endList)
        case (_, head::tail) => helper(num - 1, tail, head :: resultList)
      }
    }
    helper(splitNumber, list, Nil)
  }
}
