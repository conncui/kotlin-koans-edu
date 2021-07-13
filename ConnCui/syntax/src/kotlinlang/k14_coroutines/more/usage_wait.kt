package kotlinlang.k14_coroutines.more

import kotlinx.coroutines.*


var mStart = System.currentTimeMillis();

private suspend fun initValue1():Int{
    printExecTime("initValue1")

    println("initValue1 ,1：" + "Thread id :"+Thread.currentThread().id)

    // 耗时任务1
//    for (i in 1..10000000000){
//        var a = ""
//    }

    // 耗时任务2
    delay(3000)

    println("initValue1 ,2：" + "Thread id :"+Thread.currentThread().id)
    return 1
}


private suspend fun initValue2():Int{
    printExecTime("initValue2")

    println("initValue2 ,1：" + "Thread id :"+Thread.currentThread().id)
    delay(2000)
    println("initValue2 ,2：" + "Thread id :"+Thread.currentThread().id)
    return 2
}


private inline fun measureTimeMillis( name:String,codeBlock:()->Unit):Long{
    println("measureTimeMillis:"+name)
    var start = System.currentTimeMillis();
    codeBlock()
    return System.currentTimeMillis() - start
}

private fun printExecTime(method:String){
    println("exec "+method+" time:"+(System.currentTimeMillis() - mStart))
}
fun main_block_thread_code(){
    println("main：" + "Thread id :"+Thread.currentThread().id)
    runBlocking {
        println("runBlocking ：" + "Thread id :"+Thread.currentThread().id)
        printExecTime("measureTimeMillis")
        val elapsed = measureTimeMillis("", {
            println("measureTimeMillis ：" + "Thread id :"+Thread.currentThread().id)
            val value1 = initValue1()
            val value2 = initValue2()

            println("value1+value2:"+(value1+value2))
        })
        println("elapsed:"+elapsed)
    }
}

suspend fun getResult(){

}
fun main_async_wait_other_thread_callback_code(){
    println("main_async_wait_other_thread_callback_code:")

    GlobalScope.launch {
        println("GlobalScope.launch:")

        suspend {
            println("coroutineScope" + "#runs on ${Thread.currentThread().name}")
            delay(1000)
            withContext(Dispatchers.Main) {
                println("coroutineScope" + "#runs on ${Thread.currentThread().name}")
            }
        }.invoke()
    }
}
fun main_async_wait_thread_code(){
    println("main：" + "Thread id :"+Thread.currentThread().id)
    runBlocking {
        println("runBlocking ：" + "Thread id :"+Thread.currentThread().id)
        val elapsed = measureTimeMillis ("",{
            println("measureTimeMillis ：" + "Thread id :"+Thread.currentThread().id)
            val value1 = async { initValue1() }
            val value2 = async { initValue2() }

            println("value1+value2:"+(value1.await()+value2.await()))
        })
        println("elapsed:"+elapsed)
    }
}
fun main(){
    main_block_thread_code()
    /*
    main：Thread id :1
    runBlocking ：Thread id :1
    exec measureTimeMillis time:58
    measureTimeMillis ：Thread id :1
    exec initValue1 time:58
    initValue1 ,1：Thread id :1
    initValue1 ,2：Thread id :1
    exec initValue2 time:1065
    initValue2 ,1：Thread id :1
    initValue2 ,2：Thread id :1
    value1+value2:3
    elapsed:3012
    */


//    main_async_wait_thread_code()
    /*
    main：Thread id :1
    runBlocking ：Thread id :1
    measureTimeMillis ：Thread id :1
    exec initValue1 time:80
    initValue1 ,1：Thread id :1
    exec initValue2 time:82
    initValue2 ,1：Thread id :1
    initValue1 ,2：Thread id :1
    initValue2 ,2：Thread id :1
    value1+value2:3
    elapsed:2016

     */

//    main_async_wait_other_thread_callback_code()
}
