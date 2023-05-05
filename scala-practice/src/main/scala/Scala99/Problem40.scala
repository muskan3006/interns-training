package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem40 extends App {

  val logger = Logger(getClass)
  private val goldBachConjecture = new GoldBachConjecture
  logger.info(""+goldBachConjecture.getNumbers(28))
}

class GoldBachConjecture {
  val listOfPrimeNumbers = new ListOfPrimeNumbers
  def getNumbers(number: Int): (Int, Int) = {
    val list = listOfPrimeNumbers.getListOfPrimeNumbers(2, number)
    @tailrec
    def getTuples(list: List[Int], resultTuple: (Int, Int)): (Int, Int) = {
      list match {
        case Nil => (0, 0)
        case _ :: Nil => resultTuple
        case head :: tail =>
          val result = helperFunction(head, tail)
          if (result._1 + result._2 == number) (result._1, result._2)
          else
            getTuples(tail, resultTuple)
      }
    }

    @tailrec
    def helperFunction(firstElement: Int, list: List[Int]): (Int, Int) = {

      list match {
        case Nil => (0, 0)
        case head :: tail => if (head + firstElement == number) (firstElement, head)
        else
          helperFunction(firstElement, tail)
      }
    }
    getTuples(list, (0, 0))
  }
}


