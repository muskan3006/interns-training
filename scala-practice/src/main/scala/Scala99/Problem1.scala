package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem1 extends App {
  val logger = Logger(getClass)
  val list = List(1, 2, 3, 4, 5, 6, 7)
  val list2 =List.empty
  @tailrec
  private def lastElement(list:List[Int]) :Int = {
    list match {
      case Nil => Integer.MIN_VALUE
      case head ::Nil => head
      case _ :: tail => lastElement(tail)
    }
  }
  @tailrec
  private def secondLast(list:List[Int]) :Int = {
    list match {
      case Nil =>Integer.MIN_VALUE
      case head :: (_ ::Nil) =>head
      case _ :: tail =>secondLast(tail)
    }
  }

  logger.info("Last element -> " + lastElement(list))
  logger.info("Second last element-> " + secondLast(list))
}
