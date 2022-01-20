package com.dfm.his.leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author dfm
 * @create 2020-09-28 14:52
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] fix = new int[]{9,3,15,20,7};
        node ans = solution(pre,fix);
        levelOrder(ans);
    }

    private static void levelOrder(node root){
        if(root == null)return;
        LinkedList<node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            node poll = queue.poll();
            System.out.println(poll.val);
            if(poll.left != null)queue.offer(poll.left);
            if(poll.right != null)queue.offer(poll.right);
        }
    }

    private static node solution(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        int len = preorder.length;
        node root = build(preorder,inorder,map,0,len-1,0,len-1);
        return root;
    }

    private static node build(int[] preorder, int[] inorder, Map<Integer, Integer> map,int preStart,
                              int preEnd,int inStart,int inEnd) {
        if(preStart > preEnd){//没有节点了
            return null;
        }
        int rootVal = preorder[preStart];
        int index = map.get(rootVal);
        node root = new node(rootVal);
        if(preEnd == preStart){//只有一个节点
            return root;
        }else {//还有多个节点
            int leftNodes = index - inStart;//root的左子树 有多少个节点。
            int rightNodes = inEnd - index;
            node leftsub = build(preorder,inorder,map,preStart+1,preStart+leftNodes,inStart,index-1   );
            node rightsub = build(preorder,inorder,map,preEnd-rightNodes+1,preEnd,index+1,inEnd  );
            root.left = leftsub;
            root.right = rightsub;
            return root;
        }
    }

}
class node{
    int val;
    node left;
    node right;
    node(int x){this.val = x;}
}
