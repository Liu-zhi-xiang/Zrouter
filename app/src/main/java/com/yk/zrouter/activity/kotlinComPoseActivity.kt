package com.yk.zrouter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContainerAlpha
import androidx.compose.material.Text

import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource

import com.yk.zrouter.R

class kotlinComPoseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        setContent {
////            Greeting("kotlin")
//        }
        val stringLengthFunc:(String) -> Int ={input -> input.length}
    }

//    @Composable
//    fun  Greeting(name :String){
//        Column {
//
//
//            Image(imageResource(R.drawable.ic_launcher_background))
//            Text("hello $name!")
//            Text("hello 技术杂货铺!")
//            Greeting("asdasda")
//        }
//
//
//    }
//
//
//    @Preview
//    @Composable
//    fun PreviewGreeting() {
//        Greeting("Android")
//    }
}