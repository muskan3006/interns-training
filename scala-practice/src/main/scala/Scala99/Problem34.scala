package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger
import scala.annotation.tailrec
import  Problem33.coPrime

object Problem34 extends App{
  val logger = Logger(getClass)
  logger.info("Euliers Totient Function : " + eulersToTient(315))

  def eulersToTient(number: Int): Double = {
    @tailrec
    def helper(counter: Int, checkNumber: Int, coPrimeCount: Int): Double ={
      if(counter > checkNumber) coPrimeCount
      else if(coPrime(counter,checkNumber)) helper(counter+1,number,coPrimeCount+1)
      else helper(counter+1,number,coPrimeCount)
    }
    helper(1,number,0)
  }
}
