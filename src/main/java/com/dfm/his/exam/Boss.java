package com.dfm.his.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author dfm
 * @create 2020-10-15 18:48
 */
public class Boss {
    public static int[] calculateStatistics (int[] dataArr) {
        // write code here
        int len = dataArr.length;
        int[] ans = new int[4];
        Arrays.sort(dataArr);
        int mid = (len)/2;
        mid =  len % 2 == 0 ? mid-1 : mid;
        int x = (int)Math.ceil(len * 0.9 );
        x = len % 2 == 0 ? x-1 : x;
        ans[0] = dataArr[mid];
        ans[1] = dataArr[0];
        ans[2] = dataArr[len-1];
        ans[3] = dataArr[x];
        return ans;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param content string字符串
     * @param sensitiveWords string字符串一维数组
     * @return string字符串ArrayList
     */
    public static ArrayList<String> filterSensitiveWords(String content, String[] sensitiveWords) {
        // write code here
        if(content == null || content.length() == 0)return  null;
        ArrayList<String> ans = new ArrayList<>();
        int index = 0;
        while ( index < content.length()){

            for(int i=0;i<sensitiveWords.length;i++){
                int inerIndex = index;
                ok:
                if(sensitiveWords[i].charAt(0) == content.charAt(inerIndex)){

                    int j = 0;

                    if(inerIndex < content.length() && j < sensitiveWords[i].length()){

                        while (content.charAt(inerIndex) == sensitiveWords[i].charAt(j)){
                            inerIndex++;
                            j++;

                            if(inerIndex < content.length() && j == sensitiveWords[i].length()){
                                String sre = content.substring(index,inerIndex);
                                ans.add(sre);
                                index = inerIndex-1;
                                break ok;
                            }
                            if(inerIndex == content.length() )return ans;
                        }
                    }


                }
            }

            index++;
        }
        return ans;

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param ipArr string字符串一维数组 待校验 IP 列表
     * @param blackIpArr string字符串一维数组 IP 黑名单列表
     * @return bool布尔型一维数组
     */
    public boolean[] isBlackIp (String[] ipArr, String[] blackIpArr) {
        // write code here
        if(ipArr == null)return null;
        boolean[] res = new boolean[ipArr.length];
        TreeMap<String, String> treeMap = new TreeMap<>();
        for(int i=0;i<blackIpArr.length;i++){
            treeMap.put(blackIpArr[i],blackIpArr[i]);
        }
//        int left = 0;
//        int right = ipArr.length-1;
       for(int i=0;i<ipArr.length;i++){
           res[i] = (treeMap.containsKey(ipArr[i])) ? true : false;
       }
       return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,9, 8, 7, 6, 5, 4, 3, 2, 1};
            int[] res = calculateStatistics(arr);
            for(int i = 0 ;i<res.length;i++){
                System.out.print(res[i]+" ");
            }
//        String str = "While there is life, there is hope.";
//        //,["hope", "here"]
//        String[] sen = new String[]{"hope", "here"};
//        ArrayList<String> strings = filterSensitiveWords(str, sen);
//        strings.forEach(x-> System.out.println(x+" "));
    }
}
