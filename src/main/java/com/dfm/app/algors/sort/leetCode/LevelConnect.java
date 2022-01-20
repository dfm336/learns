package com.dfm.app.algors.sort.leetCode;

/**
 * 连接二叉树 每一层 节点
 * @Author:fengming.dai
 */
public class LevelConnect {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        travse(root.left,root.right);
        return root;
    }
    //连接 传入的 两个节点
    private void travse(Node left, Node right) {
        if (left == null || right == null){
            return;
        }

        left.next = right;

        travse(left.left,left.right);
        travse(right.left,right.right);
        travse(left.right,right.left);
    }
}
