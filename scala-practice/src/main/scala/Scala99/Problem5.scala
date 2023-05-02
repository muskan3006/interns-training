package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem5 extends App {
  val logger = Logger(getClass)
  private val reverse = new Reverse
  println(reverse.reverseList(List(1, 2, 3, 4, 5), 5, List.empty))

}

class Reverse {
  @tailrec
  final def reverseList(list: List[Int], length: Int, accumulator: List[Int]): List[Int] = {
      list match {
        case Nil => accumulator
        case head :: tail => reverseList(tail, length - 1,head :: accumulator )
      }
    }
  }






