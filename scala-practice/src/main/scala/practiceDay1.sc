
val x= 5  // statement in scala

val x = 5+10 // Expression in scala


// statement executes for their side effects
def printHello():Unit = {
  println("Hello")
}
printHello()

//expression returns a value
def typeCheck(value :Int):String ={
  if(value >0) "Positive" else "Negative"
}
typeCheck(5)


//code block is also an expression
val block = {
  val firstValue = 2
  val secondValue =3
  if(firstValue+secondValue %2==0) "Even number" else "Odd number"
}


// string operations
val stringValue = "Hello My name is Sheshnath"
stringValue.charAt(0)
stringValue.substring(0,5)
stringValue.substring(6,8)
stringValue.split(" ",4).toList
stringValue.replace(" ","-")
stringValue.toLowerCase()
stringValue.length
stringValue.contains("s")
stringValue.take(4)
stringValue.takeRight(4)
stringValue.reverse


//scala specific interpolators

val name  ="Sheshnath"
val age =23
val greeting = s"Hello my name is $name and  age is $age"


