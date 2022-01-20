package com.dfm.app.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author:代奉明
 */
public class Test {
    public static void main(String[] args) {
//        Function<Integer,Integer> function1 = x -> x * 2 ;//+ "have doubled!";
//        System.out.println(function1.apply(4));

        Integer[] arr = {1,3,4,6,-2,-4};
        Consumer<String> consumer = x -> System.out.println(x);
        Arrays.stream(arr).forEach(x-> {int a= x+2;
            System.out.println(a);
        });

    }

}
