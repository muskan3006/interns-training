package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem22 extends App {
  val logger = Logger(getClass)
  private val range = new RangeList
  logger.info("" + range.range(2, 6, List.empty))
}

/*
Create a list containing all integers within a given range.
range(4, 9)
List(4, 5, 6, 7, 8, 9)
 */
class RangeList {
  @tailrec
  final def range(start: Int, end: Int, resultList: List[Int]): List[Int] = {
    if (start == end + 1) resultList
    else {
      range(start + 1, end, resultList :+ start)
    }
  }
}