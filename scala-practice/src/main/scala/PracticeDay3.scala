
package com.knoldus
import com.typesafe.scalalogging.Logger
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class FuturePractice {
  def sumListElement(list: List[Int]): Future[Int] = {
    Future {
      val result: Int = list.sum
      result
    }
  }
}

object PracticeDay3 extends App {
  val logger = Logger(getClass)

  private val futurePractice = new FuturePractice

  private val numFuture = Future {
    3
  }
  numFuture.map(number => Future(number.toString))
    .flatten
    .map(result => logger.info("Result = " + result))
  futurePractice.sumListElement(List(3, 5, 2, 1))
    .map(result => logger.info("Result = " + result))

  //closure
  private def multiplyBy(value: Int) = value * freeValue
  private val freeValue = 2
  logger.info("After Multiply "+multiplyBy(2))
}
