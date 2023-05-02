package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem16  extends App {

  val logger = Logger(getClass)
  val list =  List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
  private val dropEveryNthElement= new DropEveryNthElement
  logger.info(""+dropEveryNthElement.dropNth(3,list,List.empty,list.length))
}

/*
Drop every NNth element from a list.
drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */
class DropEveryNthElement {
  def dropNth [A](nth :Int ,list :List[A], resultList:List[A] ,length :Int) :List[A] = {
    list match {
      case Nil => resultList
      case head :: Nil => resultList :+ head
      case head :: tail => if (length % nth == 0) dropNth(nth, tail, resultList, length - 1)
      else dropNth(nth, tail, resultList :+ head, length - 1)
    }
  }
}