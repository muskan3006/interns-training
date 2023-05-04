package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem21 extends App{
  val logger = Logger(getClass)
  logger.info("insert at index :"+insertAt(2,2,List(5,6,7,8,9,1)))
  logger.info("insert at index :"+insertAt('z',2,List('a','b','c','d','e','f')))

  private def insertAt[T](element: T, index: Int, list: List[T]): List[T] = {
    @tailrec
    def helper(counter: Int, remainingList: List[T], result: List[T]): List[T] = {
      (counter,remainingList) match{
        case (_ , Nil) => result.reverse
        case (count,head::tail) if(count!=index) => helper(count+1,tail,head::result)
        case (count, head:: tail) if(count==index)=> helper(count+1,tail,head::element::result)
      }
    }
    helper(0,list,Nil)
  }

}
