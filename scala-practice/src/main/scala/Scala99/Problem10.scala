package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem10 extends App {
  val logger = Logger(getClass)
  val list = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  val runLength = new RunLength
  logger.info("" + runLength.runLength(list, List.empty))
}

class RunLength {
  @tailrec
  final def runLength[A](list: List[A], resultList: List[(Int, A)]): List[(Int, A)] = {
    if (list.isEmpty) resultList
    else {
      val (head, tail) = list span (_ == list.head)
      val length = head.length
      runLength(tail, resultList :+ (length, list.head))
    }
  }
}