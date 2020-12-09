package org.example.demo.sample

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class Calc2Test {
    lateinit var calc2: Calc2

    @MockK
    lateinit var dependency: Dependency

    @BeforeEach
    fun setUp() {
        calc2 = Calc2(dependency)
    }

    @Test
    fun `delegate can return the value of Dependency#calc`() {
        // Mock the behavior
        every { dependency.calc(any(), any()) } returns Int.MAX_VALUE

        val expected = Int.MAX_VALUE

        assertEquals(expected, calc2.delegate())

        // Verify if the mocked method was called
        verify(exactly = 1) { dependency.calc(any(), any()) }
    }

    @Test
    fun `delegate can throw an IllegalStateException when Dependency#calc throws an IllegalStateException`() {
        // Mock the behavior
        every { dependency.calc(any(), any()) } throws IllegalStateException("Unexpected exception.")

        // Assert that an IllegalStateException was really thrown
        assertThrows<IllegalStateException> {
            calc2.delegate()
        }

        // Verify if the mocked method was called
        verify(exactly = 1) { dependency.calc(any(), any()) }
    }
}
