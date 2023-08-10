package com.dfm.app.web;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class TX {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     *
     *
     * 有效字符串需满足：
     *
     *
     *
     * 左括号必须用相同类型的右括号闭合。
     *
     * 左括号必须以正确的顺序闭合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     *
     * 输出：true
     */
    public static boolean charge( String str ){
        if (StringUtils.isEmpty( str )){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ( c == '(' || c == '{' || c == '['){
                stack.push( c );
            }else {
                Character pop = stack.peek();
                if ( c == ')' && pop == '('){
                    stack.pop();
                    continue;
                }
                if ( c == ']' && pop == '['){
                    stack.pop();
                    continue;
                }
                if ( c == '}' && pop == '{'){
                    stack.pop();
                    continue;
                }

            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String str = "{(]}";
        boolean charge = charge(str);
        System.out.println(charge);
    }


}
