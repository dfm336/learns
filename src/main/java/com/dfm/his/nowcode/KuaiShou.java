package com.dfm.his.nowcode;

import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-09-28 10:07
 */
public class KuaiShou {
    /**
     * 小明最近在做病毒自动检测，他发现，在某些library 的代码段的二进制表示中，如果包含子串并且恰好有k个1，就有可能有潜在的病毒。
     * library的二进制表示可能很大，并且子串可能很多，人工分析不可能，于是他想写个程序来先算算到底有多少个子串满足条件。
     * 如果子串内容相同，但是开始或者结束位置不一样，则被认为是不同的子串。
     * 注：子串一定是连续的。例如"010"有6个子串，分别是 "0, "1", "0", "01", "10", "010"
     *
     * 输入描述:
     * 第一行是一个整数k，表示子串中有k个1就有可能是病毒。其中 0 <= k <= 1 000 000
     *
     * 第二行是一个字符串，就是library的代码部分的二进制表示。字符串长度 <= 1 000 000。并且字符串中只包含"0"或"1".
     *
     * 输出描述:
     * 输出一个整数，所有满足只包含k个1的子串的个数。
     *
     * 输入例子1:
     * 1
     * 1010
     *
     * 输出例子1:
     * 6
     * 例子说明1:
     * 满足条件的子串有："1", "1", "10", "01", "10", "010".
     * @return
     */
    public static int varusDetection(String str,int k){
        if(str==null || str.equals(" ") || str.length() == 0) return 0;
        int len = str.length();
        int ans = 0;
        int slow = 0;
        int fast = 1;
        while (slow < len && fast <= len){
            String substring = str.substring(slow, fast);
            if(isContainKOne(substring)==k){
                ans++;
                fast++;
            }else if(isContainKOne(substring)>k) {
                slow++;
                fast = slow+1;
            } else fast++;

        }


//        for(int i=0; i<len;i++){
//            for(int j=i+1;j<=len;j++){
//                String substring = str.substring(i, j);
//                if(isContainKOne(substring)==k)ans++;
//                if(isContainKOne(substring)>k)break;
//            }
//        }
        return ans;
    }

    private static int isContainKOne(String substring) {
        int count = 0;
        for(int i=0;i<substring.length();i++){
            if(substring.charAt(i)=='1')count++;
        }
        return count;
    }

//    private static int maxTotalScore(String[] ans)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

    }
}
