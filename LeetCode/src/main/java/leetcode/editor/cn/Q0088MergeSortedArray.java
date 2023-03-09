package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-21 16:29:39 
 */
 public class Q0088MergeSortedArray{
 //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。 
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。 
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？ 
//
// Related Topics数组 | 双指针 | 排序 
//
// 👍 1744, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0088MergeSortedArray().new Solution();
 	int[] nums1 = {1,2,3,0,0,0};
 	int[] nums2 = {2,5,6};
 	solution.merge(nums1,3,nums2,3);
     for (int i = 0; i < nums1.length; i++) {
         System.out.println(nums1[i]);
     }
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if ( n==0)return;
        int l1 = 0, l2 = 0, cnt = 0;
        int[] tmp = new int[m+n];
        while ( l1 < m && l2 < n ){
            if ( nums1[l1] >= nums2[l2] ) {
               tmp[cnt++] = nums2[l2];
               l2++;
            }
            else if ( nums1[l1] < nums2[l2] ){
                tmp[cnt++] = nums1[l1];
                l1++;
            }
        }

        while ( l1 < m){
            tmp[cnt++] = nums1[l1++];
        }

        while ( l2 < n){
            tmp[cnt++] = nums2[l2++];
        }
        for (int i = 0; i < cnt; i++) {
            nums1[i] = tmp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }