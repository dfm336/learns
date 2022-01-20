package com.dfm.his.leetcode;

/**给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * @author dfm
 * @create 2020-08-19 11:27
 */
public class ReverseSignedInt {
    public static void main(String[] args) {
        int x = -1231251515;
        int result = solution2(x);
        System.out.println(result);
    }
    private static int solution2(int x){
        int res = 0;
        while (x != 0){
            int temp = x % 10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && temp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && temp<-8)) {
                return 0;
            }
            res = res * 10 +temp;
            x /= 10;
        }
        return res;
    }

    private static int solution(int x) {
        String str = String.valueOf(x);
        if(str.length() <= 1)return new Integer(str);
        boolean flag = false;
        if(str.charAt(0) == '-'){
            str = str.replace('-',' ');
            flag = true;
        }
        char[] chars = str.trim().toCharArray();
        for(int i=0; i<chars.length/2;i++){
            char t = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = t;
        }
        String s = (chars[0] != '0') ? String.valueOf(chars) : String.valueOf(chars).substring(1);
        Integer toInt = null;
        try {
            toInt = Integer.parseInt(s);

        }catch (NumberFormatException e){
            return 0;
        }
        return toInt = (flag == true) ? -1*toInt : toInt;
    }
}
