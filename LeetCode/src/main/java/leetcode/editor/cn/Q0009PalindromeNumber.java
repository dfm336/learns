package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-09 21:55:59 
 */
 public class Q0009PalindromeNumber{
 //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics数学 
//
// 👍 2403, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0009PalindromeNumber().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        return funByToStr(x);
    }

     private boolean funByToStr(int x) {
         String str = String.valueOf(x);
         int len = str.length();
         for (int i = 0, j = len -1; i < j ; --j, ++i){
             if (str.charAt(i) != str.charAt(j)){
                 return false;
             }
         }
         return true;
     }
 }
//leetcode submit region end(Prohibit modification and deletion)

 }