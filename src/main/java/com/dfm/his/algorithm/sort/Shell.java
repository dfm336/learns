package com.dfm.his.algorithm.sort;

/**
 *      希尔排序  思想跟插入排序类似，  多了一个增长量 h
 *1. 选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
 * 2. 对分好组的每一组数据完成插入排序；
 * 3. 减小增长量，最小减为1，重复第二步操作。
 * @author dfm
 * @create 2020-08-20 16:53
 */
public class Shell {
    public static void sort(int[] arr){
        int n = arr.length;
        //计算h
        int h = 1;
        while (h < n/2){
            h = 2 * h + 1;
        }
        // h 小于1  就停止排序
        while (h >= 1){
            for(int i = h; i < n ; i++){
                for(int j = i; j >= h; j-=h){
                    //arr[j]就是要插入的元素，每次以间隔h 跟前面 拍好序的元素进行比较
                    if(arr[j] < arr[j-h]){
                        int temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    }else break;
                }
            }
            h /= 2 ;
        }

    }
}

