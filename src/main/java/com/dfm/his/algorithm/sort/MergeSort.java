package com.dfm.his.algorithm.sort;


/**
 * 归并排序
 * 归并排序是稳定排序，它也是一种十分高效的排序，能利用完全二叉树特性的排序一般性能都不会太差。
 * java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 * 每次合并操作的平均时间复杂度为O(n)，而完全二叉树的深度为|log2n|。总的平均时间复杂度为O(nlogn)。
 * 而且，归并排序的最好，最坏，平均时间复杂度均为O(nlogn)。
 * @author dfm
 * @create 2020-08-18 14:24
 */
public class MergeSort {

    /**
     * 合并两个 有序序列
     * @param arr 操作数组
     * @param left  左边界
     * @param right 右边界
     * @param temp  临时数组
     */
    public static  void merge(int[] arr,int left,int right,int[] temp){
        int mid = (left+right)/2;
        int pleft = left;
        int pright = mid+1;
        int count = 0;
        //是根据下标走的  需要  =
        while(pleft <= mid && pright <= right){
            if(arr[pleft] <= arr[pright]){
                temp[count++] = arr[pleft++];
            }else{
                temp[count++] = arr[pright++];
            }
        }
        //若 左边剩余
        while (pleft <= mid){
            temp[count++] = arr[pleft++];
        }
        //若右边剩余
        while (pright <= right){
            temp[count++] = arr[pright++];
        }
        //拷贝回arr原数组
        count =0;
        while (left <= right){
            arr[left++] = temp[count++];
        }

    }

    //做归并排序
    public static void sort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,right,temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 27, 19, 105, 0, 12, 2, 8, 30, 89};
        int left = 0;
        int right = arr.length-1;
        //不放入递归 避免多次开辟空间
        int[] temp = new int[arr.length];
        sort(arr,left,right,temp);
        for (int i:arr
             ) {
            System.out.print(i+"\t");
        }
    }
}
