package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem9 extends App {
  val logger = Logger(getClass)
  logger.info("pack the consecutive elements : " + packer(List(1, 2, 2, 3, 5, 5, 2)))
  logger.info("pack the consecutive elements : " + packOfConsecutiveElements(List(1, 2, 2, 3, 5, 5, 2)))

  def packOfConsecutiveElements[T](list: List[T]): List[List[T]] = {
    list match {
      case Nil => Nil
      case head :: _ => val segment = list.takeWhile(_ == head)
        segment :: packOfConsecutiveElements(list.drop(segment.length))
    }
  }

  def packer[T](list: List[T]): List[List[T]] = {
    def helper(segmentList: List[List[T]], remainingList: List[T]): List[List[T]] = remainingList match {
      case Nil => segmentList
      case head :: tail => val segment: List[T] = remainingList.takeWhile(_ == head)
        helper(segmentList ::: List(segment), remainingList.drop(segment.length))
    }

    helper(Nil, list)
  }
}
