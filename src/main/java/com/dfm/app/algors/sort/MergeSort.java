package com.dfm.app.algors.sort;

import com.fasterxml.jackson.databind.node.IntNode;

import java.util.Arrays;

/**
 * 归并排序
 * @Author:fengming.dai
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] nums = {-2,9,3,5,78,0,-10};
        mergeSort.mergeSort(nums);
    }

    public void mergeSort(int[] nums){
        sort(nums,0,nums.length-1,new int[nums.length]);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void  sort(int[] nums, int left, int right, int[] temp){
        if (left < right){
            int mid = ( left + right ) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1 , right, temp);
            merge(nums, left, right, temp);
        }

    }

    public void merge(int[] nums, int left, int right, int[] temp){
        int mid = ( left + right ) / 2;
        int pLeft = left;
        int pRight = mid + 1;

        int count = 0;
        while ( pLeft <= mid && pRight <= right){
            if (nums[pLeft] > nums[pRight] ){
                temp[count++] = nums[pRight++];
            }else {
                temp[count++] = nums[pLeft++];
            }
        }

        //可能 会有一半 元素要多一点
        while ( pLeft <= mid ){
            temp[count++] = nums[pLeft++];
        }

        while ( pRight <= right ){
            temp[count++] = nums[pRight++];
        }

        //copy 回 nums
        count = 0;
        while ( left <= right ){
            nums[left] = temp[count++];
            left++;
        }
    }
}
