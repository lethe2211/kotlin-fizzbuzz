package org.example.demo.sample

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class DependencyImplTest {
    lateinit var dependency: Dependency

    @BeforeEach
    fun setUp() {
        dependency = DependencyImpl()
    }

    @Test
    fun `calc can return the summation of a and b`() {
        val expected = 3

        assertEquals(expected, dependency.calc(1, 2))
    }
}
