
import com.typesafe.scalalogging.Logger


// Here name and age can be work as field in the class
class Person(val name: String, val age: Int)

// here name and age cannot work as field
class Person2(name: String, age: Int)


//companion object
object Human {
  def apply(): Human = new Human

}

//class Human whose companion object created
class Human {
  def canFly: Boolean = {
    false
  }
  def canWalk: Boolean = {
    true
  }
}

//sealed implementation
sealed class PrintHello {
  def printMethod:String = "Hello world"
}

class PrintMessage extends PrintHello {
  override def printMethod: String = super.printMethod
}

class HaveAnyValue (val value :Int) {
 println(value)
}

//abstract class Animal (value :Int){
//  def walk :Boolean
//  def eat :Boolean
//}
//
//trait Animal2 {
//  def walk :Boolean = {
//    true
//  }
//}



object PracticeDay1 extends App {
  private val logger = Logger(getClass)

  private val instanceOfPerson = new Person("sheshnath", 23)
  logger.info("Age= "+instanceOfPerson.age)
  logger.info("Name= "+instanceOfPerson.name)

  private val classHumanHaveInstance = Human()
  logger.info("CanFly ="+classHumanHaveInstance.canFly)
  logger.info("CanWalk ="+classHumanHaveInstance.canWalk)

  private val instanceOfPrintMessage = new PrintMessage
  logger.info("Print message "+instanceOfPrintMessage.printMethod)

  private val instanceOfHaveAnyValue = new HaveAnyValue(4)
  logger.info("Value=" + instanceOfHaveAnyValue.value)

}
