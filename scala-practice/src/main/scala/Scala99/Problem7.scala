package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

object Problem7 extends App{
  val logger = Logger(getClass)
  private val nestedListStructure = new NestedListStructure
  print(nestedListStructure.flattenList(List(List(1, 1), 2, List(3, List(5, 8)))))
}

class NestedListStructure {
  def flattenList (list :List[Any]) :List[Any] = {
    list flatMap{
      case value :List[_] => flattenList(value)
      case value => List(value)
    }
  }
}
