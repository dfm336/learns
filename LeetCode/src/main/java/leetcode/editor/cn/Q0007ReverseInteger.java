package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-09 22:12:22 
 */
 public class Q0007ReverseInteger{
 //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
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
// Related Topics数学 
//
// 👍 3752, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0007ReverseInteger().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
 class Solution {
     public int reverse(int x) {
         int res = 0;
         while(x!=0) {
             //每次取末尾数字
             int tmp = x%10;
             //判断是否 大于 最大32位整数
             if (res>214748364 || (res==214748364 && tmp>7)) {
                 return 0;
             }
             //判断是否 小于 最小32位整数
             if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                 return 0;
             }
             res = res*10 + tmp;
             x /= 10;
         }
         return res;
     }
 }

//leetcode submit region end(Prohibit modification and deletion)

 }