package com.example.mona

import android.util.Base64
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

// To avoid "Method encodeToString in android.util.Base64 not mocked." error,
// use robolectric or use emulator/test device.
@RunWith(RobolectricTestRunner::class)
class AndroidBase64Test {

    @Test
    fun `encode test`() {
        // Given
        val message = "hello?world".toByteArray()

        // When
        val outputPadding = Base64.encodeToString(message, Base64.DEFAULT)
        val outputNoPadding = Base64.encodeToString(message, Base64.NO_PADDING)
        val outputUrlSafe = Base64.encodeToString(message, Base64.URL_SAFE)
        val outputNoClose = Base64.encodeToString(message, Base64.NO_CLOSE)
        val outputNoWrap = Base64.encodeToString(message, Base64.NO_WRAP)
        val outputCrlf = Base64.encodeToString(message, Base64.CRLF)

        // Then
        assertEquals("aGVsbG8/d29ybGQ=\n", outputPadding)
        assertEquals("aGVsbG8/d29ybGQ\n", outputNoPadding)
        assertEquals("aGVsbG8_d29ybGQ=\n", outputUrlSafe)
        assertEquals("aGVsbG8/d29ybGQ=\n", outputNoClose)
        assertEquals("aGVsbG8/d29ybGQ=", outputNoWrap)
        assertEquals("aGVsbG8/d29ybGQ=\r\n", outputCrlf)
    }


    @Test
    fun `decode test`() {
        // Given
        val encodedPayload =
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ"

        // When
        val decodedPayload: ByteArray = Base64.decode(encodedPayload, Base64.URL_SAFE)
        val actual = String(decodedPayload)

        // Then
        val expected = """{"sub":"1234567890","name":"John Doe","iat":1516239022}"""
        assertEquals(expected, actual)
    }
}
