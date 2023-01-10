package com.example.mona

import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HttpBinService {

    @GET("status/200")
    suspend fun get200()

    @GET("status/500")
    suspend fun get500()
}

class RetrofitTest {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://httpbin.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: HttpBinService = retrofit.create(HttpBinService::class.java)

    @Test
    fun testGet200() {
        runBlocking {
            val result = runCatching {
                service.get200()
            }
            assertTrue(result.isSuccess)
        }
    }

    @Test
    fun testGet500() {
        runBlocking {
            val result = runCatching {
                service.get500()
            }
            assertTrue(result.isFailure)
        }
    }
}
