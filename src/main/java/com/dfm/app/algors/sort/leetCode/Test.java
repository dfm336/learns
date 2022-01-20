package com.dfm.app.algors.sort.leetCode;

import org.luaj.vm2.ast.Str;

/**
 * @Author:fengming.dai
 */
public class Test {
    public static void main(String[] args) {
//        mergeTwoLists();
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
//        System.out.println(a==b);
//        System.out.println(c==d);
        minWindow();
    }
    public static void mergeTwoLists(){
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);
        node1.next  = node2;

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node3.next = node4;

        MergeTwoList mergeTwoList = new MergeTwoList();
        mergeTwoList.mergeTwoLists(node1,node3);
    }
    public static void minWindow(){
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        SlipWindow slipWindow = new SlipWindow();
        String s1 = slipWindow.minWindow(s, t);
        System.out.println("s1 = " + s1);
    }
}
