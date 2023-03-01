package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-21 16:54:10 
 */
 public class Q0025ReverseNodesInKGroup{
 //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics递归 | 链表 
//
// 👍 1920, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0025ReverseNodesInKGroup().new Solution();    
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

//        public ListNode reverseKGroup(ListNode head, int k) {
//            if (head == null) return null;
//            // 区间 [a, b) 包含 k 个待反转元素
//            ListNode a, b;
//            a = b = head;
//            for (int i = 0; i < k; i++) {
//                // 不足 k 个，不需要反转，base case
//                if (b == null) return head;
//                b = b.next;
//            }
//            // 反转前 k 个元素
//            ListNode newHead = reverse(a, b);
//            // 递归反转后续链表并连接起来
//            a.next = reverseKGroup(b, k);
//            return newHead;
//        }

        /* 反转区间 [a, b) 的元素，注意是左闭右开 */
//        ListNode reverse(ListNode a, ListNode b) {
//            ListNode pre, cur, nxt;
//            pre = null;
//            cur = a;
//            nxt = a;
//            // while 终止的条件改一下就行了
//            while (cur != b) {
//                nxt = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = nxt;
//            }
//            // 返回反转后的头结点
//            return pre;
//        }

    /**
     *  迭代 实现  翻转 以head 为头结点 的链表
     *
     *  也可以 理解为： 翻转 以 head为头结点， null 结束的 尾节点。
     * @param head
     * @return
     */
    ListNode reverseByIterate(ListNode head){
        //翻转节点， 需要 记录  pre, cur， next 关系
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;

        //利用 cur 当前指针 遍历, 每次 翻转当前 的 next
        while ( cur != null ){
            //找到 当前节点的 next 节点
            next = cur.next;
            //逐个 翻转
            cur.next = pre;


            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 翻转 链表 区间【start,end] ，其他正常
     *
     * 借助 翻转 单链表的 实现， 把 结束 位置 改为  end 就好
     * @param start
     * @return
     */
    ListNode reverseIntervalByIterate(ListNode start, ListNode end){
        //翻转节点， 需要 记录  pre, cur， next 关系
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = start;

        //利用 cur 当前指针 遍历, 每次 翻转当前 的 next
        while ( cur != end ){
            //找到 当前节点的 next 节点
            next = cur.next;
            //逐个 翻转
            cur.next = pre;


            pre = cur;
            cur = next;
        }
        return pre;
    }



    /**
     *  递归 实现  翻转 以head 为头结点 的链表
     *  定义： 翻转链表，返回头结点
     * @param head
     * @return
     */
    ListNode reverseByRecursion(ListNode head){
        //base case 只有一个节点
        if ( head  != null && head.next != null ){
            return head;
        }

        ListNode last = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 递归定义： k个一组翻转 链表 并返回 头结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null){
            return null;
        }
        //用来记录 head位置，翻转前k个后， head 则成为 尾节点
        ListNode tail = head;
        //base case 不足k个
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if ( p == null){
                //不足 k个， 不翻转
                return head;
            }else {
                p = p.next;
            }
        }
        //翻转 前k个，返回 翻转后的 头结点
        ListNode newHead = reverseIntervalByIterate(head, p);
        //继续翻转 后面的
        ListNode node = reverseKGroup(p, k);

        //翻转后 前k个 尾节点 连上 ， 后续 翻转后的 头结点
        tail.next = node;

        //k个一组翻转的 头节点
        return newHead;
    }

}


//
//
//    /**
//     * 翻转 一个链表的  a节点 和 b 节点
//     * @param a
//     * @param b
//     * @return
//     */
//    public ListNode reverseInterval(ListNode a, ListNode b){
//
//    }
//
//    public ListNode reverseListNode(ListNode head){
//        if ( head == null || head.next ==null){
//            return head;
//        }
//
//        ListNode start = reverseListNode(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return start;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
       class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
 }