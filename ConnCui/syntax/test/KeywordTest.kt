import org.junit.Assert
import org.junit.Test

class KeywordTest {
    @Test
    fun testTakeIf_1() {
        var str1 = "1"
        str1.takeIf {
           true
        }
    }

    @Test
    fun testTakeIf_2() {
        var str1 = "1"
        str1.takeIf {
            true
        }?.get(0)
    }
}