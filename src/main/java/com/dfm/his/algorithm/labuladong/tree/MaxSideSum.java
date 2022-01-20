package com.dfm.his.algorithm.labuladong.tree;

/**
 * 二叉树中最大路径和（任意节点出发）
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @Author:fengming.dai
 */
public class MaxSideSum {
    public static void main(String[] args) {

    }
    public static int max = Integer.MIN_VALUE;

    /**
     * 递归定义：计算当前节点的单边路径最大和
     *
     * @param root
     * @return
     */
    public static int maxSideSum(TreeNode root){
        if (root == null){
            return  0;
        }
        //这两处 调用 max 比较是截断 负数
        int left = Math.max(0,maxSideSum(root.left));
        int right = Math.max(0,maxSideSum(root.right));
        //如果 当前节点的 left+right + root.val  > max
        //因为可以 任意节点出发，此时的 max 肯定是 三个节点值  都用到
        max = Math.max(max,left+right+root.val);
        //定义的是 单边最大路径，只能选择 root+ max(left,right)
        return Math.max(left,right) + root.val;
    }
    /**
     * 其实就是每一步 max(left,right)+root.val
     * @param node
     * @param max
     * @return
     */
    public static int maxPathSum(TreeNode node,Integer max){
        if (node == null){
            return max;
        }
        int left = maxPathSum(node.left,max);
        int right = maxPathSum(node.right,max);
        max = Math.max(left,right) + node.val;
        return max;
    }
}
