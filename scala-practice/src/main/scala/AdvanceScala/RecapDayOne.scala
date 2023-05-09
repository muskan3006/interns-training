package com.knoldus
package AdvanceScala
import com.typesafe.scalalogging.Logger

object RecapDayOne extends App {
  val logger = Logger(getClass)
  val myList = Cons(1, Cons(2, Cons(3, Empty)))
  private val decomposed = myList match {
    case MyList(1, 2, _*) => "starting with 1 and 2"
    case _ => "Something different"
  }
  logger.info("code block : " + aCodeBlock)
  private val aCondition: Boolean = true
  private val aCodeBlock = {
    if (aCondition) "right"
    "wrong"
  }
  myObject.eat()
  private val myObject = new Animal {
    def eat(): Unit = logger.info("crunch crunch")
  }
  private val description = singleArgMethod {
    56
  }
  logger.info(singleArgMethod(12))
  logger.info(description)

  private val aThread = new Thread {
    override def run(): Unit = logger.info("One thread has made")
  }
  private val aResultThread = new Thread(() => logger.info("Hello , Scala"))

  aResultThread.start()
  aThread.start()

  private val evenNumbers: Stream[Int] = 2 #:: evenNumbers.map(_ + 3)
  logger.info("" + evenNumbers(6))
  private val john = new Person("John", 22)

  logger.info("addition :" + `add of two numbers`(2, 4))
  private val greet = john match {
    case Person(name, age) => s"my name is $name and age is $age "
  }
  private val ageStatus = john.age match {
    case age if age > 18 => "adult"
    case age if age < 18 => "child"
  }
  logger.info(greet)
  private val compose: String Compose Int = Compose("thrash ", 21)
  logger.info(ageStatus)

  private def singleArgMethod(arg: Int): String = s" this is the number $arg"

  private def `add of two numbers`(number1: Int, number2: Int): Int = {
    number1 + number2
  }
  logger.info("compose : " + compose)

  trait Animal {
    def eat()
  }

  abstract class MyList[+A] {
    def head: A = ???

    def tail: MyList[A] = ???
  }

  class Person(val name: String, val age: Int)

  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  private case class Compose[A, B](name: String, age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] = Some(person.name, person.age)
  }

  private object MyList {
    def unapplySeq[A](list: MyList[A]): Option[Seq[A]] = {
      if (list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
    }
  }

  private case object Empty extends MyList[Nothing]
  logger.info(decomposed)
}