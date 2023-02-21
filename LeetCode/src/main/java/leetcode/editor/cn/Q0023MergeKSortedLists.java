package leetcode.editor.cn;

import org.springframework.util.CollectionUtils;

import java.util.PriorityQueue;

/**
 * @author  fengming.dai 
 * @date    2023-02-21 16:38:09 
 */
 public class Q0023MergeKSortedLists{
 //给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics链表 | 分治 | 堆（优先队列） | 归并排序 
//
// 👍 2332, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0023MergeKSortedLists().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0 ){
            return null;
        }

        //这里要 使用 val 排序。
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(node1,node2) -> node1.val - node2.val);
        //先把所有 头结点 入堆, 小顶堆
        for (int i = 0; i < lists.length; i++) {
            //这里 可能为空。
            if (lists[i] != null){
                pq.add(lists[i]);
            }

        }
        ListNode dumy = new ListNode(-1);
        //用于 组装 dumy 链表
        ListNode p = dumy;
        //队列不空，则 继续 放入 虚拟链表
        while ( !pq.isEmpty() ){
            ListNode minNode = pq.poll();
            p.next = minNode;
            //把 最小那个链表节点 的 下一个 入 小顶堆
            if ( minNode.next != null ){
                pq.add( minNode.next );
            }
            p = p.next;
        }

        return dumy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
          public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
 }