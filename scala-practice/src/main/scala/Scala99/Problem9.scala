package com.knoldus
package Scala99

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object Problem9 extends App{

  val logger = Logger(getClass)
  val consecuticeDuplicate = new ConsecutiveDuplicate
  logger.info(""+consecuticeDuplicate.packConsecutive(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'),List.empty))
}
/*
P09 (**) Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

class ConsecutiveDuplicate {
  val listOfListsElementwise: Seq[Nothing] = List.empty
   def packConsecutive[A](list: List[A] ,listOfListsElementwise: List[List[A]]): List[List[A]] = {

     if(list.isEmpty) listOfListsElementwise
     else {
       val (head, tail) = list span {
         _ == list.head
       }
       if (tail == Nil) List(head)
       else head :: packConsecutive(tail,listOfListsElementwise)
     }
    }

}
