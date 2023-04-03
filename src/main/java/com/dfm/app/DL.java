package com.dfm.app;

public class DL {
    public static void main(String[] args) {

    }

//    public static TreeNodeDL getParent(TreeNodeDL root, TreeNodeDL node1, TreeNodeDL node2){
//        if ( root == null ) return null;
//        if ( node1 == node2 ){
//            return node1;
//        }
//        if ( node1 == root || node2 == root ) return root;
//
//        TreeNodeDL left = getParent(root.left, node1, node2);
//        TreeNodeDL right = getParent(root.right, node1, node2);
//
//        if ( left == null && right == null )return root;
//        if ( left == null && right != null ) return right;
//        if ( right == null && left != null ) return left;
//        if ( left == root || right == root ){
//            return root;
//        }
//
//
//
//    }


    static class TreeNodeDL{
        int val;
        TreeNodeDL left;
        TreeNodeDL right;
        public void TreeNode(int val ){
            this.val = val;
        }
    }



}
