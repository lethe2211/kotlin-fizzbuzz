package org.example.demo.sample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CalcTest {
    lateinit var calc: Calc

    @BeforeEach
    fun setUp() {
        calc = Calc(2)
    }

    @Test
    fun `add can return the summation of origNum and num`() {
        val expected = 6
        assertEquals(expected, calc.add(4))
    }
}
