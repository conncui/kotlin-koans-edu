package get_class

import org.junit.Test

object GetClassObjTest {

    var companionObject1 :String = "ddd"
    fun main(){
        getClass()
    }
//    @Test
    fun getClass(){
        println("---------------------------------------")
        println("\nGetClassObjTest::class:")
        println(GetClassObjTest::class)

        println("\nGetClassObjTest.companionObject1.javaClass:")
        println(GetClassObjTest.companionObject1.javaClass)

        println("\nGetClassObjTest::class.java:")
        println(GetClassObjTest::class.java)

        println("\nGetClassObjTest::class.java.typeName:")
        println(GetClassObjTest::class.java.typeName)

        println("\nGetClassObjTest::javaClass:")
        println(GetClassObjTest::javaClass)

        println("\nGetClassObjTest.javaClass:")
        println(GetClassObjTest.javaClass)


        println("\nGetClassObjTest::class == GetClassObjTest::class.java :")
        println(GetClassObjTest::class == GetClassObjTest::class.java)

        println("\nGetClassObjTest.javaClass == GetClassObjTest::class.java :")
        println(GetClassObjTest.javaClass == GetClassObjTest::class.java)
        println("---------------------------------------")

    }
}

fun main() {
    GetClassObjTest.getClass()
}