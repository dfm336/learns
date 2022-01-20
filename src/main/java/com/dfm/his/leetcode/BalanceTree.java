package com.dfm.his.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author dfm
 * @create 2020-09-22 14:38
 */
public class BalanceTree {



    /**
     * 1.左子树是平衡的
     * 2.右子树是平衡的
     * 3.深度之差 <1
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root){
        if(root == null)return true;
        if(!isBalanced(root.left))return false;
        if(!isBalanced(root.right))return false;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left-right) <= 1)return true;//只有符合1,2,3才返回true
        return false;
    }
    //递归得到深度
    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int countLeft = 0;
        int countRight = 0;
        countLeft = getDepth(root.left)+1;
        countRight = getDepth(root.right)+1;
        return Math.max(countLeft, countRight);
    }

    /**
     * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
     * 示例：
     * 输入：[1,2,3,4,5,null,7,8]
     *
     *         1
     *        /  \
     *       2    3
     *      / \    \
     *     4   5    7
     *    /
     *   8
     *
     * 输出：[[1],[2,3],[4,5,7],[8]]
     *
     * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
     * @param root
     * @return
     */
    public static ListNode[] listOfDepth(TreeNode root){
        List<ListNode> result = new ArrayList<ListNode>();
        dfs(root,result,1);
        ListNode[] listNodes = new ListNode[]{};
        ListNode[] ans = result.toArray(listNodes);
        return ans;
    }
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        levelByDfs(pRoot,1,ans);
        return ans;
    }

    private static void levelByDfs(TreeNode pRoot, int layer, ArrayList<ArrayList<Integer>> ans) {
        if(pRoot == null)return;
        if(layer > ans.size()){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pRoot.val);
            ans.add(list);
        }else {
            ArrayList<Integer> list = ans.get(layer - 1);
            list.add(pRoot.val);
        }
        levelByDfs(pRoot.left,layer+1,ans);
        levelByDfs(pRoot.right,layer+1,ans);
    }

    public static void dfs(TreeNode root,List<ListNode> result,int layer){
        if(root == null)return;
        if(layer > result.size()){//下一层的数据 需要新建一个
            ListNode listNode = new ListNode(root.val);
            result.add(listNode);
        }else{//上一层的数据
            ListNode p = result.get(layer-1);
            while (p.next != null)p=p.next;
            p.next = new ListNode(root.val);
        }
        dfs(root.left,result,layer+1);
        dfs(root.right,result,layer+1);
    }

    public static void insertTree(TreeNode root,int val){
        if(root == null)return;
        if(val > root.val){
            if(root.left != null)insertTree(root.left,val);
            else root.left = new TreeNode(val);
        }else {
            if(root.right != null)insertTree(root.right,val);
            else root.right = new TreeNode(val);
        }
    }


    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> print = Print(root);
        print.forEach(x->x.forEach(y-> System.out.print(y+" ")));
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){this.val = x;}
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

