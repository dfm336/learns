package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-21 17:30:51 
 */
 public class Q0092ReverseLinkedListIi{
 //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics链表 
//
// 👍 1500, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0092ReverseLinkedListIi().new Solution();
 	ListNode node = new ListNode(1,
            new ListNode(2,
                    new ListNode(3,
                            new ListNode(4,
                                    new ListNode(5)))));
     ListNode reverseBetween = solution.reverseBetween(node, 2, 4);
     ListNode reverseN = solution.reverseN(node, 3);

     ListNode p = reverseBetween;
     System.out.println("res:");
     while (p != null){
         System.out.println(p.val);
         p = p.next;
     }
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){
            return null;
        }
        // 找到 需要交换的 起点
        ListNode p = head;
        for (int i = 0; i < left - 1; i++) {
           p = p.next;
        }
        print(p);
        ListNode tmp = p;
        ListNode start = reverseN(tmp.next, right - left + 1);

        p.next = start;
        return head;

    }

    public void print(ListNode root){
        ListNode p = root;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    //记录 翻转后 的 下一个节点
    ListNode post = null;

    /**
     * 翻转 以head为起点 往后n个节点的 链表， 返回 翻转后的 起点。
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseN(ListNode head,int n) {
        if  ( n == 1){
            //记录 翻转后 下一个节点
            post = head.next;
            return head;
        }
        //这里 返回的 是  head.next 为起点的 单链表.
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        //此时 head是 尾巴， 要 指向 原来的下一个节点
        head.next = post;

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

 }