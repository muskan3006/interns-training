package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem21 extends App {

  val logger = Logger(getClass)
  private val insertAtIndex = new InsertAtIndex
  val list = List('a', 'b', 'c', 'd')
  logger.info("" + insertAtIndex.insert('4', 2, list, List.empty, 0))
}

class InsertAtIndex {
  @tailrec
  final def insert [A](element : A, index :Int, list :List[A], resultList :List[A], counter :Int =0) :List[A] = {
   list match {
     case Nil => resultList
     case head :: Nil =>resultList :+ head
     case head :: tail => if( counter == index) insert(element,index, tail ,resultList:+ element :+ head,counter+1)
     else insert(element,index,tail,resultList:+head ,counter+1)
   }
  }
}
