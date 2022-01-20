package com.dfm.his.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dfm
 * @create 2020-11-03 09:35
 */
public class ComplexSort {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User(1, 172, 0);
        User user2 = new User(2, 175, 1);
        User user3 = new User(3, 165, 0);
        User user4 = new User(4, 180, 1);
        User user5 = new User(5, 175, 1);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        Collections.sort(list,(o1,o2)->{
            if (o1.sex != o2.sex)return o1.sex-o2.sex;
            else if(o1.high != o2.high)return o1.high-o2.high;
            else return o1.id - o2.id;
        });
        list.forEach(x-> System.out.println(x.id));
    }
}
class User{
    int id;
    int high;
    int sex;

    public User(int i, int i1, int i2) {
        id= i;
        high = i1;
        sex = i2;
    }
}