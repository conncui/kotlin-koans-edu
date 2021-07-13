package keyword

enum class DataType(val rgb: Int) {
    U8(0),
    Int8(1),
    Int16(2),
    Uint16(3),
    UInt32(4),
    Float16(5),
    Float32(6),
    Double(7)
}

fun main() {
    println("print when null } ")
    println(DataType.valueOf("U8"))
}
