package com.dfm.app;

public class DL2 {
    public static void main(String[] args) {

//        Node l1 = new Node(2,
//                new Node(4, null));
//        Node l2 = new Node(5,
//                new Node(6, new Node(4)));
        Node l2 = new Node(0);
        Node l1 = new Node(0);
        Node add = add(l1, l2);

        Node p = add;
        while ( p != null ){
            System.out.println(p.val);
            p = p.next;
        }

    }

    public static Node add(Node l1, Node l2){
        Node p1 = l1;
        Node p2 = l2;

        Node dummy = new Node(-1);
        Node p = dummy;
        int add = 0;
        while ( p1 != null || p2 != null || add != 0 ){
            int sum = 0;
            if ( p1 != null ){
                sum += p1.val;
                p1 = p1.next;
            }
            if ( p2 != null ){
                sum += p2.val;
                p2 = p2.next;
            }

            sum += add;

            if ( sum >= 10 ){
                add = sum / 10;
                p.next = new Node( sum % 10);
            }else {
                p.next = new Node( sum );
            }
            p = p.next;


        }
        return dummy.next;
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
     * 并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }

        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
