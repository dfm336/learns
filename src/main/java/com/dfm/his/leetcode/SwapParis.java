package com.dfm.his.leetcode;

/**
 * @author dfm
 * @create 2020-10-09 16:25
 */
public class SwapParis {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        ListNode24 head = new ListNode24(1);
        ListNode24 p = head;
        for(int i=1;i<arr.length;i++){
            p.next = new ListNode24(arr[i]);
            p = p.next;
        }
        ListNode24 ans = swapParis(head);
        p = ans;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode24 swapParis(ListNode24 head){
        if(head == null)return null;
        if(head.next == null)return head;

        ListNode24 slow = head;
        ListNode24 fast = head.next;

        //返回后面交换后的 子链 挂在 该节点后面。
        slow.next = swapParis(fast.next);
        fast.next = slow;

        //头结点 换位 后面的一个 节点。
        return fast;
    }
}
class ListNode24{
    int val;
    ListNode24 next;
    ListNode24(int x){val = x;}
    ListNode24(int x,ListNode24 node24){
        val = x;
        next = node24;
    }
}