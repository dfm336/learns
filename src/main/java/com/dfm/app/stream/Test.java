package com.dfm.app.stream;

import com.dfm.app.fanxing.User;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:代奉明
 */
public class Test {
    public static void main(String[] args) {
//        Function<Integer,Integer> function1 = x -> x * 2 ;//+ "have doubled!";
//        System.out.println(function1.apply(4));

//        Integer[] arr = {1,3,4,6,-2,-4};
//        Consumer<String> consumer = x -> System.out.println(x);
//        Arrays.stream(arr).forEach(x-> {int a= x+2;
//            System.out.println(a);
//        });

        List<User>  users = Lists.newArrayList();
        User dfm = new User(12, "dfm", null);
        User xxx = new User(12, "xxx", null);
        User qlx = new User(12, "qlx", null);
        User hxh = new User(13, "hxh", null);
        users.add(dfm);
        users.add(xxx);
        users.add(qlx);
        users.add(hxh);

        Optional<User> qqq = users.stream().filter(item -> item.getName().equals("qqq")).findFirst();
//        System.out.println("user = " + user);

    }

}
