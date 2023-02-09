package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * @author  fengming.dai 
 * @date    2023-02-09 17:28:32 
 */
 public class Q0215KthLargestElementInAnArray{
 //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 2050, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0215KthLargestElementInAnArray().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     /**
      * 二叉堆的解法比较简单，实际写算法题的时候，推荐大家写这种解法。
      *
      * 可以把小顶堆 pq 理解成一个筛子，较大的元素会沉淀下去，较小的元素会浮上来；当堆大小超过 k 的时候，我们就删掉堆顶的元素，因为这些元素比较小，而我们想要的是前 k 个最大元素嘛。
      *
      * 当 nums 中的所有元素都过了一遍之后，筛子里面留下的就是最大的 k 个元素，而堆顶元素是堆中最小的元素，也就是「第 k 个最大的元素」。
      *
      * 二叉堆插入和删除的时间复杂度和堆中的元素个数有关，在这里我们堆的大小不会超过 k，所以插入和删除元素的复杂度是 O(logK)，再套一层 for 循环，总的时间复杂度就是 O(NlogK)。
      *
      * 当然，这道题可以有效率更高的解法叫「快速选择算法」，只需要 O(N) 的时间复杂度。
      *
      * 快速选择算法不用借助二叉堆结构，而是稍微改造了快速排序的算法思路，有兴趣的读者可以看详细题解。
      * @param nums
      * @param k
      * @return
      */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
            //堆中元素 >k 个时，去除 最小的，因为 要留下的 是 第k大的。
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return priorityQueue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }