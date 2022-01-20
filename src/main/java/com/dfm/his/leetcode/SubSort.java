package com.dfm.his.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * @author dfm
 * @create 2020-09-24 11:59
 */
public class SubSort {
    public static int[] solution(int[] arr){
        int[] ans = new int[]{-1,-1};
        if(arr == null || arr.length <= 1)return ans;
        int len = arr.length;
        int left =0;
        while(left<len-1 && arr[left]<=arr[left+1]){
            left++;
        }
        if(left == len-1)return ans;
        int right = len-1;
        while(right >= 1 && arr[right] >= arr[right-1]){
            right--;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=left+1;i<right;i++ ){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        while(left >= 0 && arr[left] >= min)left--;
        while(right <= len-1 && arr[right] <= max)right++;
        return new int[]{left+1,right-1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] solution = solution(arr);
        Arrays.stream(solution).forEach(x-> System.out.println(x));
    }
}
