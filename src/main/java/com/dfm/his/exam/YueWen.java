package com.dfm.his.exam;

/**
 * @author dfm
 * @create 2020-10-21 18:46
 */
public class YueWen {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String  str = in.next();
//        String[] nums = str.split(",");
//        int m = Integer.parseInt(nums[0]);
//        int p = Integer.parseInt(nums[1]);
//        int n = Integer.parseInt(nums[2]);
//        int[][] first = new int[m][p];
//        for(int i=0;i<m;i++){
//            String strs = in.next();
//            String[] split = strs.split(",");
//            for(int j=0;j<p;j++){
//                first[i][j] = Integer.parseInt(split[j]);
//            }
//        }
//        int[][] second = new int[p][n];
//        for(int i=0;i<p;i++){
//            String strs = in.next();
//            String[] split = strs.split(",");
//            for(int j=0;j<n;j++){
//                second[i][j] = Integer.parseInt(split[j]);
//            }
//        }
//        int[][] res = new int[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                for(int k=0;k<p;k++){
//                    res[i][j] +=first[i][k]*second[k][j];
//                }
//                if(j == n-1){
//                    System.out.print(res[i][j]);
//                }else{
//                    System.out.print(res[i][j]+",");
//                }
//
//            }
//            System.out.println();
//        }
//
//
//
//    }

public static void main(String[] args) {
    String str = "aaa";
    System.out.println(palindromeCount(str));
}
    public static  int palindromeCount (String s) {
        // write code here
        if(s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[][] dp =  new boolean[len][len];
        //初始化 dp
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(str[i] != str[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
//                        dp[j][i] = dp[i][j];
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j])count++;
            }
        }
        return  count;
    }
//    public static int countBit (int n) {
//        // write code here
//        int count = 0;
//        while (n != 0){
//            n &= (n-1);
//            count++;
//        }
//        return  count;
//    }
}
