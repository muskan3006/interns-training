package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec
import scala.util.Random

object Problem24 extends App{
  val logger = Logger(getClass)
  logger.info("randomly choosed :" + nRandomNumbers(4,49))

  private def nRandomNumbers(randonChoosedNumber: Int, maximumRange: Int): List[Int] = {
    @tailrec
    def rangeHelper(counter: Int, resultList: List[Int]): List[Int] = {
      counter match {
        case count if count > maximumRange => randomSelect(randonChoosedNumber,resultList.reverse)
        case count if count <= maximumRange => rangeHelper(count + 1, count :: resultList)
      }
    }
    rangeHelper(1,Nil)
  }

  private def randomSelect[T](number: Int, list: List[T]): List[T] = {
    @tailrec
    def randomSelectHelper(count: Int, remainingList: List[T], result: List[T]): List[T] = {
      val random = new Random
      if (count > 0) randomSelectHelper(count - 1, remainingList, remainingList(random.nextInt(list.length)) :: result)
      else result
    }
    randomSelectHelper(number, list, Nil)
  }
}
