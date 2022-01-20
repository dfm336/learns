package com.dfm.his.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-08-30 13:02
 */
public class ReverseArray {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[]arr = new int[n];
        int[] bak = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = cin.nextInt();
            bak[i] = arr[i];
        }
        exchange(bak,0,1);
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=0;i<n;i++){
            System.out.print(bak[i]+" ");
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                exchange(arr,i,j);
                if(isSorted(arr)){
                    System.out.println("yes");
                    return;
                }
            }
        }
        System.out.println("no");
    }
    public static boolean isSorted(int[] arr){
        int[] bak = new int[arr.length];
        Arrays.sort(arr);
        int i=0;
        while(arr[i++] == bak[i++]){
            if(i == arr.length)return true;
        }
        return false;
    }
    public static void exchange(int[] arr,int left, int right){
        for(int i=left,j=right;left < right;i++,j--){
            int t =arr[i];
            arr[i]=arr[j];
            arr[j]=t;
        }
    }
}


