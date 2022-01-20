package com.dfm.app.algors.sort.leetCode;

/**
 * @Author:fengming.dai
 */
public class LCS {
    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 == 0 || len2 == 0){
            return 0;
        }
        //dp[i][j] 定义：  text1中 0~i 与 text2 中 0~j 中 lcs 长度
        int[][] dp = new int[len1+1][len2+1];
        //base case 初始化都为 0

        for (int i=1;i<=len1;i++){
            for (int j=1; j <= len2;j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
