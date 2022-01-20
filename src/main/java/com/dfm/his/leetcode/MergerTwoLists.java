package com.dfm.his.leetcode;

/**
 * 两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author dfm
 * @create 2020-09-11 09:59
 */
public class MergerTwoLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
        }
        ListNode(int y,ListNode node){
            val = y;
            next = node;
        }
    }

    public static void main(String[] args) {
            ListNode node1 = null;
            ListNode node2 = new ListNode(0);
            int[] l1 = {};
            int[] l2 = {};
            ListNode p1 = node1;
            for(int i=1;i<l1.length;i++){
                p1.next = new ListNode(l1[i]);
                p1 = p1.next;
            }
            p1 = node2;
            for(int i=1;i<l2.length;i++){
                p1.next = new ListNode(l2[i]);
                p1 = p1.next;
            }
            ListNode soulution = soulution(node1, node2);

            p1 = soulution;
            while ( p1 != null){
                System.out.println(p1.val);
                p1 = p1.next;
            }

    }
    public static ListNode solution2(ListNode l1,ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        if(l1.val < l2.val){
            l1.next = solution2(l1.next,l2 );
            return  l1;
        }else {
            l2.next = soulution(l1,l2.next);
            return l2;
        }
    }
    public static ListNode soulution(ListNode node1,ListNode node2){
        if(node1 == null && node2 == null)return null;
        ListNode left = node1;
        ListNode right = node2;
        ListNode result = null;
        if(node1 == null && node2 != null){
            result = node2;
            return result;
        }
        if(node1 != null && node2 == null){
            result = node1;
            return result;
        }
        if(left.val <= right.val){
            result = new ListNode(left.val);
            left = left.next;
        }else{
            result = new ListNode(right.val);
            right = right.next;
        }
        ListNode p = result;
        while (left != null && right != null){
            if(left.val <= right.val){
               p.next = new ListNode(left.val);
               left = left.next;
            }else{
                p.next =new ListNode(right.val);
                right = right.next;
            }
            p = p.next;
        }
       while (left != null){
           p.next = new ListNode(left.val);
           left= left.next;
           p = p.next;
       }
        while (right != null){
            p.next = new ListNode(right.val);
            right= right.next;
            p = p.next;
        }
        return result;
    }
}
