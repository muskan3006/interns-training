import com.knoldus.ExpressionCalculator
import org.scalatest.funsuite.AnyFunSuite
import com.knoldus._

class CalculateExpressionsTest extends AnyFunSuite{

  test("Number") {
    val actualValue =ExpressionsCalculator.evaluate(Numbers(2))
    val expectedValue = 2
    assert(actualValue===expectedValue)
  }

  test("Addition"){
    val actualValue = ExpressionsCalculator.evaluate(SumTwoNumber(Numbers(2),Numbers(45)))
    val expectedValue = 47
    assert(actualValue === expectedValue)
  }

  test("Subtraction") {
    val actualValue = ExpressionsCalculator.evaluate(MinusTwoNumber(Numbers(200), Numbers(100)))
    val expectedValue = 100
    assert(actualValue === expectedValue)
  }

  test("Multiplication") {
    val actualValue = ExpressionsCalculator.evaluate(MultiplyTwoNumber(Numbers(20), Numbers(8)))
    val expectedValue = 160
    assert(actualValue === expectedValue)
  }

  test("Divide") {
    val actualValue = ExpressionsCalculator.evaluate(DivideByNumber(Numbers(200), Numbers(0)))
    val expectedValue = 0
    assert(actualValue === expectedValue)
  }

}
