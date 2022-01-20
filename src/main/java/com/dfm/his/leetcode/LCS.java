package com.dfm.his.leetcode;

import java.util.Arrays;

/**
 * @author dfm
 * @create 2020-10-26 12:50
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "bsbininm" ;
        String s2 = "jmjkbkjkv";
        System.out.println(longestCommonSubsequeue(s2,s1));
    }

    /**
     *    s1 = "ace"  se = "babcde"
     *     dp[i][i] 代表 s1的 0-i组成的字符串，跟 s2的0-j组成的字符串  中 的最长公共子序列
     *     一个字符串的 子序列 是指这样一个新的字符串：
     *     它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * @param s2
     * @param s1
     * @return
     */
    public static int longestCommonSubsequeue(String s2,String s1){
        if(s1.length() == 0 || s1 == null || s2.length()==0 || s2 == null)return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        s1 = "-"+s1;
        s2 = "-"+s2;
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            char t = s1.charAt(i);
            for(int j=1;j<=len2;j++){
                if(s2.charAt(j) == s1.charAt(i) ){
                   //由 两个字符串 去除 当前 找到。 i-1，j-1
                    dp[i][j] =  dp[i-1][j-1]+1;
                }else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); //  由 左边 和 上边 的最大值  转移而来。
            }
        }
        return dp[len1][len2];
    }


    public static int maxSubArray(int[] arr){
        if(arr == null)return 0;
        int len = arr.length;
        int[] dp  = new int[len];//dp[i]代表 以 arr的第i个字符结尾时，取得的 最大值。
        dp[0] = arr[0];//第0 个字符结尾时，前面没有其他元素，所以是 本身。
        for(int i=1;i<len;i++){
            //因为 dp[i]代表 以第i个字符结尾，所以 arr[i] 必须存在。不可以 选择dp[i-1]
            //dp[i] 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；
            // 要么不与前面的子数组连接，自成一派，自己作为一个子数组。
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
        }
        Arrays.sort(dp);
        return arr[len-1];
    }
}
