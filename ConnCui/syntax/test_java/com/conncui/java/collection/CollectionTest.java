package com.conncui.java.collection;


import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * Created by cui on 17-5-4.
 */

public class CollectionTest {
    @Test
    public void testCollection(){


        /** keyword: Collections.singletonList
         * draw.io/AndroidPrinciple.html/Java
         * */
        String str1 = "str1";
        List<String> stringList = Collections.singletonList(str1);
        stringList.add("str2");
        System.out.println(stringList);
    }

}
