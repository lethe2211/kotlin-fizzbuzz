package org.example.demo.sample

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class SUTTest {

    @Nested
    inner class FizzBuzzTest {

        @Nested
        inner class RegularCases {
            @BeforeEach
            fun setUp() {
                // Nope
            }

            @AfterEach
            fun tearDown() {
                // Nope
            }

            // Equivalence partitioning

            @Test
            fun `If n is a positive multiple of 15, return "fizzbuzz"`() {
                val expected = "fizzbuzz"

                val sut = SUT()
                val actual = sut.fizzbuzz("30")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is a positive multiple of 3 but not a multiple of 15, return "fizz"`() {
                val expected = "fizz"

                val sut = SUT()
                val actual = sut.fizzbuzz("6")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is a positive multiple of 5 but not a multiple of 15, return "buzz"`() {
                val expected = "buzz"

                val sut = SUT()
                val actual = sut.fizzbuzz("10")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n does not meet any of condition of fizzbuzz, return the n itself`() {
                val expected = "16"

                val sut = SUT()
                val actual = sut.fizzbuzz("16")

                assertEquals(expected, actual)
            }

            // Boundary value tests

            @Test
            fun `If n is "1", return the n itself`() {
                val expected = "1"

                val sut = SUT()
                val actual = sut.fizzbuzz("1")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is a numstring which represents the max value of Long (= "9223372036854775807"), return the n itself`() {
                val expected = "9223372036854775807"

                val sut = SUT()
                val actual = sut.fizzbuzz("9223372036854775807")

                assertEquals(expected, actual)
            }

            @Test
            fun `Adding "+" at the beginning of n does not change the behavior`() {
                val expected = "16"

                val sut = SUT()
                val actual = sut.fizzbuzz("+16")

                assertEquals(expected, actual)
            }

            // Bonuses

            @Test
            fun `If n consists of digits but starts with "+0", return "error"`() {
                val expected = "fizz"

                val sut = SUT()
                val actual = sut.fizzbuzz("+0123")

                assertEquals(expected, actual)
            }
        }

        @Nested
        inner class IrregularCases {
            @BeforeEach
            fun setUp() {
                // Nope
            }

            @AfterEach
            fun tearDown() {
                // Nope
            }

            // Equivalence partitioning

            @Test
            fun `If n is null, return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz(null)

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is not a valid numstring, return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("123abc")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is zero, return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("0")

                assertEquals(expected, actual)
            }

            // Boundary value tests

            @Test
            fun `If n is a numstring which represents the max value of Long + 1 (= "9223372036854775808"), return the n itself`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("9223372036854775808")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is "-1", return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("-1")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is a numstring which represents the min value of Long (= "-9223372036854775808"), return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("-9223372036854775808")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n is a numstring which represents the min value of Long - 1 (= "-9223372036854775809"), return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("-9223372036854775809")

                assertEquals(expected, actual)
            }

            // Bonuses

            /**
             * Might be redundant.
             */
            @Test
            fun `If n is an empty string, return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("")

                assertEquals(expected, actual)
            }

            @Test
            fun `If n consists of digits but starts with "0", return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("0123")

                assertEquals(expected, actual)
            }

            /**
             * Might be redundant.
             */
            @Test
            fun `If n consists of digits but starts with "-0", return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("-0123")

                assertEquals(expected, actual)
            }

            /**
             * Might not be needed.
             */
            @Test
            fun `If n has non ascii characters, return "error"`() {
                val expected = "error"

                val sut = SUT()
                val actual = sut.fizzbuzz("日本語")

                assertEquals(expected, actual)
            }
        }
    }
}