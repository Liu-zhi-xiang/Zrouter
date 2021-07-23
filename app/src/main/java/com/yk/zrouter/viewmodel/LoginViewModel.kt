package com.yk.zrouter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yk.zrouter.request.LoginRepository
import com.yk.zrouter.request.LoginResponse
import com.yk.zrouter.request.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/23
 * @mail: liuzhixiang@em-data.com.cn
 *
 */
class LoginViewModel(private var loginRepository: LoginRepository) : ViewModel() {

    fun login(username: String, token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val jsonBody = "{ username: \"$username\", token: \"$token\"}"

            val result = try {
                loginRepository.makeLoginRequest(jsonBody)
            } catch (e: Exception) {
                Result.Error(Exception("Network request failed"))
            }
            when (result) {
                is Result.Success<LoginResponse> -> println("成功")
                else -> println("失败")
            }
        }
    }
}