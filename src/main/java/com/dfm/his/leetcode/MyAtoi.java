package com.dfm.his.leetcode;


import java.util.ArrayList;

/**
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

 输入: "   -42"
 输出: -42
 解释: 第一个非空白字符为 '-', 它是一个负号。
      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author dfm
 * @create 2020-08-19 16:55
 */
public class MyAtoi {
    public static void main(String[] args) {
        String testStr = "   -42 we ";
        int result = solution(testStr);
        System.out.println(result);
    }
    private static  boolean isValid(char unCheck){
        if((unCheck >= '0' && unCheck <= '9') || unCheck=='+'||unCheck == '-')return true;
        else return false;
    }
    
    private  static int solution(String str){
        final int MAX =2147483647;
        final int MIN =-2147483648;
        if(str == "")return  0;
        boolean flag = false;
        String trimStr = str.trim();
        if(trimStr.charAt(0) == '-'){
            flag = true;
            trimStr.substring(1);
        }
        char[] chars = trimStr.toCharArray();
        int len = trimStr.length();
        ArrayList<Integer> toInt = new ArrayList<Integer>();
        int count = 0;
        while (isValid(chars[count])){
            Integer temp = Integer.valueOf(String.valueOf(chars[count]));
            toInt.add(temp);
            count++;
            //避免 chars越界
            if(count >= len)break;
        }
        //第一个非空字符为 无效数字
        if(count == 0)return 0;
        int ans = 0;
        for(int i=count-1;i>=0;i--){
            Integer temp = toInt.get(i);
            ans = (int) (temp * Math.pow(10,(count-1)-i)+ans);
            if((ans = (flag == true ? -1*ans : ans)) < MIN ){
                return MIN;
            }
            if(ans > MAX){
                return MAX;
            }
        }


        return ans;
    }
}
