import main.kotlin.add
import main.kotlin.divide
import main.kotlin.subtract
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalculatorTest {

    @Test
    fun testAdd() {
        assertEquals(5, add(2, 3))
        assertEquals(0, add(-2, 2))
    }

    @Test
    fun testSubtract() {
        assertEquals(3, subtract(5, 2))
        assertEquals(-4, subtract(-2, 2))
    }

    @Test
    fun testDivide() {
        assertEquals(5, divide(10, 2))
        assertFailsWith<IllegalArgumentException> {
            divide(10, 0)
        }
    }
}
