package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem7 extends App {
  val logger = Logger(getClass)
  logger.info("flatten nested list : " + flattenNestedList(List(List(2, 3), 2, List(4, 5), List(6, 7))))

  private def flattenNestedList(list: List[Any]): List[Any] = {
    list match {
      case Nil => Nil
      case (head: List[_]) :: tail => flattenNestedList(head) ::: flattenNestedList(tail)
      case head :: tail => head :: flattenNestedList(tail)
    }
  }

  private def flattenList(list: List[Any]): List[Any] = {
    list flatMap {
      case matchList: List[_] => flattenList(matchList)
      case value => List(value)
    }
  }
}
