package com.dfm.app.algors.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author:fengming.dai
 */
public class TreeTest {
    public static void main(String[] args){

    }

    //前 根左右{
    public static void pre(Node root){
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        pre(root.left);
        pre(root.right);
    }

    //中  左根右

    //后  左右跟

    //层 queue
    public static void level(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i=0;i<queue.size();i++){
                Node node = queue.poll();
                System.out.println(node.value);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }

        }
    }


}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}