package kotlinlang.k14_coroutines.k2_basic

import kotlinx.coroutines.*
import util.getAllThreadSize
import util.getAllThreadStackTrace

fun main() {

//    main1()
//    main2()
//    main3()
//    mainJoin()
    structConcurrencyMain()
//    coroutineScopeMain()
//    startManyCoroutine()
}


fun  main1() {
    var startTime = System.nanoTime()
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        println("launch start:" + getDuration(startTime)) // 在延迟后打印输出

        runBlocking {
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        }
        println("World!") // 在延迟后打印输出

        /** 线程相关*/
        println("launch thread - "+getThreadId()) // 在延迟后打印输出
//        println("launch thread - \n"+ getAllThreadStackTrace()) // 在延迟后打印输出
        println("\n")
        println("launch end:" + getDuration(startTime)) // 在延迟后打印输出

    }
    println("main start:" + getDuration(startTime)) // 在延迟后打印输出

    /** 线程相关*/
    println("main thread - "+getThreadId()) // 在延迟后打印输出
//    println("main thread - \n"+ getAllThreadStackTrace()) // 在延迟后打印输出

    println("\n")
    println("Hello,") // 协程已在等待时主线程还在继续
    println("main start loop:" + getDuration(startTime)) // 在延迟后打印输出
    var a = 10109.33444f
    for (index in 1..100000000) {
        a = a * a * a * a * a * a * a * a * a * a * a
    }
    println("main end loop:" + getDuration(startTime)) // 在延迟后打印输出
    println("Hello 222222,") // 协程已在等待时主线程还在继续

//    Thread.sleep(5000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    runBlocking {
        delay(5000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    }
    println("main end:" + getDuration(startTime)) // 在延迟后打印输出
}

fun main2() {
    println("main：" + Thread.currentThread().id)
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        println("GlobalScope.launch：" + Thread.currentThread().id)

        delay(1000L)
        println("World!")
    }
    println("Hello,") // 主线程中的代码会立即执行
    runBlocking {
        // 但是这个表达式阻塞了主线程
        println("runBlocking：" + Thread.currentThread().id)
        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
    }
}

fun main3() = runBlocking<Unit> {
    // 开始执行主协程
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,") // 主协程在这里会立即执行
    delay(2000L)      // 延迟 2 秒来保证 JVM 存活
}

fun mainJoin() = runBlocking {
    val job = GlobalScope.launch {
        // 启动一个新协程并保持对这个作业的引用
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 等待直到子协程执行结束

}


fun structConcurrencyMain() = runBlocking {
    // this: CoroutineScope
    println("mairunBlockingn：" + Thread.currentThread().id)

    GlobalScope.launch {
        // 在 runBlocking 作用域中启动一个新协程
        println("launch：" + Thread.currentThread().id)

        delay(10000L)
        println("World!")
    }
    println("main：" + Thread.currentThread().id)

    println("Hello,")
}

fun coroutineScopeMain() {
    var startTime = System.nanoTime()
    runBlocking {
        // this: CoroutineScope
        printThreadId("coroutineScope-runBlocking ThreadId：")

        launch {
            printThreadId("launch ThreadId：")

            delay(200L)
            printDuration(startTime)

            println("Task from runBlocking -> 2")
        }

        coroutineScope {
            // 创建一个协程作用域
            printThreadId("coroutineScope ThreadId：")

            launch {
                printThreadId("coroutineScope->launch ThreadId")
                delay(500L)
                printDuration(startTime)
                println("Task from nested launch ->3 ")
            }

            delay(100L)
            printDuration(startTime)
            println("Task from coroutine scope -> 1") // 这一行会在内嵌 launch 之前输出
        }
        printDuration(startTime)
        println("Coroutine scope is over ->4") // 这一行在内嵌 launch 执行完毕后才输出
    }
}


fun startManyCoroutine() = runBlocking {
    repeat(100_000) { // 启动大量的协程
        println(getAllThreadSize())
        println(getAllThreadStackTrace())
        printThreadId("repeat")
        launch {
            printThreadId("launch")
            delay(10000L)
            println(getThreadId().toString()+" .")
        }
    }
}

fun getDuration(startNanoTime: Long) = (System.nanoTime() - startNanoTime) / 1000000
fun printDuration(startNanoTime: Long) {
    println((System.nanoTime() - startNanoTime) / 1000000)
}
fun printThreadId(pre:String){
    println(pre+","+getThreadId())
}
fun getThreadId():Long{
    return Thread.currentThread().id
}