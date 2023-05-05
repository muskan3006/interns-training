package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.Console.println
import scala.annotation.tailrec

object Problem12  extends App{
  val logger = Logger(getClass)
  val list =List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
  val length = list.length

  private val decodeRunLength = new DecodeRunLength
  logger.info(""+decodeRunLength.decodeRunLength(list,List.empty,length))

}

/*
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
 */

class DecodeRunLength {
  val logger = Logger(getClass)
  def decodeRunLength[A](list: List[(Int, A)], resultList: List[A], length: Int): List[A] = {
     list match {
      case Nil => resultList
      case head ::Nil =>resultList ++ executeTimes(head._1,head._2,List.empty)
      case head :: tail => decodeRunLength(tail ,resultList ++ executeTimes(head._1, head._2, List.empty),length)
    }
  }
   @tailrec
   private def executeTimes[A](intValue: Int, charValue: A, list: List[A]): List[A] = {
    if (intValue == 0) list
    else {
      executeTimes(intValue - 1, charValue, list :+ charValue)
    }
  }
}

