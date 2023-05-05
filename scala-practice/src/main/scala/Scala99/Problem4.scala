package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem4 extends App
{
  val logger: Logger = Logger(getClass)
  val list: List[Int] = List(1,2,3,4,5,6,6,7,8)
  logger.info(""+ getLength(0,list))

  @tailrec
  def getLength(length :Int, list :List[Int]): Int = {
    list match {
      case Nil => length
      case  _ :: tail =>  getLength(length+1,tail)
    }

  }

}


