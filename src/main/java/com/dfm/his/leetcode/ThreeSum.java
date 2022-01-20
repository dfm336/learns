package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author dfm
 * @create 2020-09-14 11:22
 */
public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if(n <= 2)return result;
        Arrays.sort(nums);
        //不存在。全部小于0  或者 全部都大于0
        if(nums[0] > 0 || nums[n-1] < 0 )return result;
        for(int i=0;i<n;i++){
            //去重 跟上一次的值 一样则为重复
            if(i>0 &&nums[i] == nums[i-1])continue;
            //固定一个元素
            int left = i; //第i个往后搜索。不会重复
            int right = n-1;
            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0 ){
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    left++;
                    right--;
                    //去重 跟上一次的值 一样则为重复
                    while (left < right && nums[left] == nums[left+1])left++;
                    while (left < right && nums[right] == nums[right+1])right--;
                }else  if(sum > 0){
                    right--;
                }else{
                    left++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> solution = solution(nums);
        solution.forEach(x-> x.forEach(t-> System.out.println(t)));
    }
}
