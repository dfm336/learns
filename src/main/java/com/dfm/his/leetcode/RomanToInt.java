package com.dfm.his.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dfm
 * @create 2020-09-06 11:01
 */
public class RomanToInt {
    public static int solution(String str){
        char[] s = str.toCharArray();
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        Integer sum = 0;
        for(int i=0;i<s.length;i++){
            if(i+1 >= s.length){
                sum += map.get(s[i]);
                break;
            }
            if(map.get(s[i]) >= map.get(s[i+1])){
//                sum += ( map.get(s[i]) + map.get(s[i+1]) );
                sum += map.get(s[i]);
            }else{ // if(map.get(s[i]) < map.get(s[i+1]){
//                sum += (map.get(s[i+1]) - map.get(s[i]));
                sum -=  map.get(s[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "DCXXI";
        System.out.println(solution(s));
    }
}
