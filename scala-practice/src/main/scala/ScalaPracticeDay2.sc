import com.typesafe.scalalogging.Logger

val logger = Logger(getClass)
def sum(num1: Int, num2: Int, num3: Int): Int = {
  num1 + num2 + num3
}
val partialSum = sum(1, _, 3)
val result = partialSum(2)
logger.info("sum of the numbers using partially applied function:"+result)

val more = 3
val addMore = (x: Int) => x + more
logger.info("sum :"+addMore(10))

def makeIncreaser(more: Int): Int => Int = (x: Int) => more + x
val inc = makeIncreaser(4)
logger.info("make Increase the number :"+inc(3))

val list = List("shrasti")
def myFunction(times: Int, strings: String*): String = {
  strings.mkString(" ") * 3
}
logger.info(("multiple:" +myFunction(3, list:_*)))

def additionOfThreeNumbers(num1: Int)(num2: Int)(num3: Int): Int = num1 + num2 + num3
val addTwoNumbers = additionOfThreeNumbers(2)(4)(_)
val finalResult = addTwoNumbers(7)
logger.info("addition of numbers:"+ finalResult)

abstract class Element{
  def demo() = {
    logger.info(s"element implementation invoked")
  }
}
class ArrayElement extends Element{
  override def demo() = {
    logger.info(s"Arrayelement invoked")
  }
}
class UnaryElement extends Element{
  def invokeDemo(element: Element): Unit = {
    logger.info("element demo"+element.demo())
  }
}
val unaryElement = new UnaryElement
logger.info("unary element implementation :"+unaryElement.invokeDemo(new ArrayElement))
logger.info("unary element implementation :"+unaryElement.invokeDemo(new UnaryElement))

def isEqual(num1: Int, num2: Any): Boolean = {
  num1 == num2
}
logger.info("equality check :"+isEqual(2,2))

val findSubstring = "Shrasti Gupta"
logger.info("find the substring of the string :"+findSubstring.substring(3))
logger.info("find the substring of the string :"+findSubstring.substring(3,6))


class Person(val name: String, val age: Int) extends Ordered[Person] {
  def compare(that: Person): Int = {
    if (this.name == that.name) this.age - that.age
    else this.name.compareTo(that.name)
  }
}
val p1 = new Person("John", 25)
val p2 = new Person("Alice", 30)
val p3 = new Person("Alice", 25)
println(p1 < p2)
println(p1 > p3)
println(p2 <= p3)
