package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-03-07 17:55:50 
 */
 public class Q0033SearchInRotatedSortedArray{
 //整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics数组 | 二分查找 
//
// 👍 2520, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0033SearchInRotatedSortedArray().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     /**
      * 二分查找。
      * 通过  nums[0] 和 每次 二分的 nums[mid] 判断 是在左边还是右边。
      * 里面 在跟 target 判断
      * @param nums
      * @param target
      * @return
      */
    public int search(int[] nums, int target) {
//        return bsearch(nums,target);
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high ){
            //避免 low + hight 越界
            mid =  low + ( high - low) / 2;
            if ( nums[mid] == target){
                return mid;
            }
            //注意 是 <=
            if ( nums[low] <= nums[mid]){
                //说明 【low，mid]是 左边 升序的区间
                if ( target < nums[mid] && target >= nums[low]){
                    high = mid -1 ;
                }else {
                    low = mid + 1;
                }
            }else {
                //说明 【mid,high] 是右边的 升序区间
                if ( target > nums[mid] && target <= nums[high]){
                    low = mid + 1 ;
                }else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

     public int bsearch(int[] nums, int target) {
         int lo = 0, hi = nums.length - 1, mid = 0;
         while (lo <= hi) {
             mid = lo + (hi - lo) / 2;
             if (nums[mid] == target) {
                 return mid;
             }
             // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
             if (nums[mid] >= nums[lo]) {
                 // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                 if (target >= nums[lo] && target < nums[mid]) {
                     hi = mid - 1;
                 } else {
                     lo = mid + 1;
                 }
             } else {
                 if (target > nums[mid] && target <= nums[hi]) {
                     lo = mid + 1;
                 } else {
                     hi = mid - 1;
                 }
             }
         }
         return -1;
     }

 }
//leetcode submit region end(Prohibit modification and deletion)

 }