package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem22 extends App{
  val logger = Logger(getClass)
  logger.info("List of Interger :" + listOfIntegers(-6,4))

  private def listOfIntegers(start: Int, end: Int): List[Int] = {
    @tailrec
    def helper(counter: Int, resultList: List[Int]): List[Int] = {
      counter match{
        case count if(count>end) => resultList.reverse
        case count if(count>=start || count<=end) => helper(count+1,count::resultList)
      }
    }
    helper(start,Nil)
  }
}
