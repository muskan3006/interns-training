

class Animal
class Cat extends Animal
class Dog  extends Animal

//covariant
class CovariantList[+A]
val animal  :Animal = new Cat
val animalList :CovariantList[Animal]= new CovariantList[Cat]

//invariant

class InvariantList[A]
val invariantList:InvariantList[Animal]= new InvariantList[Animal]

//contravariant
class Contravariant[-A]
val contravariant :Contravariant[Cat]=new Contravariant[Animal]

class Trainer[-A]
val trainer :Trainer[Cat] = new Trainer[Animal]



