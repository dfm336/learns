package leetcode.editor.cn.base;

import java.util.LinkedList;

/**
 * @Author:fengming.dai
 */
public class Node {

//     public class ListNode {
//          int val;
//          ListNode next;
//          ListNode() {}
//          ListNode(int val) { this.val = val; }
//          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     }


//      public class TreeNode {
//          int val;
//          TreeNode left;
//          TreeNode right;
//          TreeNode() {}
//          TreeNode(int val) { this.val = val; }
//          TreeNode(int val, TreeNode left, TreeNode right) {
//              this.val = val;
//              this.left = left;
//              this.right = right;
//          }
//      }

    //二叉树遍历框架
//    void traverse(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        // 前序位置
//        traverse(root.left);
//        // 中序位置
//        traverse(root.right);
//        // 后序位置
//    }



    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
//    void levelTraverse(TreeNode root) {
//        if (root == null) return;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        // 从上到下遍历二叉树的每一层
//        while (!q.isEmpty()) {
//            int sz = q.size();
//            // 从左到右遍历每一层的每个节点
//            for (int i = 0; i < sz; i++) {
//                TreeNode cur = q.poll();
//                // 将下一层节点放入队列
//                if (cur.left != null) {
//                    q.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    q.offer(cur.right);
//                }
//            }
//        }
//    }
}
