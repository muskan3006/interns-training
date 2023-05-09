package com.knoldus
package AdvanceScalaCourse

import com.typesafe.scalalogging.Logger

object LazyEvaluation extends App {

  val logger = Logger(getClass)
  lazy val exception :Int  = throw new RuntimeException


  lazy val value :Int = {
    println("Hello")
    45
  }
  logger.info(""+ value)

  // in conjuction with call by name

  def byNameMethod(number: => Int) : Int = number + number +number+1
  def retriveMagicValue  ={
    Thread.sleep(1000)
    45
  }
  logger.info(""+ retriveMagicValue)

}
