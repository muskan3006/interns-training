package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem6 extends App {
  val logger = Logger(getClass)
  logger.info("check palindrome : " + IsPalindromeList(List(2, 3, 4, 5, 6), List(6, 5, 4, 3, 2)))

  private def IsPalindromeList[T](list1: List[T], list2: List[T]): Boolean = {
    val reversedList = list1.reverse
    if (list2 == reversedList) true
    else false
  }
}
