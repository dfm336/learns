package com.dfm.his.algorithm.sort;

/**
 * @author dfm
 * @create 2020-08-21 12:37
 */
public class Quick {
    public static void sort(int[] arr){
        int left = 0;
        int right = arr.length-1;
        quickSort(arr, left, right);
    }

    /**
     * 递归使 两个子数组  有序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left,int right){
        if(left >=  right)return;
        // 对arr 数组中，从left到right之间的元素进行切分
        int mid = partion(arr,left,right);
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
    }

    public static void exchange(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 拆分数组，并有序
     * @param arr
     * @param left
     * @param right
     * @return  返回 分界 下标
     */
    public static int partion(int[] arr, int left, int right){
        //把 左边 第一个数 作为 比较基准 值
        int target = arr[left];
        int l = left;
        //避免 --r 越界 so +1
        int r = right+1;
        while (true){//可以退出的，不是死循环
            //找到第一个 比 target 小 or == 的值 r则记录下标
            while (arr[--r] > target){
                if(r == l)break;//搜索到了最左边
            }
            //找到第一个比target 大 or == 的值  l记录下标
            while( arr[++l] < target){
                if(l == r)break;
            }
            //循环结束
            if(l >= r)break;
            else {// 交换l r的值
                exchange(arr,l,r);
            }
        }
        //把基准值 放回中间， 跟r 换值
        exchange(arr,left,r);
        return r;
    }

}
