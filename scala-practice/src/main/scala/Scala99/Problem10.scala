package com.knoldus
package Scala99

import scala.annotation.tailrec

object Problem10 extends App{
  println(runLength(List(1,2,2,3,5,5,2)))
  println(runLengthEncoding(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')))
  println(List())
  private def runLengthEncoding[T](list: List[T]): List[(Int, T)] = {
    list match {
      case Nil => Nil
      case head :: tail => val segment = list.takeWhile(_ == head)
        (segment.length,head) :: runLengthEncoding(list.drop(segment.length))
    }
  }

  def runLength[T](list: List[T]): List[(Int, T)] = {
    @tailrec
    def helper(segmentList: List[(Int, T)], remainingList: List[T]) : List[(Int, T)] = {
      remainingList match {
        case Nil => segmentList
        case head :: _ => val segment = remainingList.takeWhile(_ == head)
        helper(segmentList :+ (segment.length,head), remainingList.drop(segment.length))
      }
    }
    helper(Nil,list)
  }
}
