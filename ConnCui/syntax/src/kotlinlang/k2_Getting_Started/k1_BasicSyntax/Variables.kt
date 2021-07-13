package kotlinlang.k2_Getting_Started.k1_BasicSyntax


class Variables {

    var mVarFeildStr : String = ""

    // var == final
    val mValFeild : String = ""

    // Error:(x, x) Kotlin: Conflicting declarations:
    // public final val mValFeild: String,
    // open val mValFeild : String = ""


    var mVarFeildInt : Int = 3
    val mValFeildInt : Int = 4

}


fun main(){
    var v1 = Variables()
//    var v2 = Variables()
//
//    v1.mVarFeildStr = "ddddddd"
//    println("----")
//    println(v1.mVarFeildStr)
//    println(v2.mVarFeildStr)
}