package com.dfm.app.algors.sort.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口系列
 * @Author:fengming.dai
 */
public class SlipWindow {
    /**
     * SlipWindow 模板
     * window 窗口内容计数器
     * need 需要进入窗口的内容 计数器
     * valid 判断是否符合条件计数器  valid == need.size
     *
     * @param source 源字符串
     * @param target 目标字符串
     */
    void template(String source, String target){
        Map<Character,Integer> need  = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        //初始化 need计数器
        for (int i = 0; i < target.length(); i++){
            if (need.containsKey(target.charAt(i))){
                Integer curNumber = need.get(target.charAt(i));
                need.put(target.charAt(i),curNumber + 1);
            }else {
                need.put(target.charAt(i),1);
            }
        }
        //初始化窗口 left = right = 0
        int left = 0;
        int right = 0;
        //符合need 元素条件个数  计数器（符合一个 元素 统计则  valid +1）
        int valid = 0;

        while (right < source.length()){
            //当前处理的 字符,将要 移入窗口的字符
            char c = source.charAt(right);

            right++;
            //窗口一系列数据处理

            //debug left,right的位置
            System.out.println("left = "+left + "----right:"+right);

//            //判断left 是否要更新
//            while (){
//                //这是要 移出 窗口的 字符
//                char remove = source.charAt(left);
//                left++;
//                //....窗口数据更新
//            }
        }
    }

    /**
     * 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * https://leetcode-cn.com/problems/minimum-window-substring/
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        for (int i=0;i<t.length();i++){
            if (need.containsKey(t.charAt(i))){
                Integer curNum = need.get(t.charAt(i));
                need.put(t.charAt(i),curNum+1);
            }else {
                need.put(t.charAt(i),1);
            }
            //窗口内  初始化为 0
            window.put(t.charAt(i),0);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        //返回应该截取的  start 下标
        int start = 0;
        //应该截取的 字符串长度
        int len = Integer.MAX_VALUE;
        while (right < s.length()){
            char add = s.charAt(right);
            right++;
            //更新 window 计数器
            if (need.containsKey(add)){
                Integer cur = window.get(add);
                window.put(add,cur+1);
                if (need.get(add).equals(cur+1)){
                    valid++;
                }
            }
            //符合条件,应该缩小窗口，更新left
            while (valid == need.size()){
                //求 最小区间，更新 start，和 len
                if (right - left < len){
                    start = left;
                    len = right - left;//因为 righ 已经+1，了，所以长度 不需要 +1
                }
                char remove = s.charAt(left);
                left++;
                if (need.containsKey(remove)){
                    Integer cur = window.get(remove);
                    window.put(remove,cur-1);
                    //移除之后 数量不符合 need 则 减少一个 条件计数
                    if ( need.get(remove) > (cur-1)){
                        valid--;
                    }
                }
            }
        }
        return  Integer.MAX_VALUE == len ? "" : s.substring(start,start+len);
    }


}
