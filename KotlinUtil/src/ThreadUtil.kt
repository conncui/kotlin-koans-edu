package koans.util

import java.lang.StringBuilder

fun getStackTrace():String{
    var stackTrace = Thread.currentThread().stackTrace
    var stackTraceSb = StringBuilder()

    var length = stackTraceSb.length
    for(index in 0..length-2){
        stackTraceSb.append(stackTraceSb[index])
        stackTraceSb.append("\n")
    }
    stackTraceSb.append(stackTraceSb[length-1])
    return stackTraceSb.toString()
}