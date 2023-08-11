package org.example.demo.sample

import java.lang.NumberFormatException

class SUT {

    /**
     * Take a numstring n (like "123") and return the result by testing if n meets the condition of fizzbuzz.
     *
     * Condition of fizzbuzz:
     * 1. If n is (both of) a positive multiple of 3 and a positive multiple of 5, it must return "fizzbuzz"
     * 2. If n is a positive multiple of 3 but it does not meet 1., it must return "fizz"
     * 3. If n is a positive multiple of 5 but it does not meet 1., it must return "buzz"
     * 4. If n is positive but it does not meet any of 1., 2. and 3., it must return the numstring n itself
     * 5. If n does not meet any of 1., 2., 3. and 4., it must return "error" (= Irregular case)
     *
     * @param n A numstring to be tested if it meets fizzbuzz.
     * @return "fizz" or "buzz" or "fizzbuzz" or the numstring n itself or "error".
     */
    fun fizzbuzz(n: String?): String {
        // Irregular cases

        // If n is null, return "error"
        if (n == null) {
            return "error"
        }


        // If n is not a valid numstring, return "error"
        // We have to take care of the cases when n starts with '0' (like "0123" or "-0123") or "+0" (like "+0123")
        if (n.startsWith("0")) {
            return "error"
        }
        // Note that we have to care about the overflow problem which is unavoidable.
        // Here we're assuming nAsNumString must be in the range of [Long.MIN_VALUE, Long.MAX_VALUE]
        val nAsNumString = try {
            n.toLong()
        } catch (e: NumberFormatException) {
            return "error"
        }

        // If n is negative or zero, return "error"
        if (nAsNumString <= 0L) {
            return "error"
        }


        // Regular cases

        if (nAsNumString % 15L == 0L) { // Condition 1.
            return "fizzbuzz"
        } else if (nAsNumString % 3L == 0L) { // Condition 2.
            return "fizz"
        } else if (nAsNumString % 5L == 0L) { // Condition 3.
            return "buzz"
        } else { // Condition 4.
            if (n.startsWith("+0")) {
                return n.substring(2) // Remove "+0"
            } else if (n.startsWith("+")){
                return n.substring(1) // Remove "+"
            } else {
                return n
            }
        }
    }
}