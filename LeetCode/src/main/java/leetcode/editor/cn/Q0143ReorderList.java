package leetcode.editor.cn;

import java.util.Stack;

/**
 * @author  fengming.dai 
 * @date    2023-02-10 16:48:19 
 */
 public class Q0143ReorderList{
 //给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics栈 | 递归 | 链表 | 双指针 
//
// 👍 1134, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0143ReorderList().new Solution();
 	ListNode node =
            new ListNode(1,
                    new ListNode(2,
                            new ListNode(3,
                                    new ListNode(4,null))));
 	solution.reorderList(node);

 	while (node != null){
        System.out.print(node.val+" ");
        node = node.next;
    }
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
    /**
     * 1. 截取 前半部分l1 后半部分 两个链表l2
     * 2. 合并， 根据 l1,l2  顺序
     * @param head
     */
    public void reorderList(ListNode head) {

        //双指针，快指针 走完，慢指针 留在中点
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        //截取分为 两个链表
        ListNode left,right;
        left = head;
        right = slow.next;
        //前半部分链表 尾巴 置null
        slow.next = null;

        ListNode reverseRight = reverseRight(right);
        ListNode merge = merge(left, reverseRight);
    }

    /**
     * 翻转后半部分链表,返回起点
     * @param node
     */
    private ListNode reverseRight(ListNode node) {
        if (node == null || node.next == null){
            return node;
        }
        ListNode last = reverseRight(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    /**
     * 根据 l1,l2 ,l1,l2 顺序合并
     * @param left
     * @param right
     */
    public ListNode merge(ListNode left, ListNode right){
        ListNode dumy = new ListNode();
        while (left != null && right != null){
            dumy.next = left;
            left = left.next;

            dumy = dumy.next;

            dumy.next = right;
            right = right.next;
        }

        return dumy.next;
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