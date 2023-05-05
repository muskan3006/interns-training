package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem36  extends App{

  val logger = Logger(getClass)
  val primeFactorizations  = new PrimeFactorization2
  println(primeFactorizations.primeFactors(315))
}

class PrimeFactorization2{

  /*
  primeFactorizations give the List of Factor
   */
  val primeFactorizations = new PrimeFactorizations

  def primeFactors(number: Int): List[(Int,Int)] = {
    val result = primeFactorizations.primeFactors(number)

    runLength(result,List.empty)
}

  @tailrec
  final def runLength[A](list: List[A], resultList: List[(A, Int)]): List[(A, Int)] = {
    if (list.isEmpty) resultList
    else {
      val (head, tail) = list span (_ == list.head)
      val length = head.length
      runLength(tail, resultList :+ (list.head, length))
    }
  }
}
