package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem11 extends App {

  val logger = Logger(getClass)
  val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  private val runLengthExtended = new RunLengthExtended
  logger.info(""+runLengthExtended.runLength(list, List.empty))
}


class RunLengthExtended {
  @tailrec
  final def runLength[A](list: List[A], resultList: List[Any]): List[Any] = {
    if (list.isEmpty) resultList
    else {
      val (head, tail) = list span (_ == list.head)
      val length = head.length
      if (length == 1)
        runLength(tail, resultList :+ (list.head))
      else
        runLength(tail, resultList :+ (length, list.head))
    }

  }
}
