package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

object Problem12 extends App{
  val logger = Logger(getClass)
  def decodeRunLength[T](list: List[(Int,T)]): List[Any] = {
    if(list.isEmpty) list
    list.flatMap{e => List.fill(e._1)(e._2)
    }
  }
  logger.info("decode Run length :" + decodeRunLength(List((4,7),(2,3),(1,1))))

  def decode[A](list: List[(Int, A)]): List[A] = {
    def _expand(res: List[A], rem: (Int, A)): List[A] = rem match {
      case (0, _) => res
      case (number, head) => _expand(res ::: List(head), (number - 1, head))
    }
    list flatMap {element => _expand(List(), element) }
  }
  logger.info("decode :" + decode(List((4,1),(2,3),(3,4))))
}
