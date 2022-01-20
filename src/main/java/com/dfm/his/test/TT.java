package com.dfm.his.test;

import com.dfm.his.algorithm.sort.Quick;

/**
 * @author dfm
 * @create 2020-10-29 20:29
 */
public class TT {
    public static void main(String[] args) {
        int[] arr= new int[]{1,4,-3,49,20,29,200};
        int[] bak= new int[]{1,4,-3,49,20,29,200};
        quick(arr,0,arr.length-1);
        for(int t:arr){
            System.out.print(t+" ");
        }
        System.out.println();
        Quick quick = new Quick();
        quick.sort(bak);
        for(int t:bak){
            System.out.print(t+" ");
        }
//        Arrays.asList(arr).forEach(x-> System.out.println(x));
    }

    private static void quick(int[] arr,int left ,int right) {
        if(left < right){
            int mid = partion(arr,left,right);
            quick(arr,left,mid -1);
            quick(arr,mid+1,right);
        }else return;
    }

    private static int partion(int[] arr, int left, int right) {
        int target = arr[left];
        int l = left;
        int r = right+1;
        while (true){

            while (arr[--r] > target) {
                if(r == l)break;
            }
            while (arr[++l] < target){
                if(l == r)break;
            }

            if(l < r){
                int t =arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }else break;
        }
        int t = arr[left];
        arr[left] = arr[r];
        arr[r] = t;
        return  r;
    }
}
