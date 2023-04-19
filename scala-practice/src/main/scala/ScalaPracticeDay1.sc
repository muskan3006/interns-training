import com.typesafe.scalalogging.Logger

import scala.collection.mutable.Map

val logger = Logger(getClass)
val groceries = ("pulses", "curd", "milk", 1)
logger.info(groceries._1)
logger.info(groceries._4.toString + groceries._1)

def sumAndProduct(number1: Int, number2: Int): (Int,Int) = {
  val result = (number1+number2, number1*number2)
  logger.info("Sum and Product :" + result)
  result
}
sumAndProduct(2,3)

def swapValues(pair: (Int, String)): (String, Int) = {
  pair match{
    case (a, b) => (b, a)
  }
}
logger.info("swap of the values:"+swapValues(21, "Gauri"))

def capitalizedAndDoubled(list: List[(String, Int)]): List[(String, Int)] = {
  list.map{
    case (s, i) => (s.capitalize, i*2)
  }
}
logger.info("Capitalize and Doubled: "+ capitalizedAndDoubled(List(("Mercury", 5), ("Venus", 1), ("Earth", 1), ("Mars", 2), ("Jupiter", 7))))

def optionToTuple(tuple: (Option[Int], Option[String])): (Int, String) = {
  tuple match{
    case (Some(num), Some(str)) => (num, str)
    case (Some(num), None) => (0,"")
    case (None, Some(str)) => (0,"")
    case (None, None) => (0,"")
  }
}
logger.info("Convert tuple of option :"+ optionToTuple(Some(2), Some("gauri")))
logger.info("Convert tuple of option :"+ optionToTuple(None, None))

class Incrementor{
  var multiply = 2
  def doubler(value: Int): Int = {
    multiply = multiply * value     //reassign the value
    multiply
  }
}
val incrementor = new Incrementor
logger.info("double the value :"+incrementor.doubler(4))

var map = Map[Int, String](1 -> "shrasti", 2 -> "gauri")

// companion object
object MapChecker {
  private def existOrNot(checkThatValue: Int): Boolean = {
    if (map.contains(checkThatValue)) true
    else false
  }
}

class MapChecker {
  def modifyThemap(mapValue: (Int, String)): Map[Int, String] = {
    map += mapValue
    map
  }

  val check = MapChecker.existOrNot(1)
  logger.info("check the value :" + check)
}

val checkInTheMap = new MapChecker
logger.info("modify the value in the map: " + checkInTheMap.modifyThemap(3 -> "reetesh"))






