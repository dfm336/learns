package com.dfm.his.nowcode;

/**
 * 背包问题
 * @author dfm
 * @create 2020-09-30 16:43
 */
public class Package {
    /**
     * 01背包。
     * dp[i][j] 表示 前i件物品，重量为j，能放入背包 的最大 价值。
     * @param weight
     * @param value
     * @return
     */
    public static int solution(int[] weight,int[] value,int maxWeight){
        int n = weight.length;
        int[][] dp = new int[n+1][maxWeight+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWeight;j++){
                //滴i个物品的  重量 > j当前能取的最大重量
                if(j < weight[i]) dp[i][j] = dp[i-1][j];
                else {
                    //找到上一个没有放入第 i 个物品时，最大价值。
                    int get = dp[i-1][j-weight[i]]+value[i];
                    //不拿取上一个 没有放入第 i 个物品时，最大价值
                    int cancel = dp[i-1][j];
                    dp[i][j] = Math.max(get,cancel);
                }
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1,2,3,4};
        int[] v = new int[]{2,5,3,2};
        int maxW = 5;
        int solution = solution(w, v, maxW);
        System.out.println(solution);
    }
}
