package com.dfm.his.algorithm.search;

/**
 *
 * 更新的left or right都是根据mid来的。
 * 已经进行过比较。所以 +1 -1
 * 这样避免了  下一次的mid  跟上一次会一样的情况
 * @author dfm
 * @create 2020-08-28 15:04
 */
public class BinarySearch {
    public static int search(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        int i = left+(right-left)/2;
        while (arr[i] != target ){
            if(arr[i] < target){
                left = i+1;

            }else {
                right = i-1;
            }
            if(left > right){
                return  -1;
            }
            i = (left + right)/2;

        }
        return i;
    }
}
//int binary_search(int[] nums, int target) {
//    int left = 0, right = nums.length - 1;
//    while(left <= right) {
//        int mid = left + (right - left) / 2;
//        if (nums[mid] < target) {
//            left = mid + 1;
//        } else if (nums[mid] > target) {
//            right = mid - 1;
//        } else if(nums[mid] == target) {
//            // 直接返回
//            return mid;
//        }
//    }
//    // 直接返回
//    return -1;
//}
//
//int left_bound(int[] nums, int target) {
//    int left = 0, right = nums.length - 1;
//    while (left <= right) {
//        int mid = left + (right - left) / 2;
//        if (nums[mid] < target) {
//            left = mid + 1;
//        } else if (nums[mid] > target) {
//            right = mid - 1;
//        } else if (nums[mid] == target) {
//            // 别返回，锁定左侧边界
//            right = mid - 1;
//        }
//    }
//    // 最后要检查 left 越界的情况
//    if (left >= nums.length || nums[left] != target)
//        return -1;
//    return left;
//}
//
//
//int right_bound(int[] nums, int target) {
//    int left = 0, right = nums.length - 1;
//    while (left <= right) {
//        int mid = left + (right - left) / 2;
//        if (nums[mid] < target) {
//            left = mid + 1;
//        } else if (nums[mid] > target) {
//            right = mid - 1;
//        } else if (nums[mid] == target) {
//            // 别返回，锁定右侧边界
//            left = mid + 1;
//        }
//    }
//    // 最后要检查 right 越界的情况
//    if (right < 0 || nums[right] != target)
//        return -1;
//    return right;
//}
