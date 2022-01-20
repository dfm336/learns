package com.dfm.his.exam;



import java.util.Scanner;

/**

 * @author dfm
 * @create 2020-09-10 18:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        //dec(n,sb,2);
        declPrim(n,sb);
        System.out.println(sb.toString());
    }

    public static void dec(int n,StringBuilder sb,int index){
        for(int i=index;i<=n;i++){
                if(n % i == 0){
                    if(sb.length() == 0)sb.append(i);
                    else {
                        String t = "*"+i;
                        sb.append(t);
                    }
                    n /= i;
                    dec(n,sb,i);
                    break;
                }
        }
    }
    private static void declPrim(int n,StringBuilder sb) {
        for(int i = 2; i<=n;i++){
            while (n >= i){
                if( n % i == 0){
                    if(sb.length() == 0)sb.append(i);
                    else {
                        String t = "*"+i;
                        sb.append(t);
                    }
                    n /= i;
//                    declPrim(n/i,sb);
                }else break;
            }
        }
    }

    private static String solution3(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i=1;i<sb.length();i++){
            if(i>= 1 && sb.charAt(i) == '_' && sb.charAt(i-1) =='_'){
                sb.deleteCharAt(i-1);
                i--;
            }
        }
        int len = sb.length();
        if(sb.charAt(0)=='_'){sb.deleteCharAt(0);len--;}
        if(sb.charAt(len-1)=='_')sb.deleteCharAt(len-1);
        return sb.toString();
    }

    public static  void sort(int[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[j] < arr[i]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
    private static int solution(int[][] arr,int m,int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)continue;
                if(j-1 >=0 && i-1 >= 0 ){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + arr[i][j];
                }
                if(j-1 >=0 && i-1 < 0){
                    dp[i][j] = dp[i][j-1] + arr[i][j];
                }
                if(j-1 < 0 && i-1 >= 0){
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }


}
