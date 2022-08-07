package com.example.mona

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class JavaBase64Test {

    @Test
    fun `encode test`() {
        // Given
        val message = "hello?world".toByteArray()

        // When
        val outputPadding = Base64.getEncoder().encodeToString(message)
        val outputNoPadding = Base64.getEncoder().withoutPadding().encodeToString(message)
        val outputUrlSafe = Base64.getUrlEncoder().encodeToString(message)
        val outputUrlSafeNoPadding = Base64.getUrlEncoder().withoutPadding().encodeToString(message)

        // Then
        assertEquals("aGVsbG8/d29ybGQ=", outputPadding)
        assertEquals("aGVsbG8/d29ybGQ", outputNoPadding)
        assertEquals("aGVsbG8_d29ybGQ=", outputUrlSafe)
        assertEquals("aGVsbG8_d29ybGQ", outputUrlSafeNoPadding)
    }
}
