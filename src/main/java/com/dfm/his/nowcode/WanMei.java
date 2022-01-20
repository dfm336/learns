package com.dfm.his.nowcode;

import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-09-23 16:29
 */
public class WanMei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        MaxNumber(arr);
    }

    private static void MaxNumber(int[] arr) {
        int n = arr.length;
        int begin =0;
        int end = 0;
        int min = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t = Math.max(min,Math.abs(arr[i] - arr[j]));
                if(t != min){
                    min =t;
                    begin = i;
                    end =j;
                }
            }
        }
        System.out.println(begin+" "+end);
    }
}
