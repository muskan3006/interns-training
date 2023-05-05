package com.knoldus
package Scala99
import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec


/*
 Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with
a single copy of the element. The order of the elements should not be changed.
 compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */

object Problem8 extends App{

  val logger = Logger(getClass)
  val eleminateDuplicate= new EliminateDuplicate
  logger.info(""+ eleminateDuplicate
        .getCompressed(List('a', 'a', 'a', 'a', 'b','c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'),List.empty)
        .reverse)
}
class EliminateDuplicate {
 @tailrec
 final def getCompressed[A](list :List[A], result :List[A]) :List[A] = {
   list match {
     case Nil => result
     case head :: Nil => head +: result
     case head :: tail => if (head == tail.head) getCompressed(tail, result) else getCompressed(tail, head +: result)
   }
 }
}
