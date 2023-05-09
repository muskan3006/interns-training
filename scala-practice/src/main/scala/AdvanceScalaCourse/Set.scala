package com.knoldus
package AdvanceScalaCourse

import scala.annotation.tailrec


trait MySet[A] extends (A => Boolean) {

  def apply(element: A): Boolean =
    contains(element)

  def contains(element: A): Boolean

  def +(element: A): MySet[A]

  def ++(anotherSet: MySet[A]): MySet[A]

  def map[B](f: A => B): MySet[B]

  def flatMap[B](f: A => MySet[B]): MySet[B]

  def filter(predicate: A => Boolean): MySet[A]

  def foreach(f: A => Unit): Unit
  /*

    Exercise
  ->removing an element
  -> intersection with another set
  -> difference with another
   */

  def -(element :A) :MySet[A]
  def --(anotherSet :MySet[A]):MySet[A]
  def &(anotherSet :MySet[A]) :MySet[A]

  //exercise  -> implement uniray _! = >negation of a set
  //set
  def unary_! :MySet[A]

}



class EmptySet[A] extends MySet[A] {

  def contains(element: A): Boolean = false

  def +(element: A): MySet[A] = new NonEmptySet[A](element, this)

  def ++(anotherSet: MySet[A]): MySet[A] = anotherSet

  def map[B](f: A => B): MySet[B] = new EmptySet[B]

  def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]

  def filter(predicate: A => Boolean): MySet[A] = this

  def foreach(f: A => Unit): Unit = ()

  //part 2
  def -(element: A): MySet[A]=this

  def --(anotherSet: MySet[A]): MySet[A] = this

  def &(anotherSet: MySet[A]): MySet[A] = this

  def unary_! :MySet[A] =new PropertyBasedSet[A](_ => true )

}

class PropertyBasedSet[A](property: A => Boolean) extends MySet[A] {
  def contains(element: A): Boolean = property(element)

  override def +(element: A): MySet[A] =
    new PropertyBasedSet[A](value => property(value) || value == element)

  override def ++(anotherSet: MySet[A]): MySet[A] =
    new PropertyBasedSet[A](value => property(value) || anotherSet(value))

  override def map[B](f: A => B): MySet[B] = politelyFail

  def politelyFail = throw new IllegalArgumentException("Illegeal argurment")

  override def flatMap[B](f: A => MySet[B]): MySet[B] = politelyFail

  override def foreach(f: A => Unit): Unit = politelyFail

  override def -(element: A): MySet[A] = filter(value => value != element)

  override def --(anotherSet: MySet[A]): MySet[A] = filter(!anotherSet)

  override def filter(predicate: A => Boolean): MySet[A] = new PropertyBasedSet[A](value => property(value) && predicate(value))

  override def &(anotherSet: MySet[A]): MySet[A] = filter(anotherSet)

  override def unary_! : MySet[A] = new PropertyBasedSet[A](value => !property(value))
}

class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A] {

  def +(element: A): MySet[A] = {
    if (this contains element) this
    else new NonEmptySet[A](element, this)
  }

  def contains(element: A): Boolean =
    element == head || tail.contains(element)

  def ++(anotherSet: MySet[A]): MySet[A] = {
    tail ++ anotherSet + head
  }

  def map[B](f: A => B): MySet[B] = (tail map f) + f(head)

  def flatMap[B](f: A => MySet[B]): MySet[B] = (tail flatMap f) ++ f(head)

  def filter(predicate: A => Boolean): MySet[A] = {
    val filteredTail = tail filter predicate
    if (predicate(head)) filteredTail + head
    else filteredTail
  }

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }

  //part 2

  def -(element: A): MySet[A] =
    if(head==element)tail
    else tail -element +head

  def --(anotherSet: MySet[A]): MySet[A]= filter(!anotherSet)

  def &(anotherSet: MySet[A]): MySet[A] = filter (anotherSet)

  def unary_! :MySet[A] = new PropertyBasedSet[A](value  => !this.contains(value))

}

object MySet {
  def apply[A](values: A*): MySet[A] = {
    @tailrec
    def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] = {
      if (valSeq.isEmpty) acc
      else buildSet(valSeq.tail, acc + valSeq.head)
    }
    buildSet(values.toSeq, new EmptySet[A])
  }
}

object Set extends App {
  val s = MySet(1, 2, 3, 4, 5)
 // MySet(6, 7, 8) ++ s + 5 map (value => value * 2) filter (_ % 2 == 0) foreach println
  val negative = !s
  //println(negative(2))
  //println(negative(5))
  val negativeEven = negative.filter(_%2==0)
  //println(negativeEven(5))

  val negativeEven5 = negativeEven+5
  //println(negativeEven5(5))
  val result  = s.+(2)
  result map(f=>f) foreach println
}

