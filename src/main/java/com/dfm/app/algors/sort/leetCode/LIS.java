package com.dfm.app.algors.sort.leetCode;

import java.util.Arrays;

/**
 * @Author:fengming.dai
 */
public class LIS {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * dp[i] 代表 以第 i 个下标结尾 时， 严格递增子序列 长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //特判
        if (nums == null){
            return 0;
        }
        int[] dp = new int[nums.length];
        //base case
        Arrays.fill(dp,1);

        //求 dp[i]
        for (int i=0; i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        //求 max
        int max = 0;

        for (int i=0; i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;

    }
}
