import com.knoldus._
import org.scalatest.funsuite.AnyFunSuite

class ScalaPracticeDay4Test extends AnyFunSuite {
  test("Testing for Number expression") {
    val expected = ExpressionCalculator.evaluate(Number(5))
    val actual = 5
    assert(expected === actual)
  }

  test("Testing for Sum expression") {
    val actual = ExpressionCalculator.evaluate(Sum2(Number(10), Number(20)))
    val expected = 30
    assert(expected == actual)
  }

  test("Testing for Multiply expression") {
    val actual = ExpressionCalculator.evaluate(Multiply2(Sum2(Number(1), Number(2)), Sum2(Number(5), Number(3))))
    val expected = 24
    assert(expected == actual)
  }

  test("Testing for minus expression") {
    val actual = ExpressionCalculator.evaluate(Minus2(Sum2(Minus2(Number(54), Number(96)), Number(17)), Multiply2(Number(7), Number(9))))
    val expected = -88
    assert(expected == actual)
  }

  test("Test for divide expression") {
    val actual = ExpressionCalculator.evaluate(Multiply2(Sum2(Divide2(Number(100), Number(10)), Multiply2(Number(15), Divide2(Number(50), Number(5)))), Minus2(Multiply2(Number(69), Number(47)), Number(178))))
    val expected = 490400
    assert(expected == actual)
  }
}

