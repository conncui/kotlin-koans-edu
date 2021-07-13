package util

import java.lang.StringBuilder

fun getThreadId():Long{
    return Thread.currentThread().id
}
fun getThreadStackTrace():String{
    var stackTrace =Thread.currentThread().stackTrace
    return getStackTrace(stackTrace)
}
fun getAllThreadSize():Int{
    var allThreadStaceTrace = Thread.getAllStackTraces()
    return allThreadStaceTrace.size
}
fun getAllThreadStackTrace():String{
    var allThreadStaceTrace = Thread.getAllStackTraces()
    var allThreadStaceTraceSb = StringBuilder()
    allThreadStaceTraceSb.append("\n")
    allThreadStaceTraceSb.append("ThreadSize:").append(allThreadStaceTrace.size).append("\n")
    allThreadStaceTrace.entries.forEach {
        allThreadStaceTraceSb.append("Thread:").append(it.key.id)
        allThreadStaceTraceSb.append(" -- ")
        allThreadStaceTraceSb.append("StackTrace:").append(getStackTrace(it.value))
    }
    return allThreadStaceTraceSb.toString()
}
fun getStackTrace(stackTraceElementArr:Array<StackTraceElement>):String{
    var stackTraceSb = StringBuilder()
    var length = stackTraceElementArr.size
    if (length >=2){
        for(index in 0..length-2){
            stackTraceSb.append(stackTraceElementArr[index])
            stackTraceSb.append("\n")
        }
    }else if (length ==1 ){
        stackTraceSb.append(stackTraceElementArr[length-1])
    }else{
        stackTraceSb.append("None")

    }

    return stackTraceSb.toString()
}
