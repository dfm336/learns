package com.dfm.app.algors.sort;

import java.util.Arrays;

/**
 * @Author:fengming.dai
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[] {9,4,6,8,3,10,4,6};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr,int low,int high){
        if (low > high){
            return;
        }
        int stander = arr[low];
        int i = low;
        int j = high;
        while (i < j){
            while (arr[j] >= stander && i < j){j--;};
            while (arr[i] <= stander && i < j){i++;};
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[low] = arr[i];
        arr[i] = stander;
        sort(arr,low,j-1);
        sort(arr,j+1,high);
    }
    public static void quickSort(int[] arr,int low,int high) {
        int p,i,j,temp;

        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort(arr,low,j-1);  //对左边快排
        quickSort(arr,j+1,high); //对右边快排

    }

    private void qkSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            qkSort(src, begin, i - 1);
            qkSort(src, i + 1, end);
        }
    }


}
