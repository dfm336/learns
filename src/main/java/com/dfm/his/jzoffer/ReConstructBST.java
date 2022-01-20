package com.dfm.his.jzoffer;

import java.util.Arrays;

/**
 * @author dfm
 * @create 2020-11-29 13:29
 */
public class ReConstructBST {
    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};

        TreeNode head = solution(pre,in);
        preOrder(head);



    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }


    private static TreeNode solution(int[] pre, int[] in) {
        if(pre==null || in == null)return  null;
        if(pre.length == 0 || in.length == 0)return null;
        TreeNode root = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i] == root.val){
                root.left = solution(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0, i));
                root.right = solution(Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }

    private static void preOrder(TreeNode root){
        if(root == null )return;
        System.out.println(root.val);
        if(root.left!=null)preOrder(root.left);
        if(root.right!=null)preOrder(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){this.val=x;}
}
