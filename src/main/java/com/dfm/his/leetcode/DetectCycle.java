package com.dfm.his.leetcode;

import java.util.HashSet;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 示例 1：
 输入：head = [3,2,0,-4], pos = 1
 输出：tail connects to node index 1
 解释：链表中有一个环，其尾部连接到第二个节点。
 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * @author dfm
 * @create 2020-09-23 22:33
 */
public class DetectCycle {
    public  static Node solution(Node head){
        if(head == null)return null;
        HashSet<Node> set = new HashSet<>();
        Node p = head;
        while (p != null){
            boolean add = set.add(p);
            if(!add){//添加失败 出现环
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     *  if (head == null || head.next == null) {
     *             return null;
     *         }
     *         ListNode slow = head, fast = head;
     *         while (fast != null && fast.next != null) {
     *             slow = slow.next;
     *             fast = fast.next.next;
     *             // 此处如果用if (slow != null && fast != null && slow.val == fast.val) 会超出时间限制
     *             if (slow == fast) {
     *                 break;
     *             }
     *         }
     *         if (fast == null || fast.next == null) {
     *             return null;
     *         }
     *
     *         // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
     *         slow = head;
     *         while (slow != fast) {
     *             slow = slow.next;
     *             fast = fast.next;
     *         }
     *         return slow;
     *
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/java-kuai-man-zhi-zhen-zhao-ru-kou-jie-dian-you-sh/
     * @param head
     * @return
     */
    //快慢 指针。有环则一定相
    public static Node niceSolution(Node head){
        //空节点   或者只有一个节点 不能成环
        if(head == null || head.next == null)return null;

        Node slow = head;
        Node fast = head;
        //只用关心快指针。快的能过。慢的一定能过
        while (fast != null && fast.next != null){
            //快慢指针，快一次走2步，慢的1步
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast)break;//有环
        }

        //无环退出情形 先判断 fast  再 fast.next
        if(fast == null || fast.next == null)return  null;

        //找位置，当找到环之后，slow从head出发，fast从相遇点出发，一次都走一步，再次相遇为环的入口点
        slow = head;
        while (slow  != fast){
            slow =slow.next;
            fast =fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
class Node{
    int val;
    Node next;
}