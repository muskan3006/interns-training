import com.knoldus.ExpressionCalculatorShrasti
import org.scalatest.funsuite.AnyFunSuite
import com.knoldus._

class CalculateExpressionTest extends AnyFunSuite{

  test("Number") {
    val actualValue =ExpressionCalculator.evaluate(Number(2))
    val expectedValue = 2
    assert(actualValue===expectedValue)
  }

  test("Addition"){
    val actualValue = ExpressionCalculator.evaluate(Sum2(Number(2),Number(45)))
    val expectedValue = 47
    assert(actualValue === expectedValue)
  }

  test("Subtraction") {
    val actualValue = ExpressionCalculator.evaluate(Minus2(Number(200), Number(100)))
    val expectedValue = 100
    assert(actualValue === expectedValue)
  }

  test("Multiplication") {
    val actualValue = ExpressionCalculator.evaluate(Mult2(Number(20), Number(8)))
    val expectedValue = 160
    assert(actualValue === expectedValue)
  }

  test("Divide") {
    val actualValue = ExpressionCalculator.evaluate(Divide2(Number(200), Number(0)))
    val expectedValue = 0
    assert(actualValue === expectedValue)
  }

}
