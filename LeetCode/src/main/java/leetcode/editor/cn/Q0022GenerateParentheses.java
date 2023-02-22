package leetcode.editor.cn;

import org.luaj.vm2.ast.Str;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author  fengming.dai 
 * @date    2023-02-22 15:47:44 
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
//
// Related Topics字符串 | 动态规划 | 回溯 
//
// 👍 3090, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0022GenerateParentheses().new Solution();
     List<String> list = solution.generateParenthesis(3);
     list.forEach(System.out::println);
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        backTracePruning(0,0,new StringBuilder(), n);
        return res;
    }

    List<String> res = new LinkedList<>();
     /**
      *  1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
      *
      * 2、对于一个「合法」的括号字符串组合 p，必然对于任何  0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
      *
      * 因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。
      *
      * 用 left 记录还可以使用多少个左括号，用 right 记录还可以使用多少个右括号，就可以直接套用 回溯算法套路框架 了。
      * @param left  已经使用的 左括号 数量
      * @param right 已经使用的 右括号 数量
      * @param track
      */
    public void backTracePruning(int left, int right, StringBuilder track,int n){
        if (left == n && right == n ){
            res.add( new String(track) );
            return;
        }
        //超过使用个数了 不合法
        if (left > n || right > n) return;
        // 子串中 左括号 比右括号 少，不合法
        if ( left < right) return;

        //选择列表 就两个， "（", ")"

        track.append("(");
        backTracePruning(left + 1,right,track, n);
        track.deleteCharAt(track.length()- 1);

        track.append(")");
        backTracePruning(left, right + 1, track, n);
        track.deleteCharAt(track.length() - 1);

    }


     /**
      * 笨方法
      * 1.回溯列出所有
      * 2. 遍历 留下 有效的
      * @param n
      * @return
      */
     public List<String> stupid(int n) {
        char[] choose = new char[2*n];
         for (int i = 0; i < 2 * n; ) {
             choose[i++] = '(';
             choose[i++] = ')';
         }

         boolean[] visit = new boolean[choose.length];
         LinkedList<Character> track = new LinkedList<>();
         backTrace(choose,visit, track);

         List<String> res = new ArrayList<>();
         for (int i = 0; i < all.size(); i++) {
             boolean effective = chargeEffective(all.get(i));
             if (effective){
                 String str = "";
                 for (int i1 = 0; i1 < all.get(i).size(); i1++) {
                     str += all.get(i).get(i1);
                 }
                 res.add(str);
             }
         }
         return res;
     }

     /**
      * 判断 字符序列 是否是 有效括号
      * @param characters
      * @return
      */
     private boolean chargeEffective(List<Character> characters) {
         Stack<Character> stack = new Stack<>();
         for (int i = 0; i < characters.size(); i++) {
             Character character = characters.get(i);
             if ( character == '('){
                 stack.push(character);
             }else if (!stack.isEmpty() && stack.peek() == '('){
                 stack.pop();
             }
         }
         return stack.isEmpty();
     }

     public List<List<Character>> all = new ArrayList<>();
     public void backTrace(char[] choose, boolean[] visit, LinkedList<Character> trace){
         if ( choose.length == trace.size() && !all.contains(trace)){
             all.add(new ArrayList<>(trace));
             return;
         }

         for (int i = 0; i < choose.length; i++) {
             if ( !visit[i]){
                 visit[i] = true;
                 trace.add( choose[i] );
                 backTrace(choose,visit,trace);
                 trace.removeLast();
                 visit[i] = false;

             }
         }
     }

}
//leetcode submit region end(Prohibit modification and deletion)

 }