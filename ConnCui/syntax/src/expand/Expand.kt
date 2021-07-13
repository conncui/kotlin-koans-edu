data class Person constructor( var name: String ,var age :Int)

fun getPeople(): List<Person> {
    return listOf(Person(name = "Alice", age = 29), Person(name = "Bob", age = 31))
}


class Example {
    var name = "11111"
    fun printFunctionType() { println("Class method") }
}

fun Example.printFunctionType() { println("Extension function") }

fun String.lastChar(): Char = this.get(this.length - 1)
fun Example.lastChar(): String {
    print(this.javaClass.toString())
    return this.name
}

fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    var example = Example()
    example.name = "123"
    println(example.lastChar())
    println("Kotlin".lastChar())
}
fun Int.add(): Int{
    return  this + 1
}
