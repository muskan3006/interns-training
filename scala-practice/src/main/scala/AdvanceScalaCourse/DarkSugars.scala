package com.knoldus
package AdvanceScalaCourse

import com.typesafe.scalalogging.Logger

import scala.util.Try


object DarkSugars extends App{

  val logger = Logger(getClass)

  //  sytax sugar #1 methods with single param
  private def singleArgMthod(arg : Int):String = s"$arg"
  private val description  = singleArgMthod{
    43
  }
  logger.info("single argMethod => "+description)

  val aTryInstance = Try {
    throw  new RuntimeException
  }
  val listResult  =List(1,2,3,4).map{
    value =>
      value+1
  }
  logger.info("list result => "+listResult)

  //syntax sugar #2 single abstarct method
  trait  Action {
    def act(value :Int) :Int
  }
  val anInstance :Action =  new Action {
    override def act(value: Int): Int = value+1
  }
  val aFunkyInstance :Action = (value:Int) => value+1


  // Runnable
  val aThread  = new Thread ( new Runnable {
    override def run(): Unit = print("Hello sala")
  })

  val aSweeterThread = new Thread (() => print("Hello scala"))

  abstract class AnAbstractType {
    def implemented :Int = 32
    def f(value:Int ):Unit
  }

  val abAbstractInstance = (value:Int) => print("Sweet")

  //syntax sugar #3 : the :: ans  #: methods are special
  val prepended = 2 :: List(3,4)
  //2.::(List(3,4))
  // List(3,4).:;(2)
  //?!
  // scala spec last char decide associativity of method
  val result = 1::2::3::List(4,5)
  val result2 =List(4,5).::(3).::(2).::(1)
  class MyStream [T] {
    def -->:(value:T) :MyStream[T]=this
  }
  private val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]
  logger.info("myStream =>"+myStream)

  //syntax sugar #4 multi word -word naming
  private class TeenGirl(name :String) {
    def `and then said`(gossip :String): Unit = print(s"$name said $gossip")
  }

  private val teenGirl = new TeenGirl("siri")
  logger.info("and then said => "+ teenGirl.`and then said`("alexa is so funny "))
  private val lilly = new TeenGirl("Lilly")
  lilly `and then said` "scala is sweet"

  private val `a multi word naming ` = 34
  logger.info("a multi word name => " +`a multi word naming `)

  //syntax sugar #5 infix types

  class Composite [A,B]
  val composite  :Composite[Int ,String] = ???
  class  --> [A,b]
  val toward :Int --> String = ???


  //syntax sugar #6 update () is very useful much like apply ()
  private val array = Array(1,2,3)
  array(2) =7 // rewritten to array.update(2,7)
  // update is very used in mutable collections
  // remember apply and update


  // syntax sugar #7 setters for mutable containers

  private class Mutable {
    private var internalMember  :Int = 0// private  for oop
    def member  :Int  = internalMember // getter
    def member_= (value :Int ) : Unit = internalMember = value //setter
    }

  private val aMutable = new Mutable
  aMutable .member = 42

}
