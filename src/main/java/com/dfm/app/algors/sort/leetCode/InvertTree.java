package com.dfm.app.algors.sort.leetCode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 * @Author:fengming.dai
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //前序遍历,根节点 开始就 交换 左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //把 左右子树 也交换
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
