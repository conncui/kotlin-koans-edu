package nullvar

fun getA() :String?{
    return null
}

fun getB() :String?{
    return null
}

fun getC() :String?{
    var randon = Math.random()
    if (randon + 1.5  > 0.5){
        return null
    }else{
        return "getC return"
    }
}

fun main(){
    var a:String? = getA()


    a ?: println("null")
    println(Thread.currentThread().name)

    var b:String = "dddddd"
    a = "ddddddddddddd"
    a?.let {  println(a)}?: println("null")

    a = null

    println("print when null { ")
    println(a?.toString())
    println(a?.length)

    var length = a?.length
    println(a?.length)
    println("print when null } ")

    a = "dddddddddd"




    a?.let {
        println("not null")
        println(a)
        println(Thread.currentThread().name)
    }?: run{
        println("is null")
        println(a)
        println(Thread.currentThread().name)
    }



    var c :String?= getC()

    c?.let {
        println("c.let print")
    }

    var temp  = null

    var randon = Math.random()
    if (randon  > 0.5){
        c = temp
    }
    println("random"+randon+" "+c)
    c.let {
        println("c null")
    }

//    c = ""
    c?.let {
        println("c not null")
    }?:run{
        println("c is null")

    }


    c?.run {
        println(" c?.run ")
    }

    c?.let {
        println(" c?.let ")
    }

    c?:run {
        println(" c?:run ")
    }


    var nullLength :String? = null

    // nullLength?.length is null
    println("  nullLength: "+nullLength?.length)

    if (nullLength?.length == 0){
        println(" c?:run ")

    }
}
