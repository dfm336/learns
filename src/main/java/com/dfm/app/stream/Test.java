package com.dfm.app.stream;

import com.dfm.app.fanxing.User;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;
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
        List<Long> list = Lists.newArrayList(1L,2L,11L,11L,44L,44L,56L,100L,100L);
        getDuplicateList(new ArrayList<>());

    }

    public static void op(){
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



    /**
     * 获取 重复的  结算主体id
     * @param list
     * @return
     */
    public static Set<Long> getDuplicateList(List<Long> list) {
        Set<Long> set = new HashSet<>();
        if ( CollectionUtils.isEmpty( list )){
            return set;
        }
        set = list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) //过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toSet());// 转化为 List
        set.forEach(System.out::println);
        return set;
    }

}
