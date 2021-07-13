package get_class


object GetClassObj {

    var companionObject1 :String = "ddd"
    fun main(){
        getClass()
    }
    fun getClass(){
        println("---------------------------------------")
        println("\nGetClassObj::class:")
        println(GetClassObj::class)

        println("\nGetClassObj.companionObject1.javaClass:")
        println(GetClassObj.companionObject1.javaClass)

        println("\nGetClassObj::class.java:")
        println(GetClassObj::class.java)

        println("\nGetClassObj::class.java.typeName:")
        println(GetClassObj::class.java.typeName)

        println("\nGetClassObj::javaClass:")
        println(GetClassObj::javaClass)

        println("\nGetClassObj.javaClass:")
        println(GetClassObj.javaClass)


        println("\nGetClassObj::class == GetClassObj::class.java :")
        println(GetClassObj::class == GetClassObj::class.java)

        println("\nGetClassObj.javaClass == GetClassObj::class.java :")
        println(GetClassObj.javaClass == GetClassObj::class.java)
        println("---------------------------------------")

    }
}

fun main() {
    GetClassObj.getClass()
}