package org.example.demo.sample

class Calc2(
    private val dependency: Dependency
) {
    fun delegate(): Int {
        return dependency.calc(1, 2)
    }
}
