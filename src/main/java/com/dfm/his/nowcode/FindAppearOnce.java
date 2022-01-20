package com.dfm.his.nowcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dfm
 * @create 2020-09-29 10:48
 */
public class FindAppearOnce {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,1,4,4,6,7};
        Integer[] res = solution(arr);
        Arrays.stream(res).forEach(x-> System.out.println(x));
    }

    private static Integer[] solution(Integer[] arr) {
        int ans = 0;
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                ans = arr[i] ^ arr[j];
                if(ans == 0){
                    arr[i] = 0;
                    arr[j] = 0;
                }
            }
//            ans ^= arr[i];
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> rs = Arrays.stream(arr).filter(x->x!=0).collect(Collectors.toList());
        Integer[] re = new Integer[2];
        rs.toArray(re);
//        int[] rs = new int[]{ans};
        return re;
    }
}
