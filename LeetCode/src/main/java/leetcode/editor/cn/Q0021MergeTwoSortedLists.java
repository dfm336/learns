package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-21 16:19:16 
 */
 public class Q0021MergeTwoSortedLists{
 //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics递归 | 链表 
//
// 👍 2926, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0021MergeTwoSortedLists().new Solution();    
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ( list1 == null && list2 == null){
            return null;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode res = new ListNode(-1);
        ListNode dumy = res;
        while ( p1 != null && p2 != null){
            if ( p1.val < p2.val ){
                dumy.next = new ListNode(p1.val);
                p1 = p1.next;
            }else {
                dumy.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            dumy = dumy.next;
        }

        while ( p1 != null ){
            dumy.next = new ListNode(p1.val);
            p1 = p1.next;
            dumy = dumy.next;
        }
        while ( p2 != null ){
            dumy.next = new ListNode(p2.val);
            dumy = dumy.next;
            p2 = p2.next;
        }

        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
          public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

 }