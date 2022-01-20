package com.dfm.his.leetcode;

/**
 * @author dfm
 * @create 2020-08-15 17:08
 */
public class addTwoNumbers {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val=x;}
    }
    public static ListNode insertNode(ListNode node,ListNode root){
        if(root == null){
            root = node;
            root.next = null;
            return root;
        }
        ListNode p = root;
        while ( p.next!=null){
            p = p.next;
        }
        p.next = node;
        return root;
    }
    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode p = l1;
        ListNode t = l2;
        ListNode result = null;
        int up =0;
        while (p != null || t != null ){
            int sum = 0;
            sum+=up;
            if(p !=null){
                sum+=p.val;
            }
            if(t != null){
                sum += t.val;
            }
            int ans = sum % 10;
            result  = insertNode(new ListNode(ans), result);
            up = sum / 10;
            if(p != null){
                p = p.next;
            }
            if(t != null){
                t = t.next;
            }

        }
        if(up != 0){
            result  = insertNode(new ListNode(up), result);
        }
        return result;

    }
    public static void  main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l1.next = l11;
//        ListNode l12 =new ListNode(3);
//        l11.next = l12;
//        l12.next = null;
//        ListNode p = l1;
//        while ( p != null){
//            System.out.print(p.val+" ");
//            p = p.next;
//        }
//        System.out.println();
        ListNode l2 = new ListNode(1);
//        ListNode l21 = new ListNode(6);
//        l2.next = l21;
//        ListNode l22 =new ListNode(4);
//        l21.next = l22;
//        l22.next = null;

        ListNode solution = solution(l1, l2);
        ListNode t = solution;
        while ( t != null){
            System.out.print(t.val+" ");
            t = t.next;
        }

    }

}

