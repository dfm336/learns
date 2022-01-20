package com.dfm.app.algors.sort.leetCode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author:fengming.dai
 */
public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ){
            return null;
        }
        //有一个节点 本身就是 root 节点，则返回root
        if (p == root || q == root){
            return root;
        }
        //得到 左子树中 的LCA
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //得到右子树 中的LCA
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //递归得到的 left，riht如果 不为 null，那么一定分别是 p 和 q。
        //一般这里可以确定，root是p，q的祖先，由于后序遍历，所以 类比 友p，q 往上走
        if (left != null && right != null){
            return root;
        }
        //说明 p，q都不在 root为 根节点 的 树中
        if (left == null && right == null){
            return  null;
        }
        //如果 只有一个 存在 以 root为根节点的 树中那么 那个就是答案
        return left == null ? right : left;
    }
}
