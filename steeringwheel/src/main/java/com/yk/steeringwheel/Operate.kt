package com.yk.steeringwheel

import kotlinx.coroutines.*
import sun.rmi.runtime.Log
import sun.rmi.runtime.Log.BRIEF
import sun.rmi.server.Dispatcher
import java.rmi.server.LogStream.BRIEF

class Operate {


     fun test()= runBlocking {
        repeat(8){
            println("协成执行$it 线程id:${Thread.currentThread().id}")
            delay(1000)
        }
    }
    suspend fun xlanch(){
        println("主线程id:${Thread.currentThread().id}")
        val job=GlobalScope.launch {
            delay(60000)
            println("协成执行结束--线程Id:${Thread.currentThread().id}")

            withTimeout(13000){
                repeat(1000){
                    i ->
                    println("I'm sleeping .... $i ....")
                    delay(500L)
                }

            }
           val resu= withContext(Dispatchers.IO){
                delay(6000)
           }

        }

        val result = withTimeoutOrNull(300L){
            println("result==${repeat(1){
            i: Int ->  
                println("caaa")
            }
            }")
        }

        val resu=GlobalScope.async{

        }
        resu.getCompleted()

        println("获取结果")
        println("主线程执行结束"  +job.isCancelled)
    }
}


private suspend fun getResult1():Int{
    delay(3000)
    return 1
}

private suspend fun getResult2():Int{
    delay(4000)
    return 2
}

fun main(array: Array<String>){
    println("-------------------->开始了")
    Dispatchers.IO //UI线程，内置线程池

    Dispatchers.Default
//        DefaultScheduler 自身建筑线程池
//        CommonPool  维护java内部线程池

    Dispatchers.Main
    Dispatchers.Unconfined
    GlobalScope.launch (Dispatchers.Default){
        delay(60000)
        println("协成执行结束--线程Id:${Thread.currentThread().id}")
        val result1=GlobalScope.async(){
          getResult1()
        }
        val result2=GlobalScope.async {
            getResult2()
        }
        val result= result1.await()+result2.await()
        print("result = $result")
    }
    //构建协程作用域（CoroutineContext  =）
    //CoroutineContext   属于Element 集合

//        job (new 、active 、completing 、completed 、cancelling 、cancelled)
//        CoroutineDispatcher (IO 、Default 、Main 、Unconfined)
//        CoroutineName
//        CoroutineExceptionHandler  异常类型job (SupervisorJob)

    val  scope= CoroutineScope(CoroutineName("coroutine-Name")+Dispatchers.IO)

    //结束 scope.cancel()
    // CoroutineStart 指定协程的启动模式 ，枚举类型
    // DEFAULT | LAZY | ATOMIC | UNDISPATCHED
    val  job= scope.launch(start = CoroutineStart.DEFAULT) {
        println("hello world")

    }


    Thread.sleep(1000)
    println("结束了<-------------------")
}


