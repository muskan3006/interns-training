package com.knoldus
package Scala99

import com.knoldus.Scala99.Problem20.logger
import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem20 extends App {

  val logger = Logger(getClass)
  val list = List('a', 'b', 'c', 'd')
  private val removeKthElement = new RemoveKthElement
  logger.info("" + removeKthElement.removeAt(1, ' ', List.empty, list, 0))
}

class RemoveKthElement {
  @tailrec
  final def removeAt[A](index: Int, element: A, resultList: List[A], list: List[A], counter: Int): (List[A], A) = {
    list match {
      case Nil => (resultList, element)
      case head :: Nil => (resultList :+ head, element)
      case head :: tail => if (index == counter) removeAt(index, head, resultList, tail, counter + 1)
      else removeAt(index, element, resultList :+ head, tail, counter + 1)
    }
  }
}
