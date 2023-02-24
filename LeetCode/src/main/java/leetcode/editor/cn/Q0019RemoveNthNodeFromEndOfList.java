package leetcode.editor.cn;

import org.checkerframework.checker.units.qual.K;

/**
 * @author  fengming.dai 
 * @date    2023-02-22 19:40:55 
 */
 public class Q0019RemoveNthNodeFromEndOfList{
 //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics链表 | 双指针 
//
// 👍 2413, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0019RemoveNthNodeFromEndOfList().new Solution();
 	ListNode node = new ListNode(1);
 	solution.removeNthFromEnd(node,1);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null ){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

//        int count = 1;
        for (int i = 0; i < n  ; i++) {
            if ( fast != null ){
                fast = fast.next;
//                count ++;
            }else {
                //说明 整个链表 不支持 fast 走n步
                break;
            }

        }
        // count <= n
        // n == count说明  存在 倒数 第n个 节点

        // n > count ，说明 不存在 倒数第k 个节点
//        if ( n > count ){
//            return null;
//        }

        //说明 不存在 倒数第k 个节点
        if ( fast == null){
            return null;
        }

        while ( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        if ( slow.next != null ){
            slow.next = slow.next.next;
        } else {
            slow.next = null;
        }




        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
         public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

 }