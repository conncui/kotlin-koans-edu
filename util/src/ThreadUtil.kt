package koans.util

import java.lang.StringBuilder

fun getStackTrace():String{
    var stackTrace = Thread.currentThread().stackTrace
    var sbStackTrace = StringBuilder()
    stackTrace.iterator().forEachRemaining {
        sbStackTrace.append(it.toString())
    }
    return sbStackTrace.toString()
}