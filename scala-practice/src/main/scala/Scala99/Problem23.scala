package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec
import scala.util.Random

object Problem23 extends App {
  val logger = Logger(getClass)
  val list = List(1, 2, 3, 4, 45,23,4,5,6,7,8)
  private val randomNumber = new RandomNumber
  logger.info("" + randomNumber.extractRandom(list.length, list))

}

class RandomNumber {

  private val random = new Random

  def extractRandom[A](number: Int, list: List[A]): List[A] = {
    @tailrec
    def getRandom(resultList: List[A], counter: Int, list2: List[A]): List[A] = {
      list2 match {
        case Nil => resultList
        case _ :: Nil  => resultList:+ list(random.nextInt(list.length))
        case _ :: tail => if (counter < number) getRandom(resultList :+ list(random.nextInt(list.length)), counter + 1, tail)
        else getRandom(resultList, counter, tail)
        case  head :: tail  if(counter==number) =>getRandom(resultList:+list(random.nextInt(list.length)),counter+1,tail)
      }
    }
    getRandom(List.empty, 1, list)
  }
}