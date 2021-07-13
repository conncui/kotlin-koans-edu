package kotlinlang.k14_coroutines.more

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
private suspend fun initValue1():Int{
    println("initValue1 ,1：" + Thread.currentThread().id)
    delay(1000)
    println("initValue1 ,2：" + Thread.currentThread().id)
    return 1
}


private suspend fun initValue2():Int{
    println("initValue2 ,1：" + Thread.currentThread().id)
    delay(2000)
    println("initValue2 ,2：" + Thread.currentThread().id)
    return 2
}


private inline fun measureTimeMillis(codeBlock:()->Unit):Long{
    var start = System.currentTimeMillis();
    codeBlock()
    return System.currentTimeMillis() - start
}

fun main(){
    println("main：" + Thread.currentThread().id)

    runBlocking {
        println("runBlocking ：" + Thread.currentThread().id)
        val elapsed = measureTimeMillis {
            println("measureTimeMillis ：" + Thread.currentThread().id)
            val value1 = initValue1()
            val value2 = initValue2()

            println("value1+value2:"+(value1+value2))
        }
        println("elapsed:"+elapsed)
    }
}
