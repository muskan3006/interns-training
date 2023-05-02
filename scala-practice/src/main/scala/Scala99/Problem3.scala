package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem3 extends App {
  val logger = Logger(getClass)
  private val kthElement = new KthElement
  logger.info("" + kthElement.kthElement(3,0, List(2, 3, 4, 5, 6, 7, 8)))
}
class KthElement {
  @tailrec
  final def kthElement(nth: Int, counter :Int, list: List[Int]): Int = {
    list match {
      case Nil => Integer.MIN_VALUE
      case head :: _ if(counter ==3)=> head
      case _ :: tail =>kthElement(nth,counter +1,tail)
    }
  }
}
