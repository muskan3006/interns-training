package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem1 extends App {
  val logger = Logger(getClass)
  logger.info("last element : " + lastElementOfList(List(2, 3, 4, 5, 6)))

  @tailrec
  private def lastElementOfList[T](list: List[T]): T = {
    list match {
      case Nil => throw new NoSuchElementException("list is empty")
      case head :: Nil => head
      case _ :: _ => lastElementOfList(list.tail)
    }
  }
}
