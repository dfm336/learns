package com.dfm.his.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dfm
 * @create 2020-09-11 09:08
 */
public class NumberOf2sInRange {
    public static int solution(int n){
        if(n<2){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            String str = String.valueOf(i);
            int count =0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(i) == '2')count++;
            }
            dp[i] = dp[i-1] + count;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(559366752));
    }
}
