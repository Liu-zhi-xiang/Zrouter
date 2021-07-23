package com.yk.zrouter.request


import android.app.ProgressDialog.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.selects.whileSelect
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import kotlin.Exception


/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/23
 * @mail: liuzhixiang@em-data.com.cn
 *
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class LoginRepository(private  val responseParser:LoginResponseParser) {

    fun makeLoginRequest(jsonBody: String) : Result<LoginResponse>{
        val url= URL(loginUrl)
        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Accept", "application/json")
            doOutput = true
            outputStream.write(jsonBody.toByteArray())
            return Result.Success(responseParser.parse(inputStream))
        }
        return Result.Error(Exception("cannot open HttpURLConnection"))
    }

    companion object {
        private const val  loginUrl = "https://example.com/login"
    }
    suspend fun fetchDoce(){
        val  result =get("https://developer.android.com")
        show(result)
    }

    private fun show(result: Unit) {
        TODO("Not yet implemented")

    }

    suspend fun get(url:String) = withContext(Dispatchers.IO) {

    }
}

