package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 示例：
 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 * @author dfm
 * @create 2020-09-15 09:53
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
         List<String> res = solution(4);
         res.forEach(x-> System.out.println(x));
    }

    private static List<String> solution(int n) {
        if(n == 0)return null;
        List<String> ans = new ArrayList<>();
        String str = "";
        dfs(ans,str,0,0,n );
        return ans;
    }

    /**
     *
     * @param ans  返回结果
     * @param str  当前String
     * @param left   已经使用的 （  数量
     * @param right  已经使用的 ） 数量
     */
    private static void dfs(List<String> ans, String str, int left, int right,int n) {
        if(left == n && right == n ){
            ans.add(str);
            return;
        }
        //剪枝
        if(left < right)return;

        if(left < n){
            dfs(ans,str+"(",left+1,right,n);
        }
        if (right < n){
            dfs(ans,str+")",left,right+1,n);
        }

    }
}
