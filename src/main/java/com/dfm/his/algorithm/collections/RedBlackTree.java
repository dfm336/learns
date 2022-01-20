package com.dfm.his.algorithm.collections;

public class RedBlackTree {
	private static final int R = 0;
	private static final int B = 1;
	
	//根节点
	private final Node root = null;
	 
	class Node{
		int data;
		int color;
		Node left;
		Node ritht;
		Node parent;
		Node(int data){
			this.data = data;
		}
	}
	
	/**
	 * 
	 * @param root 根节点
	 * @param data 插入的数据
	 * 默认 root ！= null;
	 */
	public void insert(Node root,int data) {
		if(root.data < data) {
			if(root.ritht == null) {
				root.ritht = new Node(data);
			}else {
				insert(root.ritht, data);
			}
		}else {
			if(root.left == null) {
				root.left = new Node(data);
			}else {
				insert(root.left, data);
			}
		}
	}
	/**
	 * 左旋
	 * @param root
	 */
	public void leftRotate(Node root) {
		//是否为根节点
		if(root.parent == null) {
			Node e =root;
			Node s = root.ritht;
			
			e.ritht = s.left;
			s.left.parent = e;
			
			e.parent  = s;
			
			s.parent = null;//设为根节点
			
			
		}
	}
}
