package leetcode.editor.cn.base;

import lombok.Data;

/**
 * @Author:fengming.dai
 */
@Data
public class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


//      public class ListNode {
//          int val;
//          ListNode next;
//         ListNode() {}
//         ListNode(int val) { this.val = val; }
//         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     }


//      public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//          TreeNode(int val) { this.val = val; }
//          TreeNode(int val, TreeNode left, TreeNode right) {
//              this.val = val;
//              this.left = left;
//              this.right = right;
//          }
//      }

}
