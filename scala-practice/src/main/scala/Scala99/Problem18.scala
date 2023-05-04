package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem18 extends App{
  val logger = Logger(getClass)
  logger.info("take a slice of list : " +extractAList(2,5,List(4,2,7,1,9,0,3)))

  private def extractAList[T](startingNumber: Int, endNumber: Int, list: List[T]): List[T] = {
    def helper(count: Int, remainingList: List[T], result: List[T]): List[T] = {
      (count, remainingList) match{
        case (_, Nil) => result.reverse
        case (c, _ :: _) if endNumber < c => result.reverse
        case (c, head::tail)  if startingNumber <= c => helper(c+1,tail,head::result)
        case (c, _::tail) => helper(c+1,tail, result)
      }
    }
    helper(1, list,Nil)
  }
}
