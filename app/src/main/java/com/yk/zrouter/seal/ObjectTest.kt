package com.yk.zrouter.seal

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/23
 * @mail: liuzhixiang@em-data.com.cn
 *
 */
class ObjectTest {
//    companion object mintest{
//        fun method(){
//
//        }
//    }
    companion object Myobject{
        val a=20
        fun method(){
            println("I'm in companion object")
        }
    }
}
interface  AA{
    fun  a()
}

interface BB{
    fun b()
}
fun main(srgs:Array<String>){
    ObjectTest.method()
    println(ObjectTest.a)

    val aa= object :AA{
        override fun a() {
           println("a invoked")
        }
    }
    aa.a()
    val cc= object {
        fun c(){
            println("c in cc")
        }
    }

    cc.c()

    val dd=object :AA,BB{
        override fun a() {
           println("a in AA")
        }

        override fun b() {
           println("b in BB")
        }
    }

    dd.a()
    dd.b()

}