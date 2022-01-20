package com.dfm.his.nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dfm
 * @create 2020-11-29 18:46
 */
public class TongDun {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 22, 33, 44, 55, 66, 88, 77, 3, 9, 999, 10000, 3456};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        ArrayList<Integer> res = top10(list);
        res.forEach(x-> System.out.println(x));
    }
    /**
     * 1.将1000w 个元素 分治 为 1000个堆
     * 2.对1000个堆 建造大顶堆，进行堆排序
     * 3.对1000个堆排序 进行归并 取前top10
     *
     *
     *
     * @param input
     * @return
     */
    public  static  ArrayList<Integer> top10 (ArrayList<Integer> input) {
        // write code here
        if(input == null)return null;
        Collections.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=input.size()-10;i<input.size();i++){
            res.add(input.get(i));
        }
        return res;
    }
}
