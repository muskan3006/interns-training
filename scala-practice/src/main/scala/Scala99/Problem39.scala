package com.knoldus
package Scala99

import Problem31.isPrime
import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem39 extends App {

  val logger = Logger(getClass)
  private val listOfPrimeNumbers = new ListOfPrimeNumbers
  logger.info("" + listOfPrimeNumbers.getListOfPrimeNumbers(2, 10))
}


class ListOfPrimeNumbers {

  def getListOfPrimeNumbers(start: Int, end: Int): List[Int] = {

    @tailrec
    def getList(list: List[Int], counter: Int): List[Int] = {

      if (counter == end) list
      else {
        if (isPrime(counter)) getList(list :+ counter, counter + 1)
        else
          getList(list, counter + 1)
      }
    }

    getList(List.empty, start)
  }
}