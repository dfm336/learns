package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

/**
 * @author  fengming.dai 
 * @date    2023-02-01 17:41:51 
 */
 public class Q0002AddTwoNumbers{
 //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 9143 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0002AddTwoNumbers().new Solution();
 	//243 + 564 = 708 real: 342 + 465 = 807
     ListNode l2 = new ListNode(2);
 	ListNode l3 = new ListNode(3);
 	ListNode l4 = new ListNode(4);

 	l2.setNext(l4);
 	l4.setNext(l3);


 	ListNode l5 = new ListNode(5);
 	ListNode l6 = new ListNode(6);
 	ListNode l44 = new ListNode(4);
 	l5.setNext(l6);
 	l6.setNext(l44);
 	ListNode listNode = solution.addTwoNumbers(l2, l5);
     ListNode p = listNode;
     while (p != null){
         System.out.println(p.getVal());
         p = p.getNext();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null ){
//            return l2;
//        }
//        if (l2 == null){
//            return l1;
//        }
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dummy = new ListNode();
        ListNode p = dummy;
        //进位
        int carry = 0 ;
        while (p2 != null || p1 != null){


            int p1Val = (p1 != null ) ? p1.getVal() : 0;
            int p2Val = p2 != null ? p2.getVal() : 0;
            int val = p1Val + p2Val + carry;

            carry = val / 10;
            p.setNext(new ListNode(val % 10));
            p = p.getNext();
            p2 = (p2 != null ) ?  p2.getNext() : null;
            p1 = (p1 != null ) ?  p1.getNext() : null;

        }
        if (carry > 0){
            p.setNext(new ListNode(carry));
        }
        return dummy.getNext();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

 }