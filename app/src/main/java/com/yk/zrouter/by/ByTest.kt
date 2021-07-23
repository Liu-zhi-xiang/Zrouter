package com.yk.zrouter.by

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/24
 * @mail: liuzhixiang@em-data.com.cn
 *
 */
interface Base{
    fun xprint()
}

interface IGamePlayer{
    fun rank()
    fun upgrade()
}
class RealGamePlayer(private val name:String):IGamePlayer{
    override fun rank() {
        TODO("Not yet implemented")
        println("$name 带排位")
    }

    override fun upgrade() {
        TODO("Not yet implemented")
        println("$name 把段位升了")
    }

}


class DelegateAttribute{
    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        return "$thisRef,thank you for delegate'${property.name}'to me!"
    }
    operator fun setValue(thisRef:Any?,property:KProperty<*>,value:String){
        println("$value has bean assigned to '${property.name}' in $thisRef.")
    }
}

class Delegate1:ReadOnlyProperty<Any,String>{
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        TODO("Not yet implemented")
    }


}
fun stringMapper(string: String,mapper:(String,Int) -> Int):Int{
    return mapper(string,0)
}

var observableProp:String by Delegates.observable("默认值:123"){
    property, oldValue, newValue ->
    println("property : $property: $oldValue -> $newValue")
}

var vetoableprop:Int by Delegates.vetoable(0 ){
    _,oldVale,newvale ->
    newvale>oldVale
}
class User(val map: Map<String,Any?>){
    val name:String by map
    val age: Int by map
}

class DelegateGamePlayer(private val player: IGamePlayer):IGamePlayer by player
/**
 * 实现Base接口被委托的类
 */
class BaseImpl(val x: Int):Base{
    override fun xprint() {
        print(x)
    }
}
class Derived(base: Base):Base by base



fun main(args:Array<String>){
    val b=BaseImpl(10)
    Derived(b).xprint()
    val s= stringMapper("kotlin") { input,int ->
        int+input.length
    }
    val  user =User(mapOf(
            "name" to "老大",
            "age" to  25
    ))
    println(s)
    println(user)

}
