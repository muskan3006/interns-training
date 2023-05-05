package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem32 extends App {

 val logger = Logger(getClass)

 val gcd = new GCD
 logger.info("" +gcd.gcd(0,20))


}
 class GCD {

  @tailrec
   final def gcd(firstNumber :Int, secondNumber:Int) :Int = {
   if(secondNumber==0) firstNumber
   else
   gcd(secondNumber,firstNumber%secondNumber)
  }

}
