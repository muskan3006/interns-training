package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem2 extends App {
  val list = List(2,3,4,5)
  private val logger = Logger(getClass)
  if (list.nonEmpty) logger.info("Last but one element: " + (lastOneElementOfList(list)))
  else logger.info("List is Empty")

  @tailrec
  private def lastOneElementOfList[T](list: List[T]): T = {
    list match {
      case head :: Nil => head
      case head :: List(_) => head
      case _ :: tail => lastOneElementOfList(tail)
    }
  }
}
