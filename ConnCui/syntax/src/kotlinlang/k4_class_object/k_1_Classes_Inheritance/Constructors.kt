package kotlinlang.k4_class_object.k_1_Classes_Inheritance

open class Parent{
    var mName:String? = null
    constructor( name: String){
        mName = name + "Parent"
    }
}



class Son : Parent {
    constructor( name: String) : super(name){
        mName = this.mName + "Son"
    }
}

fun main(){
    var parent = Parent("pp")
    var son = Son("son")

    println(son.mName)
}