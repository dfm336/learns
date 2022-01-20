package com.dfm.his.leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 *
 * @author dfm
 * @create 2020-08-18 08:56
 */
public class FindMediaSortArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {4,5};
        double media = solution(nums1,nums2);
        System.out.println(media);
    }
    
    public  static double solution(int[] nums1 ,int[] nums2){
        int m = nums1.length ;
        int n = nums2.length ;
        int[] merge = new int[m+n];
        double media = 0;
        if(m==0){
            if(n % 2 == 0){
                return (nums2[(n/2)-1]+nums2[n/2])/2.0;
            }else{
                return nums2[n/2];
            }
        }
        if(n==0){
            if(m % 2 == 0){
                return (nums1[(m/2)-1]+nums1[m/2])/2.0;
            }else{
                return nums1[m/2];
            }
        }
        //合并数组
        int count = 0;
        int i=0;
        int j=0;
        while ( i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merge[count++] = nums1[i++];
            }
            else {//if (nums2[j] < nums1[i])
                merge[count++] = nums2[j++];
            }
        }
        //若右边剩余
        while(j < n){
            merge[count++] = nums2[j++];
        }
        //若左边剩余
        while (i < m){
            merge[count++] = nums1[i++];
        }
        if(count % 2 == 0){
            return (merge[(count/2)-1]+merge[count/2])/2.0;
        }else{
            return merge[count/2];
        }
    }

}
