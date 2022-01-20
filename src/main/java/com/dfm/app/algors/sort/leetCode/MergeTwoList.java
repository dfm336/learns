package com.dfm.app.algors.sort.leetCode;

import java.util.PriorityQueue;

/**
 * @Author:fengming.dai
 */
public class MergeTwoList {
    /**
     * 合并 k 个有序 链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode virtualHead = new ListNode(-1);
        ListNode p = virtualHead;
        //利用最小堆 每次取 最小的node。指定 排序元素 为 val
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length,(node1,node2) -> (node1.val - node2.val)
        );
        //把 k个 链表的 头结点  入 最小堆
        for (ListNode node : lists){
            if (node != null){
                priorityQueue.add(node);
            }
        }
        //最小堆 为空 则放入了 所有元素
        while ( !priorityQueue.isEmpty()){
            ListNode minNode = priorityQueue.poll();
            p.next = minNode;
            //把 比较最小的 链表 往后移
            if (minNode.next != null){
                priorityQueue.add(minNode.next);
            }
            p = p.next;
        }

        return virtualHead.next;
    }

    /**
     * 合并两个有序连表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //使用虚拟节点  来避免 选择头结点 计算
        ListNode virtualHead = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p = virtualHead;
        while (p1 != null && p2 != null){
            //指定 p.next 为谁
            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        //两个 有序连表，剩下的 某个 链表部分 肯定是有序，拼接上去就好

        if (p1 != null){
            p.next = p1;
        }

        if (p2 != null){
            p.next = p2;
        }
        return virtualHead.next;
    }
}
