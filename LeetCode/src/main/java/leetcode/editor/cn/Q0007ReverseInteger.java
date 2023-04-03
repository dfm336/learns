package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-03-29 12:10:28 
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
// 👍 3795, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0007ReverseInteger().new Solution();
     int reverse = solution.reverse(1534236469);
     System.out.println("reverse = " + reverse);
 }

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
//        double min = Math.pow(-2, 31);
//        System.out.println("min = " + min);
//        double max = Math.pow(2, 31) - 1;
//        System.out.println("max = " + max);

        int minValue = Integer.MIN_VALUE;
//        System.out.println("minValue = " + minValue );

        int maxValue = Integer.MAX_VALUE;
//        System.out.println("maxValue = " + maxValue);

        int a = minValue / 10;
        System.out.println("a = " + a);
        int ta = minValue % 10;
        System.out.println("ta = " + ta);

        int b = maxValue / 10;
        System.out.println("b = " + b);
        int tb = maxValue % 10;
        System.out.println("tb = " + tb);
        int res = 0;
        while ( x != 0 ){
            int tmp = x % 10;

            if ( res < minValue || ( res == a && tmp < ta) )return 0;
            if ( res > maxValue || ( res == b && tmp > tb) )return 0;

            res =  res * 10 + tmp;
           x /= 10;
        }
        return  res;
    }

     public int rever(int x) {
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