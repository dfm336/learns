package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dfm
 * @create 2020-09-14 14:36
 */
public class FourSum {
    public static void main(String[] args) {
//        int[] arr = {0, 0, 0, 0};
        int[] arr = {-3,-1,0,2,4,5};
        List<List<Integer>> solution = solution(arr, 0);
        solution.forEach(x->x.forEach(t-> System.out.print(t+" ")));
    }

    /**
     * 内外双指针 ？？ 最后的 判断该如何？
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> solution(int[] nums ,int target){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len < 4)return result;
        Arrays.sort(nums);
        if(nums[0] > target )return result;//最小的  都比target大，加起来一定比target大
        int start = 0;
        int end = len-1;
        while (start + 2 < end){//留出两个位置内循环
            while (start + 2 < end && start > 0 &&nums[start] == nums[start-1]) {
                start++;
            }
            while (start + 2 < end  && end < len-1 && nums[end] == nums[end+1])end--;
            int left = start+1;
            int right = end-1;
            while (left < right){
                int sum = nums[start]+nums[end]+nums[left]+nums[right];
                if(sum == target){
                    List<Integer> list = Arrays.asList(nums[start], nums[end], nums[left], nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    while (left<right && nums[left] == nums[left-1])left++;
                    while (left<right && nums[end] == nums[right+1])right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
            if( nums[start]+nums[end]+nums[start+1]+nums[end-1] < target){
                start++;
            }else {// >=
                end--;
            }


        }
        return result;
    }
}
