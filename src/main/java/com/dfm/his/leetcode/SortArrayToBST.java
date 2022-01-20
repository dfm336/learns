package com.dfm.his.leetcode;

import java.util.LinkedList;

/**
 * @author dfm
 * @create 2020-10-08 18:36
 */
public class SortArrayToBST {
    public static void main(String[] args) {
        int[] arr = new int[]{-10,-3,0,5,9};
        TreeNode108 root = solution(arr,0,arr.length-1);
        leverOrder(root);
    }

    private static TreeNode108 solution(int[] arr,int left,int right) {
        if(left >right)return null;
        int mid = (left+right)/2;
        TreeNode108 root = new TreeNode108(arr[mid]);
        root.left = solution(arr,left,mid-1);
        root.right = solution(arr,mid+1,right);
        return root;
    }
    private static  void  leverOrder(TreeNode108 root){
        if(root == null)return;
        LinkedList<TreeNode108> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()){
            TreeNode108 poll = queue.poll();
            System.out.println(poll.val);
            if(poll.left != null)queue.add(poll.left);
            if(poll.right != null)queue.add(poll.right);
        }
    }
}
class TreeNode108{
    int val;
    TreeNode108 left;
    TreeNode108 right;
    TreeNode108(int x){this.val = x;}
}

