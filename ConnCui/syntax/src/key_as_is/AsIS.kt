package key_as_is

fun test(objP1: Parent,objP2: Parent){
    var obj1: Son? = objP1 as? Son
    println(obj1)
    if (obj1 == null) {
        obj1 = objP2 as? Son
    }
    println(obj1)
}

fun main(args: Array<String>) {
    var son = Son();
    var son2 = Son2();
//    test(son2)
//    test(son,son2)
    test(son2,son)
}