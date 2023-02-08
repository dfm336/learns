package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author  fengming.dai 
 * @date    2023-02-07 16:46:14 
 */
 public class Q0020ValidParentheses{
 //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3715 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0020ValidParentheses().new Solution();
 	String Str = "(]";
     boolean valid = solution.isValid(Str);
     System.out.println("valid = " + valid);
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '{' || charAt == '(' || charAt == '['){
                stack.push(charAt);
            }else {
                //peak 获取栈顶元素，不出栈
                Character peek = stack.peek();
                //注意  需要 检验 栈顶 元素 匹配 才 出栈
                if ( charge(charAt,peek)){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

     private boolean charge(char right, Character left) {
        if (right == '}' && left.equals('{')) return true;
        else if (right == ')' && left.equals('(')) return true;
        else if (right == ']' && left.equals('[')) return true;
        return false;
     }
 }
//leetcode submit region end(Prohibit modification and deletion)

 }