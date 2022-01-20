package com.dfm.his.exam;


import java.util.*;

/**
 * @author dfm
 * @create 2020-10-11 18:47
 */
public class YouZan {
    public static void main(String[] args) {
        int[] a = new int[]{8,6,7,1,0};
//        int[] b = new int[]{2,3};
//        int[] ans =  solution(a,b);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
//        String s = largestMultipleOfThree(list);
        Integer sum =0;
        List<Integer> can = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        back(list,sum,can,res);

//        System.out.println(s);
//        System.out.println(ans[0]+" "+ans[1]);
    }

    public static void back(ArrayList<Integer> digits , Integer sum ,List<Integer> candi,List<List<Integer>> res){
        if(sum % 3 == 0){
            res.add(candi);
            return;
        }
        for(int i=0;i<digits.size();i++){
            if(candi.contains(digits.get(i))){
               continue;
            }
            sum += digits.get(i);
            candi.add(digits.get(i));
            back(digits,sum,candi,res);
            sum -= digits.get(i);
            candi.remove(candi.size()-1);
        }
    }

    public static String largestMultipleOfThree (ArrayList<Integer> digits) {
        // write code here
        if(digits == null)return "";
        String ans = "";
        if(digits.size() == 1 ){
            if(digits.get(0) % 3 == 0)return ans+digits.get(0);
            else return ans;
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<digits.size();i++){
            for(int j=i+1;j<digits.size();j++){

            }
        }

        if(sum % 3 == 0){
//            Collections.sort(digits);
            Collections.sort(digits, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            for (Integer x: digits
            ) {
                ans += x;
            }

        }
        return  ans;

    }

    private static int[] solution(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = 0;
        int sumB = 0;
        for(int i=0;i<A.length;i++){
            sumA += A[i];
        }
        for(int i=0;i<B.length;i++)
            sumB += B[i];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(sumA - A[i] + B[j] == sumB - B[j] + A[i]){
                    ans[0] = A[i];
                    ans[1] = B[j];
                }
            }
        }
        return ans;
    }
}
