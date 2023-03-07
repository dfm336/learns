package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author  fengming.dai 
 * @date    2023-03-02 19:42:13 
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
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics哈希表 | 字符串 | 滑动窗口 
//
// 👍 8793, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0003LongestSubstringWithoutRepeatingCharacters().new Solution();
     int i = solution.lengthOfLongestSubstring("bbbbb");
     System.out.println("i = " + i);
 }

 /**
  *
  */
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        if ( s == null || s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int max = 0;
        //记录 窗口内 元素 个数
        Map<Character,Integer> window = new HashMap<>();
        while ( right < s.length() ){
            char cur = s.charAt(right);
            //加入窗口
            Integer cnt = window.get(cur);
            if ( cnt == null){
                window.put(cur,1);
            }else {
                window.put(cur,cnt+1);
            }

            right++;

            //当前 元素 加入后，是否 是重复 数据
            while ( window.get(cur) > 1 ){
                //伸缩 窗口， 把 左边移出去。
                char l = s.charAt(left);
                window.put(l,window.get(l)-1);
                left++;
            }
            max = Math.max(max,right - left);

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }