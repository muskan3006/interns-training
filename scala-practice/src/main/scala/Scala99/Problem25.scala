package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem25 extends  App{
  val logger =  Logger(getClass)
  private val randomPermutation = new RandomPermutation
  val list = List('a', 'b', 'c', 'd', 'e', 'f')
  logger.info("" +randomPermutation.generateRandomPermutation(list))
}

class RandomPermutation {
  /*  RandomNumber from  Problem 23
   it contains method extractRandom which gives the list of
   random number from a given list of defined size
   */
  val randomNumber = new RandomNumber
  def generateRandomPermutation [A](list :List[A]) : List[A]= {
    val length = list.length
    /*
    here we use the length of list to get the permutation
     */
    randomNumber.extractRandom(length,list)
  }
}