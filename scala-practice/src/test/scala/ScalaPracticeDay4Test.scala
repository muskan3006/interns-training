import com.knoldus._
import org.scalatest.funsuite.AnyFunSuite

class ScalaPracticeDay4Test extends AnyFunSuite {
  test("Testing for Number expression") {
    val expected = ExpressionCalculatorShrasti.evaluate(TakeNumber(5))
    val actual = 5
    assert(expected === actual)
  }

  test("Testing for Sum expression") {
    val actual = ExpressionCalculatorShrasti.evaluate(SumOfTwoNumbers(TakeNumber(10), TakeNumber(20)))
    val expected = 30
    assert(expected == actual)
  }

  test("Testing for Multiply expression") {
    val actual = ExpressionCalculatorShrasti.evaluate(MultiplyOfTwoNumbers(SumOfTwoNumbers(TakeNumber(1), TakeNumber(2)), SumOfTwoNumbers(TakeNumber(5), TakeNumber(3))))
    val expected = 24
    assert(expected == actual)
  }

  test("Testing for minus expression") {
    val actual = ExpressionCalculatorShrasti.evaluate(MinusOfTwoNumbers(SumOfTwoNumbers(MinusOfTwoNumbers(TakeNumber(54), TakeNumber(96)), TakeNumber(17)), MultiplyOfTwoNumbers(TakeNumber(7), TakeNumber(9))))
    val expected = -88
    assert(expected == actual)
  }

  test("Test for divide expression") {
    val actual = ExpressionCalculatorShrasti.evaluate(MultiplyOfTwoNumbers(SumOfTwoNumbers(DivideOfTwoNumbers(TakeNumber(100), TakeNumber(10)), MultiplyOfTwoNumbers(TakeNumber(15), DivideOfTwoNumbers(TakeNumber(50), TakeNumber(5)))), MinusOfTwoNumbers(MultiplyOfTwoNumbers(TakeNumber(69), TakeNumber(47)), TakeNumber(178))))
    val expected = 490400
    assert(expected == actual)
  }
}

