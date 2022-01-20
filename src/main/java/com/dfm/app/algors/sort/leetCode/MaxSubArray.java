package com.dfm.app.algors.sort.leetCode;

/**
 * @Author:fengming.dai
 */
public class MaxSubArray {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     * https://leetcode-cn.com/problems/maximum-subarray/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        //dp[i]  以第i个数字结尾的 最大子数组  和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
        }
        int max = -99999;
        for (int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
