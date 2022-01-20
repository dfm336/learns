package com.dfm.his.leetcode;

import java.util.HashMap;

/**
 * 滑动窗口
 * 无重复最小子串长度
 * 利用map key：字符   value：下标
 * @author dfm
 * @create 2020-08-17 14:16
 */
public class LenthOfLongestSubstring {
    public static void main(String[] args) {
        String testStr = "abcabcbb";
        int solution = solution(testStr);
        System.out.println(solution);
    }
    public static int solution(String str){
        if(str.length() == 0)return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        Integer max = 0;
        Integer left =0;
        for(int i=0;i<str.length();i++){
            //存在重复值，更新left的位置，从出现重复的位置开始往后
            if(map.containsKey(str.charAt(i))){
                //更新滑动窗口 left后移一位。去除
                left = Math.max(left,map.get(str.charAt(i))+1);
            }
            map.put(str.charAt(i),i);
            max = Math.max(max,i-left+1);
         }
        return max;
    }
}
