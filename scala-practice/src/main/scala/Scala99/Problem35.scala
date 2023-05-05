package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec

object Problem35 extends App{
  val logger = Logger(getClass)
  logger.info("prime factors :" + primeFactors(315))

  private def primeFactors(number: Int): List[Int] = {
    @tailrec
    def helper(counter: Int, checkNumber: Int, resultList: List[Int]): List[Int] = {
      if(counter > number) resultList.reverse
      else if(checkNumber % counter == 0){
        val lcm = checkNumber / counter
        helper(counter, lcm, counter::resultList)
      }
      else helper(counter + 1, checkNumber, resultList)
    }
    helper(2,number,Nil)
  }
}
