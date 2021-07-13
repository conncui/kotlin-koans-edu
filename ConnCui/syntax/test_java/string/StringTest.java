package string;

import org.junit.Test;

public class StringTest {

    @Test
    public void strLength() {
        String str1 = "Hi 滑雪";
        System.out.println(str1.length());
        str1 = "滑";
        System.out.println(str1.length());

        System.out.println((int)str1.charAt(0));
        System.out.println((int)str1.charAt(1));

        str1 = "$";
        System.out.println(str1.length());
        str1 = "🎵";
        System.out.println(str1.length());
        str1 = "🌧";
        System.out.println(str1.length());
        str1 = "🌧";
        System.out.println((int)str1.charAt(0));
        System.out.println((int)str1.charAt(1));
    }
}
