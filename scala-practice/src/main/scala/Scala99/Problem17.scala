package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem17 extends App {
  val logger = Logger(getClass)
  val split = new Split
  val list = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
  logger.info("" + split.splitList(4, list, (List.empty, List.empty), 0))

}

/*
split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
(List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */

class Split {
  @tailrec
  final def splitList[A](splitLength: Int, list: List[A], resultList: (List[A], List[A]), counter: Int): (List[A], List[A]) = {
    list match {
      case Nil => resultList
      case _ :: Nil => resultList
      case head :: tail =>
        if (splitLength != counter && splitLength >= counter)
          splitList(splitLength, tail, (resultList._1 :+ head, tail), counter + 1)
        else splitList(splitLength, tail, resultList, counter + 1)
    }
  }
}