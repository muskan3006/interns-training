package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem33 extends App {

  val logger = Logger (getClass)
  private val coPrime = new CoPrime
  print(coPrime.coPrime(4,6))

}

class CoPrime {
  val gcd= new GCD
  def coPrime(firstNumber:Int,secondNumber :Int) :Boolean ={
    if(gcd.gcd(firstNumber,secondNumber)==1)true
    else
      false
  }
}
