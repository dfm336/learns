package com.dfm.his.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-10-20 20:28
 */
public class ShenCe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int x = in.nextInt();
//        int y = in.nextInt();
//        int m = in.nextInt();
//        int count = 0;
//        int ans = solution(x,y,m,count);

        int res = solution3(str,x);
        System.out.println(res);
    }

    private static int solution3(String str, int x) {
        String index = "abcdefghijklmnopqrstuvwxyz";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<index.length();i++){
            map.put(index.charAt(i),i+1);
        }
        int max = 0;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<=str.length();j++){
                String substring = str.substring(i, j);
                int sum =0;
                for(int k=0;k<substring.length();k++){
                    sum += map.get(substring.charAt(k));
                }
                if(sum == x && substring.length() > max){
                    max = substring.length();
                }
            }
        }
        return max;
    }

    private static int solution(int x, int y, int m,int count) {
        if(x>=m || y>= m){
            return count;
        }
        if(x<0 && y<0)return -1;
        //if(x==0 || y==0)return -1;
        if(x < y){
           count =  solution(x+y,y,m,count+1);
        }
        if(x > y){
            count = solution(x,x+y,m,count+1);
        }
//        int left = solution(x+y,y,m,count+1);
       // int right = solution(x,x+y,m,count+1);
        return count;
    }


}
