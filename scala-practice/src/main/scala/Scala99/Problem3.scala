package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem3 extends App {
  val logger = Logger(getClass)
  logger.info("find kth element : " + findkthElement(2, List(3, 5, 8, 7, 10)))

  @tailrec
  private def findkthElement[T](k: Int, list: List[T]): T = {
    k match {
      case 0 => list.head
      case k if k > 0 => findkthElement(k - 1, list.tail)
    }
  }
}
