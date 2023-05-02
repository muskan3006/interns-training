package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem11 extends App {
  val logger = Logger(getClass)
  logger.info("modified run length encoding : " + modifiedRunlengthCoding(List(1, 2, 2, 3, 4, 5, 5, 5, 6, 4)))
  logger.info("modified run length encoding : " + modifiedRunLength(List(1, 2, 2, 3, 4, 5, 5, 5, 6, 4)))

  def modifiedRunlengthCoding[T](list: List[T]): List[Any] = {
    list match {
      case Nil => Nil
      case head :: _ => val segment = list.takeWhile(_ == head)
        if (segment.length == 1) head :: modifiedRunlengthCoding(list.drop(segment.length))
        else (segment.length, head) :: modifiedRunlengthCoding(list.drop(segment.length))
    }
  }

  def modifiedRunLength[T](list: List[T]): List[Any] = {
    def helper[T](result: List[Any], remainingList: List[T]): List[Any] = {
      remainingList match {
        case Nil => result
        case head :: _ => val segment = remainingList.takeWhile(_ == head)
          if (segment.length == 1) helper(result :+ head, remainingList.drop(segment.length))
          else helper(result :+ (segment.length, head), remainingList.drop(segment.length))
      }
    }

    helper(Nil, list)
  }
}
