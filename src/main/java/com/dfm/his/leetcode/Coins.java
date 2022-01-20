package com.dfm.his.leetcode;


import java.util.Arrays;
import java.util.List;

/**
 * @author dfm
 * @create 2020-09-21 14:46
 */
public class Coins {

    public static int culateDP(int[] arr,int target,int[] dp){
        if(target == 0)return 0;//dp[0] = 0;
        if(target < 0)return -1;
        //先查备忘录有没有
        if(dp[target] != 0)return dp[target];
        int res = Integer.MAX_VALUE;//初始化最小值，方便找到dp[n-coin]的最小值
        for(int i=arr.length-1;i>=0;i--){//做了升序处理，倒序遍历更快出结果
            int subDP =0;
            subDP = culateDP(arr, target - arr[i], dp);
            if(target - arr[i] >= 0) subDP=dp[target - arr[i]];
            if(subDP == -1)continue;//无解，继续循环
            res = Math.min(subDP+1,res);
        }
        dp[target] = (res == Integer.MAX_VALUE) ? -1 : res;
        return  dp[target];
    }
    /**
     * 动态规划
     * dp[n] = value  凑出值为n，最少需要value个硬币
     * dp[0] = 0;
     * dp[n] = dp[n-coin]+1 conin为arry中面值,+1加上当前使用的这一枚
     * @param arr 硬币面值
     * @param target 要凑的目标值
     * @return
     */
    public static int solution(int[] arr,int target){
        Arrays.sort(arr);
        //最小值 都 > target 肯定无法凑出
        if(arr[0] > target)return -1;
        int[] dp = new int[target+1];
        int result = culateDP(arr, target, dp);
        return result;
    }

    /**
     *
     * @param arr 面值数组
     * @param target 要凑的目标值
     * @return
     */
    public static int allSolutionNum(int[] arr, int target){
        int n = arr.length;
        int[] dp  = new int[target+1];
        dp[0] = 1;
        for(int i=0;i<n;++i){
            int coin = arr[i];
            for(int j=coin; j<=target; ++j){
                dp[j] = (dp[j] + dp[j-coin]) % 1000000007;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{25,10,5,1};
        int result = allSolutionNum(arr, 10);
        System.out.println(result);
        int solution = waysToChange( 10);
        int count =0;
        System.out.println(solution);
    }
    static final int MOD = 1000000007;
    static int[] coins = {25, 10, 5, 1};

    public static int waysToChange(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % MOD;
            }
        }
        return f[n];
    }
}
