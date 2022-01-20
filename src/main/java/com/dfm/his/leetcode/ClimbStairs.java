package com.dfm.his.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author dfm
 * @create 2020-09-08 16:10
 */
public class ClimbStairs {
    public static int solution(int n){
        if(n==1)return 1;
        if(n == 2) return 2;
        //如果有缓存 则可以 定义在外面 先检查缓存
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = solution(1);
        System.out.println(ans);
    }
}
