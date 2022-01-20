package com.dfm.his.leetcode;

import java.util.*;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *class Solution {
 *     public List<String> letterCombinations(String digits) {
 *         List<String> combinations = new ArrayList<String>();
 *         if (digits.length() == 0) {
 *             return combinations;
 *         }
 *         Map<Character, String> phoneMap = new HashMap<Character, String>() {{
 *             put('2', "abc");
 *             put('3', "def");
 *             put('4', "ghi");
 *             put('5', "jkl");
 *             put('6', "mno");
 *             put('7', "pqrs");
 *             put('8', "tuv");
 *             put('9', "wxyz");
 *         }};
 *         backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
 *         return combinations;
 *     }
 *
 *     public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
 *         if (index == digits.length()) {
 *             combinations.add(combination.toString());
 *         } else {
 *             char digit = digits.charAt(index);
 *             String letters = phoneMap.get(digit);
 *             int lettersCount = letters.length();
 *             for (int i = 0; i < lettersCount; i++) {
 *                 combination.append(letters.charAt(i));
 *                 backtrack(combinations, phoneMap, digits, index + 1, combination);
 *                 combination.deleteCharAt(index);
 *             }
 *         }
 *     }
 * }
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，
 * 因此不存在不可行的解，直接穷举所有的解即可。
 *
 * @author dfm
 * @create 2020-09-11 16:19
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String param = "23";
        List<String> solution = solution(param);
        solution.forEach(x-> System.out.println(x));
    }

    public static void buildres(Map<Character,String>map,String digits,int index ,List<String> result,StringBuilder ans){
        if(index == digits.length()){//找到最后一个了。已经拼装了所有的
            result.add(ans.toString());
        }else{
            char t = digits.charAt(index);
            String str = map.get(t);
            for(int i=0;i<str.length();i++){
                ans.append(str.charAt(i));//加入ans，拼装一个字符串
                buildres(map,digits,index+1,result,ans);//回溯 去拼装下一个输入可能的字符
                ans.deleteCharAt(index);//删除第一步加入的ans，寻找遍历下一个
            }
        }

    }
    public static List<String> solution(String digits){
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)return result;
        Map<Character,String> bak = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        buildres(bak,digits,0,result,new StringBuilder());
        return result;
    }
}
