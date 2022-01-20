package com.dfm.his.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 * @author dfm
 * @create 2020-09-11 15:55
 */
public class LongestCommonPrefix {
    public static String solution(String[] strs){
        if(strs.length == 0 )return "";
        int n = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            n = (strs[i].length() < n) ? strs[i].length() : n;
        }
        String ans = "";
        for(int i=0;i<n;i++){
            //取第一个的 第i个 字符
            char t = strs[0].charAt(i);
            //把每个 字符串的  同一个位置拿出来比较。有一个不同就返回。
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i) !=  t )return ans;
            }
            ans += t;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str[] = {"abb","abc"};
        String solution = solution(str);
        System.out.println(solution);
    }
}
