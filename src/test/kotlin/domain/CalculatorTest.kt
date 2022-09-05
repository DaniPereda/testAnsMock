package domain

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

internal class CalculatorTest {

    @Test
    fun `Calculator class not null`() {
        // GIVEN
        val sut = Calculator()

        assertNotNull(sut)

    }

    @Test
    fun `correct value in function  add 10 + 20`() {
        // GIVEN
        val n1 = 10
        val n2 = 20
        val sut = Calculator()
        // WHEN
        val result = sut.add(n1, n2)
        // THEN
        assertEquals(30, result)
    }

    @Test
    fun `correct value in function add 7 - 4`() {
        // GIVEN
        val n1 = 7
        val n2 = 4
        val sut = Calculator()
        // WHEN
        val result = sut.add(n1, n2)
        // THEN
        assertEquals(11, result)
    }

    @Test
    fun `correct value in function substract 10 - 20`() {
        // GIVEN
        val n1 = 10
        val n2 = 20
        val sut = Calculator()
        // WHEN
        val result = sut.substract(n1, n2)
        // THEN
        assertEquals(-10, result)
    }
    @Test
    fun `correct value in function substract 7 - 4`() {
        // GIVEN
        val n1 = 7
        val n2 = 4
        val sut = Calculator()
        // WHEN
        val result = sut.substract(n1, n2)
        // THEN
        assertEquals(3, result)
    }

    @Test
    fun `correct value in function divide 8 - 4`() {
        // GIVEN
        val n1 = 8
        val n2 = 4
        val sut = Calculator()
        // WHEN
        val result = sut.divide(n1, n2)
        // THEN
        assertEquals(2, result)
    }

    @Test
    fun `divided by zero`() {
        // GIVEN
        val n1 = 8
        val n2 = 0
        val sut = Calculator()
        // WHEN
        // THEN
        assertFailsWith<ArithmeticException>(
            message = "Error --> DIVIDE BY ZERO",
            block = {
                sut.divide(n1, n2)
            }
        )
    }

    @Test
    fun assertAllTest(){
        assertAll(
            { assertEquals(21, 21)},
            { assertEquals(66, 66)},
            {assertEquals(55, 55)}
        )
    }

    @Nested
    inner class AddTest{
        @Test
        fun `Add positive number test`(){
            assertEquals(20, 10 + 10)
        }
        @Test
        fun `Add negative number test`(){
            assertEquals(-20, -10 + (-10))
        }
        @Test
        fun `Add zero test`(){
            assertEquals(5, 5 + 0)

        }
    }
}