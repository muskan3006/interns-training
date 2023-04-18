package com.knoldus
import com.typesafe.scalalogging.Logger
import scala.collection.mutable.Map

val logger = Logger(getClass)

var map = Map[Int , String](1 -> "shrasti", 2 -> "gauri")
// companion object
object MapChecker{
  private def existOrNot(checkThatValue: Int): Boolean = {
    if(map.contains(checkThatValue)) true
    else false
  }
}
class MapChecker{
  def modifyThemap(mapValue: (Int, String)): Map[Int, String] = {
    map += mapValue
    map
  }
  val check = MapChecker.existOrNot(1)
  logger.info("check the value :"+ check)
}
val checkInTheMap = new MapChecker
logger.info("modify the value in the map: "+checkInTheMap.modifyThemap(3 -> "reetesh"))

