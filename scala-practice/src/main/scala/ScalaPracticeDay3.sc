import com.typesafe.scalalogging.Logger
import scala.util.{Try, Success, Failure}

val logger = Logger(getClass)

def describePerson(person: (String, Int)): String = {
  person match {
    case personAge if personAge._2 < 18 => "underage"
    case personAge if personAge._2 < 65 => "adult"
    case _ => "senior"
  }
}
logger.info("Person's age nature :" + describePerson("shrasti", 21))

def evenOrOdd(number: Int): String = {
  number match {
    case matchNumber if matchNumber % 2 == 0 => s"$matchNumber is even"
    case matchNumber if matchNumber % 2 != 0 => s"$matchNumber is odd"
  }
}
logger.info("Find even or odd the number :" + evenOrOdd(3))
logger.info("Find even or odd the number :" + evenOrOdd(-2))

def flattenListusingFlatMap(inputList: List[List[Int]]): List[Int] = {
  inputList.flatten
}
logger.info("flatten the list using flatten : " + flattenListusingFlatMap(List(List(5, 6), List(2, 3))))

def flattenListUsingPatternMatching(inputList: List[Any]): List[Int] = {
  inputList match {
    case Nil => Nil
    case (head: Int) :: tail => head :: flattenListUsingPatternMatching(tail)
    case (head: List[_]) :: tail => flattenListUsingPatternMatching(head) ::: flattenListUsingPatternMatching(tail)
    case _ => List(0)
  }
}
logger.info("flatten the list using pattern matching :" + flattenListUsingPatternMatching(List(List(2, 3), 4, 5, List(7, 8))))

val fruits = List("apple", "apple", "orange", "pear", "pear", "pear")
logger.info("group by method : " + fruits.groupBy(identity))

sealed abstract class Experiment

case class Var(name: String) extends Experiment

case class Number(inputNumber: Int) extends Experiment

case class Addition(inputNumber1: Int, inputNumber2: Int) extends Experiment

def describe(expression: Experiment): String = expression match {
  case Var(_) => "This is var"
  case Number(_) => " This is a number"
  case Addition(matchNumber1, matchNumber2) => s"Sum of two numbers : ${matchNumber1 + matchNumber2}"
  case _ => "Invalid"
}
val number = Number(4)
logger.info("describe" + describe(number))

val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
logger.info("map :" + capitals("France"))

val negativeToPositive: PartialFunction[Int, Int] = {
  case number if number <= 0 => Math.abs(number)
}

val zeroToPositive: PartialFunction[Int, Int] = {
  case number if number <= 0 => Math.abs(number)
}

val PositiveToNegative: PartialFunction[Int, Int] = {
  case number if number >= 0 => -1 * number
}

val integrate: PartialFunction[Int, Int] = {
  negativeToPositive orElse PositiveToNegative orElse zeroToPositive
}
logger.info("partial function:" + integrate(-4))
logger.info("partial function:" + integrate(-0))
logger.info("partial function:" + integrate(5))

def addList(myList: List[Int]): Try[Int] = Try {
  myList match {
    case Nil => throw new IllegalArgumentException
    case _ :: Nil => myList.head
    case _ :: _ => myList.sum
  }
}
val addListResult = addList(List(2, 3, 4, 5))
addListResult match {
  case Success(result) => logger.info("result of list :" + result)
  case Failure(exception) => logger.info("Error :" + exception)
}
val addEmptyListResult = addList(List())
addEmptyListResult match {
  case Success(result) => logger.info("result of list :" + result)
  case Failure(exception) => logger.info("Error" + exception)
}
