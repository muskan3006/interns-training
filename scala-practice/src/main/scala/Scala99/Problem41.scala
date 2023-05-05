package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem41 extends App {

  val logger = Logger(getClass)
  private val listOfGoldbach = new ListOfGoldbach
  logger.info("" + listOfGoldbach.getListOfGoldBach(9, 20))
}

class ListOfGoldbach {

  val goldBachConjecture = new GoldBachConjecture

  def getListOfGoldBach(start: Int, end: Int): List[(Int, Int)] = {
    @tailrec
    def getGoldBach(list: List[(Int, Int)], counter: Int): List[(Int, Int)] = {
      if (counter > end) list
      else {
        if (counter % 2 == 0) {
          val result = goldBachConjecture.getNumbers(counter)
          getGoldBach(list :+ result, counter + 1)
        } else
          getGoldBach(list, counter + 1)
      }
    }
    getGoldBach(List.empty, start)
  }
}
