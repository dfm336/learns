package com.dfm.his.algorithm.sort;

/**
 * 插入排序
 * 1.把所有的元素分为两组，已经排序的和未排序的；
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，
 * 那么就把待插入元素放到这个位置，其他的元素向后移动一位；
 * @author dfm
 * @create 2020-08-20 16:18
 */
public class Insertion {
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            //倒叙遍历已经排序的元素 i-1避免越界，i不能 =0
            for(int j=i; j>0;j--){
                //找到第一个 ＜ 待插入元素arr[j] 刚进入内循环，第一个j=i;
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
