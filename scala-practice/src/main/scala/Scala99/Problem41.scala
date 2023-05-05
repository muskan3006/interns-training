package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem41 extends App{
  import Problem40.goldBach
  val logger = Logger(getClass)
  logger.info("list of Gold bach : " +listOfGoldbach(9,20))

  def listOfGoldbach(start: Int, end: Int): List[(Int, Int)] = {
    def helper(counter: Int, result: List[(Int, Int)]): List[(Int, Int)] = {
      counter match{
        case count if count > end => result.reverse
        case count if count % 2 !=0 => helper(count + 1, result)
        case count  if(count % 2 ==0) =>
          val series = goldBach(count)
          helper(count + 1, series::result)

      }
    }
    helper(start, Nil)
  }
}
