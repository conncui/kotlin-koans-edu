package get_class

import org.junit.Test


class GetClassTest {
    companion object{
        var companionObject1 :String = "ddd"
        var companionObject2 :Int = 1
    }
    fun main(){
        getClass()
    }
    @Test
    fun getClass(){
        println("---------------------------------------")
        println("\nGetClassTest::class:")
        println(GetClassTest::class)

        println("\nGetClassTest.companionObject1.javaClass:")
        println(GetClassTest.companionObject1.javaClass)

        println("\nGetClassTest::class.java:")
        println(GetClassTest::class.java)

        println("\nGetClassTest::class.java.typeName:")
        println(GetClassTest::class.java.typeName)

        println("\nGetClassTest::javaClass:")
        println(GetClassTest::javaClass)

        println("\nGetClassTest.javaClass:")
        println(GetClassTest.javaClass)


        println("\nGetClassTest::class == GetClassTest::class.java :")
        println(GetClassTest::class == GetClassTest::class.java)


        println("\nGetClassTest.javaClass == GetClassTest::class.java :")
        println(GetClassTest.javaClass == GetClassTest::class.java)
        println("---------------------------------------")

    }
}

fun main() {
    GetClassTest().getClass()
}