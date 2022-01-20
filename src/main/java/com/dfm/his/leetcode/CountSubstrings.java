package com.dfm.his.leetcode;


/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * @author dfm
 * @create 2020-08-19 11:01
 */
public class CountSubstrings {

    public static  int solution(String s){
        if(s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[][] dp =  new boolean[len][len];
        //初始化 dp
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(str[i] != str[j]){
                    dp[i][j] = false;
//                    dp[j][i] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
//                        dp[j][i] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
//                        dp[j][i] = dp[i][j];
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j])count++;
            }
        }
        return  count;
    }
    public static void main(String[] args) {
        String testStr = "abc";
        int result = solution(testStr);
        System.out.println(result);
    }
}
