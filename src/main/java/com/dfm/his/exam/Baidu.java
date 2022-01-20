package com.dfm.his.exam;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-10-12 18:50
 */
public class Baidu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();


        LinkedList<Integer> list = new LinkedList<>();

        boolean pAppear = false;
        int before = 0;
        int end = 0;
        for(int i=0;i<m;i++){
            int u = in.nextInt();
            pAppear = u == p ? true : false;
            before = u == p ? i : 0;
            int v = in.nextInt();
            pAppear = v == p ? true : false;
            end = v == p ? i : 0;
            if(!list.contains(u)){
                list.add(u);
            }
            if(!list.contains(v)){
                list.add(v);
            }
        }
        if(before != 0){
//            if(before != 0) System.out.println(before);

            for(int i=1;i<=before+1;i++){
                System.out.println(i+" ");
            }
        }
//        System.out.println(ans);
    }

    private static int leap(char[] arr, int n) {
        if(n==0 || n == 1 )return 0;
        if(arr[0] == arr[n-1])return 1;
        int[] dp = new int[n];
        dp[1] = 1;
//        dp[1] = 1;
        for(int i=2;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    dp[i] = Math.min(dp[i-1]+1,dp[j]+1);
                    break;
                }
            }
            if(dp[i] == 0)dp[i] = dp[i-1]+1;
        }
        return dp[n-1];
    }
}
