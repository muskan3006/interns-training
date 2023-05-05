package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
object Problem18 extends App {
  val logger = Logger(getClass)
  val list = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
  private val slice = new Slice
  logger.info("" + slice.sliceList(2, 5, list, List.empty, 0))
}
class Slice {
  @tailrec
  final def sliceList[A](start: Int, end: Int, list: List[A], resultList: List[A], counter: Int): List[A] = {
    list match {
      case Nil => resultList
      case _ :: Nil => resultList
      case head :: tail => if (counter >= start && counter <= end) sliceList(start, end, tail, resultList :+ head, counter + 1)
      else sliceList(start, end, tail, resultList, counter + 1)
    }
  }
}
