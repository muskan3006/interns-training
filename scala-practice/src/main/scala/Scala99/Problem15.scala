package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem15  extends App{
  val logger = Logger(getClass)
  val list = List('a', 'b', 'c', 'c', 'd')

  private val duplicateTheElement = new DuplicateNthTime
  logger.info(""+ duplicateTheElement.duplicateNthTime(3,list,List.empty))
}

class DuplicateNthTime {
  @tailrec
  final def duplicateNthTime[A](nth: Int, list: List[A], resultList: List[A]): List[A] = {
    list match {
      case Nil => resultList
      case head :: Nil => resultList ++ nthTimes(nth, head, List.empty)
      case head :: tail => duplicateNthTime(nth,tail, resultList ++ (nthTimes(nth, head, List.empty)))
    }
  }

  @tailrec
  private def nthTimes[A](nth: Int, element: A, result: List[A]): List[A] = {

    if (nth == 0) result
    else {
      nthTimes(nth - 1, element, result :+ element)
    }
  }
}

