package com.dfm.his.leetcode;

/**
 * @author dfm
 * @create 2020-11-16 10:27
 */
public class TraillingZeros {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }

    /*
    首先，两个数相乘结果末尾有 0，一定是因为两个数中有因子 2 和 5，因为 10 = 2 x 5。
也就是说，问题转化为：n! 最多可以分解出多少个因子 2 和 5？

因为每个偶数都能分解出因子 2，因子 2 肯定比因子 5 多得多。

25! 中 5 可以提供一个，10 可以提供一个，15 可以提供一个，20 可以提供一个，25 可以提供两个，
总共有 6 个因子 5，所以 25! 的结果末尾就有 6 个 0。



    给定一个整数 n，返回 n! 结果尾数中零的数量。
     输入: 5
    输出: 1
    解释: 5! = 120, 尾数中有 1 个零.
     */
    public  static int solution(int n){
        int res = 0;
        long div = n;
        while (div != 0){
            res += div/5;
            div  /= 5;
        }
        return res;
    }
}
