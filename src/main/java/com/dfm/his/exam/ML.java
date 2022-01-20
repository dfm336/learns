package com.dfm.his.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-11-20 20:23
 */
public class ML {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    //人民币 拾伍万壹仟壹佰贰拾壹元壹角伍分
    private static String solution(String str) {
        Map<Integer,String> map1 = new HashMap<>();
        String s1 =  "壹贰叁肆伍陆柒捌玖拾";
        String s2 = "佰仟万亿";
        String s3 = "元角分";

        String res = "人民币";
        String[] spilt = {"",""};
        int t = 0;
        boolean flag = false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '.'){
                flag = true;
                continue;
            }
            if(flag){
                spilt[1] += str.charAt(i);
            }else spilt[0] += str.charAt(i);
        }
//        res+= s2.charAt()



        flag = true;
        if(spilt[1].charAt(0)=='0' && spilt[1].charAt(1)=='0'){
            flag =false;
        }else {
        }
        int len = spilt[0].length();
        int mod = len%4;
        int sub = len / 4;

        t = 0;

        int count = mod;
        if(mod == 1)res += s2.charAt(Integer.valueOf(spilt[0].charAt(0)));
        else{
            for(int i=0;i<mod;i++){
//                res +=
            }
        }


        res += (flag) ? " " : "整";
        return res;
    }
}
