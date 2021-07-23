package com.yk.zrouter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.viewinterop.viewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.yk.zrouter.R

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/23
 * @mail: liuzhixiang@em-data.com.cn
 *
 */
class Loginafragment :Fragment(){

    private lateinit var usernameEdit: EditText
    private lateinit var userpassEdit: EditText
    private lateinit var loginBut: Button
//    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =inflater.inflate(R.layout.fragment_login,container,false)

        usernameEdit=view.findViewById(R.id.username_edit_text)
        userpassEdit=view.findViewById(R.id.userpass_edit_text)
        loginBut=view.findViewById(R.id.login_bt)


        return view
    }
}