package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem19 extends App{
  val logger = Logger(getClass)
  logger.info("rotate : " + rotateUsingRecursion(-2,List(5,2,8,3,9,1)))

  @tailrec
  private def rotateUsingRecursion[T](num: Int, list: List[T]): List[T] = list match {
    case ::(head, tail) if (num != 0 && num > 0) => rotateUsingRecursion(num - 1, tail :+ head)
    case ::(head, tail) if (num != 0 && num < 0) => rotateUsingRecursion(num + 1, tail.last :: head :: tail.init)
    case _ => list
  }
}
