package com.knoldus
package Scala99

import com.knoldus.Scala99.Problem4.getLength
import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem6 extends App {

  val logger = Logger(getClass)
  private val palindrome = new Palindrome
  logger.info("" + palindrome.checkPalindrome(List(1, 2, 3, 2, 1)))
}

class Palindrome {
  def checkPalindrome(list: List[Int]): Boolean = {
    val length = getLength(0, list)
    val reversedList = reverseList(list, length, List.empty)
    reversedList == list
  }

  @tailrec
  final def reverseList(list: List[Int], length: Int, accumulator: List[Int]): List[Int] = {
    list match {
      case Nil => accumulator
      case head :: tail => reverseList(tail, length - 1, head :: accumulator)
    }
  }
}
