package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem39 extends App{
  import Problem31.isPrime

  val logger = Logger(getClass)
  logger.info("list of prime numbers in given range :" + listOfPrimeNumbers(3,12))

  def listOfPrimeNumbers(start: Int, end: Int): List[Int] = {
    @tailrec
    def helper(counter: Int, resultList: List[Int]): List[Int] = {
      counter match {
        case count if count > end => resultList.reverse
        case _ if isPrime(counter) => helper(counter + 1, counter::resultList)
        case _ => helper(counter + 1, resultList)
      }
    }
    helper(start,Nil)
  }
}
