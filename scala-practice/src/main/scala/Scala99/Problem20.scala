package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem20 extends App{
  val logger = Logger(getClass)
  logger.info("remove kth element :" +removeKthElement(3, List(2,3,4,5,6,7)))
  logger.info("remove kth element :" +removeKthElement(3, List('a','b','d','c','e','y')))

  private def removeKthElement[T](number: Int, list: List[T]): (List[T],T) = {
    @tailrec
    def helper(counter: Int, remainingList: List[T], result: List[T]): (List[T],T) = {
      (counter, remainingList) match {
        case(_, Nil) => (result.reverse,list(number))
        case (count, head::tail) if(count == number) => helper(count + 1, tail,result)
        case (count, head::tail) => helper(count + 1, tail,head::result)
      }
    }
    helper(0,list,Nil)
  }

}
