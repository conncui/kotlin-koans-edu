package feild

data class Person(var name:String){
    companion object{
        var species:String = "Human"
    }
}

fun main(){
    var person = Person("Jhon")
    println(person.name)
    println(Person.species)
}