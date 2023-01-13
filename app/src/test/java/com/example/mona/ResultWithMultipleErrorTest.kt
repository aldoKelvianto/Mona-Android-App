package com.example.mona

import junit.framework.Assert.assertTrue
import org.junit.Test

class ResultWithMultipleErrorTest {

    @Test
    fun oneError() {
        val result = runCatching {
            throw Exception()
        }
        assertTrue(result.isFailure)
    }

    @Test
    fun twoErrors() {
        val result: Result<Int> = runCatching {
            name()
            age()
        }
        assertTrue(result.isFailure)
    }

    private fun name(): String {
        throw Exception()
    }

    private fun age(): Int {
        throw Exception()
    }
}
