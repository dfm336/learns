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


//    int left = 0, right = 0;
//
//    while (right < s.size()) {
//        // 增大窗口
//        window.add(s[right]);
//        right++;
//
//        while (window needs shrink) {
//            // 缩小窗口
//            window.remove(s[left]);
//            left++;
//        }
//    }

    /* 滑动窗口算法框架 */
//    void slidingWindow(string s) {
//        unordered_map<char, int> window;
//
//        int left = 0, right = 0;
//        while (right < s.size()) {
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 增大窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//        ...
//
//            /*** debug 输出的位置 ***/
//            // 注意在最终的解法代码中不要 print
//            // 因为 IO 操作很耗时，可能导致超时
//            printf("window: [%d, %d)\n", left, right);
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 缩小窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
//        }
//    }
}
