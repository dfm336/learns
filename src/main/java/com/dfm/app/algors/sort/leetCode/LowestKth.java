package com.dfm.app.algors.sort.leetCode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @Author:fengming.dai
 */
public class LowestKth {
    //记录结果
    int res;
    //便于找到 第 k个，
    int rank = 0;
    /**
     * 利用 BST 的 中序遍历 为 升序
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        rank = k;
        midOrder(root);
        return  res;
    }

    private void midOrder(TreeNode root) {
        if (root == null){
            return;
        }
        midOrder(root.left);

        rank--;
        if (rank == 0){
            res = root.val;
            return;
        }

        midOrder(root.right );
    }
}
