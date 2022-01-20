package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * @author dfm
 * @create 2020-09-08 16:38
 */
public class MImumumTotal {
    public static int solution(List<List<Integer>> triangle){
        int row = triangle.size();//行
        int column = triangle.get(row-1).size();//列
        int[][] dp = new int[row][column];
        //填充最后一行
        for(int i=0;i<column;i++){
            List<Integer> list = triangle.get(row - 1);
            dp[row-1][i] = list.get(i);
        }
        for(int i=row-2;i>=0;i--){
            int t = triangle.get(i).get(i);
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j])+t;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = 4;
        int count = 0;
        List<List<Integer>> cin = null;
        for(int i=0;i<n;i++){
            ArrayList<Integer> listIN = new ArrayList<>();
            for(int j=0;j<Math.pow(2,count);j++){
                int t = scanner.nextInt();
                listIN.add(t);
            }
            cin.add(listIN);
            count++;
        }
        cin.forEach(x-> x.forEach(t-> System.out.println(t)));
        int ans = solution(cin);
        System.out.println(ans);
    }
}
