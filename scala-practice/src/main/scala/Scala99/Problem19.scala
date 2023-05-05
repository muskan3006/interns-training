package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem19 extends App {

  val logger = Logger(getClass)
  val rotateNPlaces = new RotateNPlaces
  val list = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
  logger.info("" + rotateNPlaces.rotate(-2, list, List.empty, 0))

}

/*
rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

 */
class RotateNPlaces {
  @tailrec
  final def rotate[A](place: Int, list: List[A], resultList: List[A], counter: Int): List[A] = {
    list match {
      case Nil => resultList
      case _ :: Nil => resultList
      case head :: tail if (counter < place) => rotate(place, tail, resultList :+ head, counter + 1)
      case head :: tail if (counter == place) => rotate(place, tail, head +: tail ++: resultList, counter + 1)
      case _ :: _ if (place <= counter) => list.splitAt(list.length + place)._2 ::: list.splitAt(list.length + place)._1
      case _ :: tail => rotate(place, tail, resultList, counter + 1)
    }
  }
}