package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author  fengming.dai 
 * @date    2023-02-22 14:18:04 
 */
 public class Q面试题SmallestKLcci{
 //设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
//
// Related Topics数组 | 分治 | 快速选择 | 排序 | 堆（优先队列） 
//
// 👍 209, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q面试题SmallestKLcci().new Solution();
 	int[] arr = {1,3,5,7,2,4,6,8};
     int[] res = solution.smallestK(arr, 4);
     Arrays.stream(res).forEach(System.out::println);
 }

 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     /**
      * 返回最小的 K个数
      * 1. 使用 容量为 K 的 大顶堆
      * 2. size = k 之后，  每个元素 跟 堆里最大的 比较，比这个树 小入堆，移出当前最大的元素
      * @param arr
      * @param k
      * @return
      */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue  = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (priorityQueue.size() >= k ){
                //大顶堆，堆顶就是 堆中最大的 ，只取不删
                Integer max = priorityQueue.peek();
                if ( arr[i] < max ){
                    //poll取出并删除 max, 小元素 入堆
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }else {
                priorityQueue.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        int count = 0;
        while ( !priorityQueue.isEmpty()){
            res[count++] = priorityQueue.poll();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }