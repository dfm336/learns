package com.dfm.app.algors.sort.leetCode;

/**
 * @Author:fengming.dai
 */
public class ReverseList {
    /**
     * 递归定义：
     * 翻转 head 为头结点的 链表，并返回 翻转后的 头结点
     * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode lastNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        //最后 需要返回 反转之后的  头结点 也就是 last
        return lastNode;
    }
}
