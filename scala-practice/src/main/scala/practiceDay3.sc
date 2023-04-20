
def perfectValue(value: Any) = {
  value match {
    case value: String => s"perfect value is $value"
    case value: Int => s"perfect value is $value "
    case _ => s"Not perfect value"
  }
}
println(perfectValue(34))


//Collections practice

// find last element from list
val list = List(1, 4, 2, 3, 5, 6, 7)
list.reverse.head

//Find the last but one element of a list.
list.reverse(1)

def nthElement(nth: Int, list: List[Int]): List[Int] = {
  list.filter((f => f == nth))
}
nthElement(2, List(1, 2, 3, 4, 5))

//Find the number of elements of a list
list.length

//reverse a list
list.reverse

//Find out whether a list is a palindrome.
def palindromeList(list: List[Int]): Boolean = {
  val reversedList = list.reverse
  if (list == reversedList) true else false
}
val list2 = List(1, 2, 1)
palindromeList(list2)

//Flatten a nested list structure.
val nested = (List(List(1, 1), List(2), List(3, List(5, 8))))
def nestedList(list: List[Any]): List[Any] = list flatMap {
  case value: List[_] => nestedList(value)
  case e => List(e)
}
nestedList(nested)


//Seq
val aSequence = Seq(1, 2, 3, 4, 5, 6)
aSequence(2)
aSequence.reverse
aSequence ++ Seq(12)
aSequence.sorted

//List
val aList = List(1, 2, 3, 4, 5)
val prepend = 42 +: aList :+ 45
prepend.mkString("-|-")
val aListPlusList = aList :+ list
aListPlusList
aList :+ list
aList :: list
aList ::: list
aList ++ list
aList +: list

//Array

val number = Array(1, 2, 3, 4)
val twoDimensionalArray = Array.ofDim[Int](2)

//Tuples

val tuple1 = (1, 2, 3, 4, 5)
tuple1._1
tuple1.copy(_2 = "Hello world")

//Map
val map = Map(1 -> "Sheshnath", 2 -> "Rohan", 3 -> "Shivam")
map.keys
map.values
map.map {
  case (key -> value) => key -> value
  case _ => "Value not found"
}
map.filter((key => key._1 > 1))


//extract data from list of options
val listOfOptions = List(Some(2), None, Some(3))
listOfOptions.flatten
val listOfListOfOption = List(List(Some(2), None, Some(5)))
listOfListOfOption.flatMap(f => f.flatten)



//pattern Matching

//val anyValue = (1,"1",Some(2),None,'A')
//
//val matchedResult = anyValue match {
//  case 1 => s"Value found"
//  case "1"=> s"Value Found"
//  case 2 =>s"Value Found"
//  case _  =>"Value Not found"
//}


//ordered trait
case class Person(name: String, age: Int) extends Ordered[Person] {
  def compare(that: Person): Int = {
    if (this.name == that.name) {
      this.age.compare(that.age)
    } else {
      this.name.compare(that.name)
    }
  }
}

val person1 = Person("Alice", 25)
val person2 = Person("Bob", 30)
val person3 = Person("Alice", 30)

println(person1 < person2)
println(person1 > person3)
