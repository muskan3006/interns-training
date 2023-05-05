package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem40 extends App{
  import Problem39.listOfPrimeNumbers
  val logger = Logger(getClass)
  logger.info("goldBach :" +goldBach(10))

  def goldBach(number: Int): (Int,Int) = {
    @tailrec
    def helper(counter: Int, remainingList: List[Int]): (Int,Int) = {
      remainingList match{
        case Nil => (0,0)
        case head :: _ if(counter + head == number) => (counter,head)
        case _ :: tail => helper(counter, tail)
      }
    }
    def helperFirst(list: List[Int],checkNumber: Int): (Int, Int) = {
      list match {
        case Nil => (0,0)
        case head::Nil => helper(head, list)
        case head :: tail =>
          val res = helper(head, list)
          if(res._1 + res._2 == number) res
          else helperFirst(tail,checkNumber)

      }
    }
    if (number % 2 != 0) (-1, -1)
    else helperFirst(listOfPrimeNumbers(2, number), number)
  }
}
