package com.dfm.his;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**java 8
 * stream使用
 * @author dfm
 * @create 2020-08-13 15:18
 */
public class code {


    public static void main(String[] args) {
        List<Integer> listInt = Arrays.asList(1,2, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4,3, 4, 5, 7, 8);
        Map<Integer, Integer> map = list2.stream()
                .distinct()
                .collect(
                        Collectors.toMap(x -> x, x -> x)//key == value
                );
        List<Integer> collect = listInt.stream()
                .filter((x) -> x.equals(map.get(x)))
                .collect(Collectors.toList());
        collect.forEach(System.out::print);
//                .forEach(System.out::print);


//        Stream.generate(() ->Math.round(Math.random() * 10)).limit(5).forEach(x-> System.out.println(x));
//        Stream<Integer> integerStream1 = Stream.of(1, 3, 4, 5, 6);
//        Arrays.stream(new int[]{2, 3, 4, 5, 7, 8});
//        Stream<Integer> stream = listInt.stream();//串行流
//        stream.filter(x-> x % 2 != 0)//符合的留下
//                .distinct()//通过流所所生成元素的hashCode()和equals()去除重复元素
//                .map( (x)->x*x)//接收Lambda，将元素转换为其他形式或提取信息时，接收一个函数作为参数，该函数被应用到每个元素上，并将其映射成一个新的元素
//                .sorted((o1,o2)->o2-o1)
//                .forEach(x-> System.out.println(x));
//
//        Stream<Integer> integerStream = listInt.parallelStream();//并行流
    }
}
