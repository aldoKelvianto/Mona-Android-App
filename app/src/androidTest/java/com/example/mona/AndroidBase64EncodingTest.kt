package com.example.mona

import android.util.Base64
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AndroidBase64EncodingTest {

    /**
     * Example output: ewogICAgImV4cDEiOiAidmFsdWUxIiwKICAgICJleHAyIjogIiIsCiAgICAiZXhwMyI6ICJ2YWx1
    ZTMiCn0=
     */
    @Test
    fun jsonEncodeDecodeTest1() {
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

    /**
     * Example output: WwogICAgewogICAgICAgICJleHAxIjogInZhbHVlMSIKICAgIH0sCiAgICB7CiAgICAgICAgImV4
    cDIiOiAiIgogICAgfSwKICAgIHsKICAgICAgICAiZXhwMyI6ICJ2YWx1ZTMiCiAgICB9Cl0=
     */
    @Test
    fun jsonEncodeDecodeTest2() {
        // Given
        val message = """
            [
                {
                    "exp1": "value1"
                },
                {
                    "exp2": ""
                },
                {
                    "exp3": "value3"
                }
            ]
        """.trimIndent()

        // When
        val encodedString = Base64.encodeToString(message.toByteArray(), Base64.DEFAULT)
        val decodedString = String(Base64.decode(encodedString, Base64.DEFAULT))

        // Then
        assertEquals(message, decodedString)
    }
}
