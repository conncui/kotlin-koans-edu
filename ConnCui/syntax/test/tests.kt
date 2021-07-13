import org.junit.Test
import org.junit.Assert


class TestDataClasses {
    @Test fun testListOfPeople() {
        println( getPeople().toString())
        var e = Example()
        e.printFunctionType()
        println(4.add())

        Assert.assertEquals("[Person(name=Alice, age=29), Person(name=Bob, age=31)]", getPeople().toString())
    }
}