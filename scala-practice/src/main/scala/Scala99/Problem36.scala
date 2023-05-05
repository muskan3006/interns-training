package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem36 extends App {
  val logger = Logger(getClass)
  logger.info("Prime factor multiplicity :" + primeFactorMultiplicity(315))

   def primeFactorMultiplicity(number: Int): List[(Int, Int)] = {
    @tailrec
    def helper(counter: Int, checkNumber: Int, resultList: List[Int]): List[(Int,Int)] = {
      if (counter > number) runLength(resultList.reverse)
      else if (checkNumber % counter == 0) {
        val lcm = checkNumber / counter
        helper(counter, lcm, counter :: resultList)
      }
      else helper(counter + 1, checkNumber, resultList)
    }
    helper(2,number,Nil)
  }

  def runLength(list: List[Int]): List[(Int, Int)] = {
    @tailrec
    def helper(segmentList: List[(Int, Int)], remainingList: List[Int]): List[(Int, Int)] = {
      remainingList match {
        case Nil => segmentList
        case head :: _ => val segment = remainingList.takeWhile(_ == head)
          helper(segmentList :+ (head, segment.length), remainingList.drop(segment.length))
      }
    }
    helper(Nil, list)
  }
}
