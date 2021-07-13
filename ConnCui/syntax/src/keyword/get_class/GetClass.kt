package get_class



class GetClass {
    var mField_1 : String = ""
    var mField_2 : Int = 0

    constructor()
    constructor(mField_1: String) {
        this.mField_1 = mField_1
    }

    constructor(mField_1: String, mField_2: Int) {
        this.mField_1 = mField_1
        this.mField_2 = mField_2
    }

    companion object{
        var companionObject1 :String = "ddd"
        var companionObject2 :Int = 1
    }

    fun main(){
        getClass()
    }
    fun getClass(){
        println("---------------------------------------")
        println("\nGetClass::class:")
        println(GetClass::class)

        println("\nGetClass.companionObject1.javaClass:")
        println(GetClass.companionObject1.javaClass)

        println("\nGetClass::class.java:")
        println(GetClass::class.java)

        println("\nGetClass::class.constructors:")
        println(GetClass::class.constructors.forEachIndexed { index, kFunction ->
            println("index:"+index+", kFunction:"+kFunction.name + kFunction.parameters.forEach { it.name })
        })

        println("\nGetClass::class.java.typeName:")
        println(GetClass::class.java.typeName)

        println("\nGetClass::javaClass:")
        println(GetClass::javaClass)

        println("\nGetClass.javaClass:")
        println(GetClass.javaClass)


        println("\nGetClass::class == GetClass::class.java :")
        println(GetClass::class == GetClass::class.java)


        println("\nGetClass.javaClass == GetClass::class.java :")
        println(GetClass.javaClass == GetClass::class.java)
        println("---------------------------------------")

    }
}

fun main() {
    GetClass().getClass()
}
