package leetcode.editor.cn;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  fengming.dai 
 * @date    2023-02-02 19:19:48 
 */
 public class Q0003LongestSubstringWithoutRepeatingCharacters{
 //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 8667 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0003LongestSubstringWithoutRepeatingCharacters().new Solution();
 	String str = "pwwkew";
     int length = solution.lengthOfLongestSubstring(str);
     System.out.println("length = " + length);
 }

    /**
     * 这里是使用滑动窗口方法解决此问题的方法：
     *
     * 使用两个指针，left 和 right，表示当前子串的开头和结尾。
     *
     * 使用哈希集来存储当前子串中的字符。
     *
     * 将right指针向右移动，直到当前字符已经在哈希集中。
     *
     * 当找到重复字符时，从哈希集中删除left指针指向的字符，并将left指针向右移动。
     *
     * 记录没有重复字符的最长子串的长度，循环结束后返回长度。
     */
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int length = s.length();

        //利用不可重复 记录  最长连续 子串
        Set<Character> set = new HashSet<>();
        while ( left < length && right < length){
            char cur = s.charAt(right);
            if (!set.contains(cur)){
                set.add(cur);
                right++;
                max = Math.max(max,right - left);
            }else {
                //存在 则， left 指针往后, 并把 这个 重复的 移除（因为 后面会把这个 重复的 加入）
                left++;
                set.remove(cur);
            }
        }

        return max;
    }


//        public int lsc(String s){
//            unordered_map<char, int> window;
//            int left = 0, right = 0;
//            int res = 0;// 记录结果
//            //
//            while (right < s.size()) {
//                char c = s[right];
//                right++; // 进行窗口内数据的一系列更新
//                window[c]++; // 判断左侧窗口是否要收缩
//                while (window[c] > 1) {
//                    char d = s[left];
//                }
//                left++; // 进行窗口内数据的一系列更新
//                window[d]--;
//            } // 在这里更新答案
//            res = max(res, right - left);
//            }
//            return res;
//        }
    }
 }