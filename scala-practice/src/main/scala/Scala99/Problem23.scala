package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.util.Random

object Problem23 extends App{
  val logger = Logger(getClass)
  logger.info("random selected :" +randomSelect(3,List(5,3,8,1,9,4,3)))

  private def randomSelect[T](number: Int, list: List[T]): List[T] = {
    def helper(count: Int, remainingList: List[T], result: List[T]): List[T] = {
      val random = new Random
      if(count > 0) helper(count -1, remainingList, remainingList(random.nextInt(list.length))::result)
      else result
    }
    helper(number, list, Nil)
  }
}
