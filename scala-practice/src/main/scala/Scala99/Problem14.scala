package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem14  extends App{
  val logger = Logger(getClass)
  val list = List('a', 'b', 'c', 'c', 'd')
  private val duplicateTheElement = new DuplicateTheElement
  logger.info( "" +duplicateTheElement.duplicate(list,List.empty))
}

class DuplicateTheElement {
  @tailrec
  final def duplicate [A](list :List[A], resultList :List[A]) : List[A] = {
    list match  {
      case Nil => resultList
      case head ::Nil => resultList ++doubler(head)
      case head :: tail => duplicate( tail ,resultList ++ doubler(head) )
    }
  }
 def doubler[A](element :A) :List[A] = {
    val list = List(element) :+element
    list
  }
}