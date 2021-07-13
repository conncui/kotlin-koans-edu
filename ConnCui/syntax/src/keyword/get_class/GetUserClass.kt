package get_class

import keyword.bean.User


class GetUserClass {
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
        User()
    }
    fun getUser(){
        println("---------------------------------------")
        println("\nUser::class:")
        println(User::class)


        println("\nUser::class.java:")
        println(User::class.java)

        println("\nUser::class.constructors:")
        println(User::class.constructors.forEachIndexed { index, kFunction ->
            println("index:"+index+", kFunction:"+kFunction.name + kFunction.parameters)
            kFunction.typeParameters.forEach { print("typeParameters:"+it) }
        })

        println("\nUser::class.java.typeName:")
        println(User::class.java.typeName)

        println("\nUser::javaClass:")
        println(User::javaClass)

        println("\nUser.javaClass:")
//        println(User.javaClass)


        println("\nUser::class == User::class.java :")
        println(User::class == User::class.java)


        println("\nUser.javaClass == User::class.java :")
//        println(User.javaClass == User::class.java)
        println("---------------------------------------")

    }
}

fun main() {
    GetUserClass().getUser()
}
