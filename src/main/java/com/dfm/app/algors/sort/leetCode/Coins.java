package com.dfm.app.algors.sort.leetCode;

/**
 * 凑硬币问题
 * @Author:fengming.dai
 */
public class Coins {
    /**
     * 零钱兑换，零钱个数不限
     * https://leetcode-cn.com/problems/coin-change/
     * @param coins  金额数组
     * @param amount 目标金额
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return dp(coins,amount,dp);
    }

    /**
     * dp[n] 含义：  凑齐  n
     * @param coins
     * @param amount
     * @param dp
     * @return
     */
    public int dp(int[] coins, int amount, int[] dp){
        //base case
        if (amount == 0){
            return 0;
        }
        if (amount < 0){
            return -1;
        }
        //先查备忘录
        if (dp[amount] != 0){
            return dp[amount];
        }

        Integer res = Integer.MAX_VALUE;

        for (int i=0;i<coins.length;i++){
            int sub = dp(coins,amount-coins[i],dp);
            if (sub == -1){
                continue;
            }
            res = Math.min(res,sub+1);

        }

        //放入dp
        dp[amount] = (res == Integer.MAX_VALUE) ?  -1 : res;
        return dp[amount];
    }
}
