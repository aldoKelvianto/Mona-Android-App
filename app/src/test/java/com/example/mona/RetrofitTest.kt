package com.example.mona

import com.google.gson.Gson
import junit.framework.Assert.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface HttpBinService {

    @GET("status/200")
    suspend fun get200()

    @GET("status/500")
    suspend fun get500()
}

data class PostmanProfile(
    val id: Int = -1
)

data class PostmanError(
    val error: String = ""
)

interface PostmanService {

    @GET("profile")
    suspend fun get200(): PostmanProfile

    @POST("profile")
    suspend fun post500(): PostmanError
}

class RetrofitTest {

    private val httpBinRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://httpbin.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val httpBinService: HttpBinService = httpBinRetrofit.create(HttpBinService::class.java)

    private val postmanRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://a1489da6-507a-49eb-931b-ab0ace8e6a95.mock.pstmn.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val postmanService: PostmanService = postmanRetrofit.create(PostmanService::class.java)

    @Test
    fun httpBin200() {
        runBlocking {
            val result = runCatching {
                httpBinService.get200()
            }
            assertTrue(result.isSuccess)
        }
    }

    @Test
    fun httpBin500() {
        runBlocking {
            val result = runCatching {
                httpBinService.get500()
            }
            assertTrue(result.isFailure)
            val exception = result.exceptionOrNull()
            assertNotNull(exception)
            assertTrue(exception is HttpException)
        }
    }

    @Test
    fun postman200() {
        runBlocking {
            val result = kotlin.runCatching {
                postmanService.get200()
            }
            assertTrue(result.isSuccess)
            assertTrue(result.getOrThrow() == PostmanProfile(1))
        }
    }

    @Test
    fun postman500() {
        runBlocking {
            val result = kotlin.runCatching {
                postmanService.post500()
            }
            assertTrue(result.isFailure)
            val exception = result.exceptionOrNull() as HttpException
            assertEquals(exception.code(), 500)
            val errorBody = String(exception.response()!!.errorBody()!!.bytes())
            val postmanError = Gson().fromJson(errorBody, PostmanError::class.java)
            assertEquals(postmanError.error, "nginx not working")
        }
    }
}
