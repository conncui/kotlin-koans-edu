package kotlinlang.k4_class_object.k_Data_Classes

data class DataClass(var name:String)
class NonDataClass(var name:String)


fun main(){
    DataClass("Hello")
    NonDataClass("Hello")
}