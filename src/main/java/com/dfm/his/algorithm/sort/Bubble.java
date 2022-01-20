package com.dfm.his.algorithm.sort;



/**
 * 冒泡排序
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素
 * 就是最大值。
 * @author dfm
 * @create 2020-08-20 15:31
 */
public class Bubble {
    public static void sort(int[] arr){
        //每次冒泡把最大值 移动到最后，一共只需要arr.lenth - 1 -1 +1 次。最后一次不需要  所以内循环 j<i
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                //注意数组越界，j不能渠道 arr.lenth-1。j<i
                if(arr[j] > arr[j+1]){
                    //交换 j  j+1
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

