package com.example.mona

import android.os.Build
import android.util.Base64
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

// To avoid "Method encodeToString in android.util.Base64 not mocked." error,
// use robolectric or use emulator/test device.
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.TIRAMISU])
class AndroidBase64Test {

    /**
     * Example output: ewogICAgImV4cDEiOiAidmFsdWUxIiwKICAgICJleHAyIjogIiIsCiAgICAiZXhwMyI6ICJ2YWx1
    ZTMiCn0=
     */
    @Test
    fun `json encode test`() {
        // Given
        val message = """
            {
                "exp1": "value1",
                "exp2": "",
                "exp3": "value3"
            }
        """.trimIndent()

        // When
        val encodedString = Base64.encodeToString(message.toByteArray(), Base64.DEFAULT)
        val decodedString = String(Base64.decode(encodedString, Base64.DEFAULT))

        // Then
        assertEquals(message, decodedString)
    }

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
    fun `decode test 1`() {
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

    @Test
    fun `decode test 2`() {
        // Given
        val encodedPayload =
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ"

        // When
        val decodedPayload: ByteArray = Base64.decode(encodedPayload, Base64.DEFAULT)
        val actual = String(decodedPayload)

        // Then
        val expected = """{"sub":"1234567890","name":"John Doe","iat":1516239022}"""
        assertEquals(expected, actual)
    }

    @Test
    fun `decode test 3`() {
        // Given
        val encodedPayload =
            "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ"

        // When
        val decodedPayload: ByteArray = Base64.decode(encodedPayload, Base64.NO_PADDING)
        val actual = String(decodedPayload)

        // Then
        val expected = """{"sub":"1234567890","name":"John Doe","iat":1516239022}"""
        assertEquals(expected, actual)
    }
}
