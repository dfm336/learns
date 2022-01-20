package com.dfm.his.leetcode;

import java.util.Arrays;

/**
 * @author dfm
 * @create 2020-09-11 11:19
 */
public class PlusOne {
    public static int[]  nice(int[] digits){
        int len = digits.length;
        for(int i=len-1;i>=0;i++){
            digits[i]++;//个位要求+1，若执行第二次循环，必定进位。进位只能为1.
            digits[i] %= 10; //取余数 保留记录
            if(digits[i] != 0)return digits;// ==0说明会进位，要继续循环。 ！=0 则说明为普通计算 个位+1 返回原来数组即可。
        }
        //没有在循环中return 。则说明一直有进位。最高位是1，其他位全为0；
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }

    public static int[] solution(int[] digits){
        int[] ans = new int[digits.length+1];
        int flag = 0;
        for(int i=digits.length-1;i>=0;i--){
            int sum = 0;
            if(i == digits.length-1){
                sum += 1;
            }
            sum += digits[i] + flag;
            flag = sum / 10;//进位
            ans[i+1] = sum % 10;
        }
        //输入为 9 时。注意进位数组 扩长
        if(flag != 0)ans[0]=flag;
        else{
            int[] bak = new int[ans.length-1];
            for(int i=0;i<bak.length;i++){
                bak[i] = ans[i+1];
            }
            return bak;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1,2,3};
        int[] solution = solution(digits);
        Arrays.stream(solution).forEach(x-> System.out.println(x));
    }
}
