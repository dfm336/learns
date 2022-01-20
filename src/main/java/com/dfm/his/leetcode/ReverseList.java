package com.dfm.his.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author dfm
 * @create 2020-09-09 10:15
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static ListNode reverse(ListNode root){
        if(root == null)return null;
        List<Integer> list = new ArrayList<>();
        ListNode t  = root;
        while (t != null){
           list.add(t.val);
            t = t.next;
        }
        ListNode result = new ListNode(list.get(list.size()-1));
        t = result;
        for(int i=list.size()-2;i>=0;i--){
            ListNode p = new ListNode(list.get(i));
            t.next = p;
            t = t.next;
        }
        return result;
    }

    //递归
    public static ListNode reverseByRecursion(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode current = reverseByRecursion(node.next);
        current.next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode t  = root;
        for(int i= 2 ; i <= 5; i++){
            ListNode p = new ListNode(i);
            t.next = p;
            t = t.next;
        }
        //t 已经指向了最后一个节点
        //翻转之后 root是尾节点了。root.next ==  null
        ListNode reverse = reverseByRecursion(root);

        while (t != null){
            System.out.println(t.val);
            t = t.next;
        }

    }
}
