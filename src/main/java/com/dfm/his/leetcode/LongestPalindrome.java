package com.dfm.his.leetcode;

/**给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @author dfm
 * @create 2020-08-18 16:07
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String testStr = "cbbd";
        String result = solution1(testStr);
        System.out.println(result);
    }

    public static String solution2(String s){
        if(s.length() < 2)return s;
        int maxLenth = 1;
        char[] str = s.toCharArray();
        int len = str.length;
        int subLeft = 0;
        boolean[][] db = new boolean[len][len];
        //初始化  自己到自己 肯定是回文串
        for(int i=0;i<str.length;i++){
            db[i][i] = true;
        }
        // . 状态转移
        // 注意：先填左下角 才能保证 状态转移成功
        // 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
        for(int j=1;j<len;j++){
            for(int i =0; i < j;i++){
                if(str[i] != str[j]){
                    db[i][j] = false;
                }else{// j-1 - (i+1) + 1 < 2  表达式 [i + 1, j - 1] < 2 则不构成区间
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if(j-i < 3){
                        db[i][j] = true;
                    }else {//状态转移  两边字符相同情况下，中间子串是回文则总串也是回文，子串不为回文则总串也不是回文
                        db[i][j] = db[i+1][j-1];
                    }
                }
                if(db[i][j] && (j-i+1)>maxLenth){
                    subLeft = i;
                    maxLenth = j-i+1;
                }

            }
        }
        return s.substring(subLeft, subLeft + maxLenth);
    }

    //暴力检索
    private static String solution1(String testStr) {
        //如果只有一个字符  返回本身
        if(testStr.length() < 2){
            return testStr;
        }
        int subLeft =0;
        int subRight = 0;
        int maxLenth = 1;
        for(int i=0;i<testStr.length();i++){
            for(int j=i;j<testStr.length();j++){
                if(isPalindrome(i,j,testStr) && (j-i+1) > maxLenth){
                    maxLenth = j-i+1;
                    subLeft = i;
                    subRight = j;
                }
            }
        }
        if(maxLenth != 0){
            return testStr.substring(subLeft,subRight+1);
        }else{
            return "";
        }

    }
    //判断是否 为回文序列
    private static boolean isPalindrome(int left, int right, String str) {
        while (left <= right ){
            if(str.charAt(left) != str.charAt(right)){
                return  false;
            }
            left++;
            right--;
        }
        return  true;
    }
}
