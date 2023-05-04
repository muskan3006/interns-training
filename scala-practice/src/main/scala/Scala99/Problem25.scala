package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec
import scala.util.Random

object Problem25 extends App{
  val logger = Logger(getClass)
  logger.info("random permutation :" + randomPermute(List(2,3,4,5,6,7)))

  private def randomPermute[T](list: List[T]): List[T] = {
    randomSelect(list.length,list)
  }

  private def randomSelect[T](number: Int, list: List[T]): List[T] = {
    @tailrec
    def helper(count: Int, remainingList: List[T], result: List[T]): List[T] = {
      val random = new Random
      if (count > 0) helper(count - 1, remainingList, remainingList(random.nextInt(list.length)) :: result)
      else result
    }
    helper(number, list, Nil)
  }
}
