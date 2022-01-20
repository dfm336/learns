package com.dfm.his.nowcode;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-09-17 15:39
 */
public class YouZanA {
    /**
     * 字符串旋转:
     * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
     * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
     *
     * 输入描述:
     * 2个不为空的字符串(说明:输入一个字符串以英文分号";"分割为2个字符串)
     * 例如:youzan;zanyou 即为A=‘youzan’，B=‘zanyou’
     */
    public static boolean reverse(String strA, String strB ){
        int len = strA.length();
        for(int i=1;i<len-1;i++ ){
            String t = strA.substring(0,i);
            t = strA.substring(i,len)+t;
            if(t.equals(strB))return true;
        }
        return  false;
    }

    /**
     * 有赞电子卡券兑换码目前是12位纯数字，每笔订单对应一个兑换码，订单上主要信息有店铺id、用户id等纯数字id，请设计一版码生成器，保证码不重复. （描述设计思路和方案）
     * 例：兑换码：123 001 002 111 店铺id：1001 用户id：2002
     */
    public static String generateCode(String shopID,String userId){
        int h = shopID.hashCode();
        int res = h%4;
        String result = String.valueOf(h)+String.valueOf(res);
        return shopID;
    }
    public  static  boolean leap(int[] arr){
        int n =arr.length;
        int i=0;
        int count =0;
        while (true){
            i += arr[i];
            count++;
            if(i >= n || i<0)return true;
            if(count >= n)return false;
        }
    }
    public static void main(String[] args) {
        ;
        String s = "abcdef";
        String replace = s.replace('a', 'c');
        System.out.println(replace);
        System.out.println(s.substring(2));
        System.out.println(s.substring(2,5));

        Scanner in = new Scanner(System.in);
        String str = in.next();
        String substring = str.substring(1, str.length()-1);
        String[] split = substring.split(",");
        int[] arr = new int[split.length];
        for(int i=0;i<split.length;i++){
            arr[i] = Integer.valueOf(split[i]);
        }
        boolean reverse = leap(arr);
        System.out.println(reverse);
    }
}
