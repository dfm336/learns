package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-09 17:57:31 
 */
 public class Q0206ReverseLinkedList{
 //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics递归 | 链表 
//
// 👍 2942, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0206ReverseLinkedList().new Solution();    
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

    //输入一个单链表头结点，将该链表反转，返回新的头结点
    public ListNode reverseList(ListNode head) {
//        //base case 只有一个节点，或者 本身为空
//        if (head == null ||  head.next == null){
//            return head;
//        }
//        //下个节点 翻转后
//        ListNode last = reverseList(head.next);
//        head.next.next  = head;
//        head.next = null;
        return reverse(head);
    }

    /**
     * 函数定义： 翻转node 后，返回 翻转后的 起点
     * 输入一个单链表头结点，将该链表反转，返回新的头结点
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node){
        //base case 只有一个节点，或者 本身为空
        if (node == null ||  node.next == null){
            return node;
        }
        //从下个节点 开始翻转后。 根据函数定义： node.next 之后的部分都被翻转了。
        //所以 只要 head.next 的 next 指向 当前节点， 由于当前节点 就是 翻转后的 尾巴，需要 把 尾巴的next = null
        ListNode last = reverse(node.next);
        node.next.next  = node;
        node.next = null;
        return last;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

 }