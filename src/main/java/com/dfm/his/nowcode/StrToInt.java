package com.dfm.his.nowcode;

/**
 * @author dfm
 * @create 2020-09-29 15:23
 */
public class StrToInt {
    public static void main(String[] args) {
        String str = "-1567";
        int ans = solution(str);
        System.out.println(ans);
    }

    public  static boolean isValid(char firstChar){
        if(firstChar == '+' || firstChar == '-' || (firstChar  < '9' && firstChar > '0'))return true;
        return false;
    }
    private static int solution(String str) {
        if(str.equals("")||str==null)return 0;
        char firstChar = str.charAt(0);
        if(!isValid(firstChar)){
            return 0;
        }
        int flag = 0;
        String num = "";
        if(firstChar == '+'){
            flag = 1;
            num = str.substring(1,str.length());
        }
        else if(firstChar == '-'){
            flag= -1;
            num = str.substring(1,str.length());
        }
        else {
            num = str;
        }
        int len = num.length();
        int ans = 0;
        int count = 0;
        for(int i=len-1;i>=0;i--){
            char t =num.charAt(i);
            if(!isValid(t)){
                return 0;
            }
            Integer value = Integer.valueOf(String.valueOf(t));
            ans += (Math.pow(10,count)*value);
            count++;
        }
        if(flag == -1)return -1*ans;
        return ans;
    }
}
