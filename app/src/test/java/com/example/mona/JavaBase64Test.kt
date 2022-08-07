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

    @Test
    fun `decode test`() {
        // Given
        val encodedPayload =
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ"

        // When
        val decodedPayload: ByteArray = Base64.getUrlDecoder().decode(encodedPayload)
        val actual = String(decodedPayload)

        // Then
        val expected = """{"sub":"1234567890","name":"John Doe","iat":1516239022}"""
        assertEquals(expected, actual)
    }
}
