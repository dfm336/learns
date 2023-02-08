package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-02-07 16:58:06 
 */
 public class Q0022GenerateParentheses{
 //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 3053 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0022GenerateParentheses().new Solution();
     List<String> list = solution.generateParenthesis(3);
     list.forEach(System.out::println);
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }