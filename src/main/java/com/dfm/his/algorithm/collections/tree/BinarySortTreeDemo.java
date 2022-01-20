package com.dfm.his.algorithm.collections.tree;



import java.util.LinkedList;

public class BinarySortTreeDemo {
	public static void level(Node root){
		if(root == null){
			return ;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node node = queue.poll();
			System.out.println(node.value);
			if(node.left != null)queue.add(node.left);
			if(node.right != null)queue.add(node.right);
		}
	}


	public static void main(String[] args) {
		BinarySortTree binarySortTree = new BinarySortTree();
		int[] arr = {7,3,10,12,5,1,9,2};
		for (int data : arr) {
			Node node = new Node(data);
			binarySortTree.add(node);
		}
		binarySortTree.infixOrder();
		System.out.println("-----------");
		binarySortTree.reverseOrder();
		System.out.println("-----------");
//		binarySortTree.delete(12);
//		binarySortTree.delete(5);
//		binarySortTree.infixOrder();
		level(binarySortTree.getRoot());
	}
}
class BinarySortTree{
	public Node getRoot() {
		return root;
	}

	private Node root;
	public void add(Node node) {
		if(root == null) {
			root = node;
		}else {
			root.insert(node);
		}
	}
	public void preOrder() {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("Empty Tree!!!");
		}
	}
	public  void reverseOrder(){
		if(root != null){
			root.reverseOrder();
		}else System.out.println("Empty Tree!!!");
	}
	//中序
	public void infixOrder() {
		if(root != null) {
			root.infixOrder();
		}else {
			System.out.println("Empty Tree!!!");
		}
	}
	//层序
	public void levelOrder(){
		if(root != null){
			root.levelOrder();
		}else {
			System.out.println("Empty Tree!!!");
		}
	}
	public Node search(int value) {
		if(root==null)return null;
		return root.serch(value);
	}
	public Node serchParent(int value) {
		if(root==null)return null;
		return root.serchParent(value);
	}
	/**
	 * 找到 node节点 的 右子树中 最小节点值
	 * 并删除该节点
	 * @param node
	 * @return
	 */
	public int delRightTreeMin(Node node) {
		Node temp = node;
		while(temp.left != null) {
			temp = node.left;//左子树 的 value 一定比 原来小
		}
		delete(temp.value);
		return temp.value;
	}
	/**
	 * 找到 node节点 的 右子树中 最大节点值
	 * @param node
	 * @return
	 */
	private int delLeftTreeMax(Node node) {
		Node temp = node;
		while(temp.right!=null) {
			temp = temp.right;
		}
		delete(temp.value);
		return temp.value;
	}
	public void delete(int value) {
		if(root == null)return;
		else {
			Node targetNode = root.serch(value);
			Node targetNodeParent = root.serchParent(value);
			//需要删除的节点为空
			if(targetNode == null)return;
			//二叉树只有一个根节点  targerNode != null
			if(root.left==null && root.right==null) {
				root = null;
				return;
			}
			//为null 则说明  需要删除的节点为 根节点
			if(targetNodeParent != null) {//不是根节点
				//是 叶子节点
				if(targetNode.left==null && targetNode.right==null) {
					//是父节点 的 左子树
					if(targetNodeParent.left == targetNode) {
						targetNodeParent.left = null;
						return;
					}else {//是父节点的 右子树
						targetNodeParent.right = null;
						return;
					}
				}else {//不是叶子节点
					System.out.println("不是叶子节点");
					//有两颗子树
					if(targetNode.left!=null && targetNode.right!=null) {
						System.out.println("有两个子树");
						int min = delRightTreeMin(targetNode.right);
						targetNode.value = min;
					}else {//只剩下 有一个 子树 的情形
						if(targetNode.left!=null) {// 有 一颗 左子树
							//是父节点的 左子树
							if(targetNodeParent.left == targetNode) {
								targetNodeParent.left = targetNode.left;
							}else {//是父节点的  右子树
								targetNodeParent.right = targetNode.left;
							}
						}else {//有一颗 右子树
							//是父节点的 左子树
							if(targetNodeParent.left == targetNode) {
								targetNodeParent.left = targetNode.right;
							}else {//是父节点的  右子树
								targetNodeParent.right = targetNode.right;
							}
						}
					}
				}
			}else {//是根节点
				System.out.println("是 root");
				//根节点有两个子树
				if(targetNode.left!=null && targetNode.right!=null) {
					System.out.println("有两个子树");
					int min = delRightTreeMin(targetNode.right);
					targetNode.value = min;
				}else {//要么 一颗子树 要么没有子树
					if(targetNode.left !=null) {//targer.right 一定为null
						//找到左边最大的值改为根节点
						int max = delLeftTreeMax(targetNode.left);
						targetNode.value = max;
					}else if(targetNode.right != null) {//targer.left 一定为null
						//找到右边最小的值改为根节点
						int min = delRightTreeMin(targetNode.right);
						targetNode.value = min;
					}
				}
			}
		}
	}


}

class Node{
	int value;
	Node left;//默认 null
	Node right;//默认 null
	Node(int data){
		this.value = data;
	}
	/**
	 * 
	 * @param node 插入的节点
	 */
	public void insert(Node node) {
		if(node == null) {
			return;
		}
		if(node.value < this.value) {
			if(this.left == null) {
				this.left = node;
			}else {
				this.left.insert(node);
			}
		}else {//  node.value >= this.value
			if(this.right == null) {
				this.right = node;
			}else {
				this.right.insert(node);
			}
		}
	}
	/**
	 * 找到 指定value的节点并返回
	 * @param value 希望删除节点的value
	 * @return
	 */
	public Node serch(int value) {
		if(this.value == value) {
			return this;
		}
		if(value < this.value) {
				if(this.left == null)return null;
				return this.left.serch(value);
		}
		if(value > this.value) {
			if(this.right == null)return null;
			return this.right.serch(value);
		}
		return null;//原则上 不可能执行
	}
	/**
	 * 返回   值为value的节点 的  父节点
	 * @param value
	 * @return
	 */
	public Node serchParent(int value) {
		//如果当前 节点 就是  指定节点的 父节点
		if((this.left!=null && this.left.value == value) ||
				(this.right!=null && this.right.value==value)) {
			return this;
		}else {
			if(value < this.value && this.left!=null) {
				return this.left.serchParent(value);
			}else if(value >= this.value && this.right!=null) {
					return this.right.serchParent(value);
			}else {
				return null;
			}
		}
	}


	public void reverseOrder(){
		if(this.right != null){
			this.right.reverseOrder();
		}
		System.out.println(this.value);
		if(this.left != null)this.left.reverseOrder();
	}


	//中序遍历  左 根 右
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this.value);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	public  void preOrder(){
		System.out.println(this.value);
		if(this.left!=null)this.left.preOrder();
		if(this.right!=null)this.right.preOrder();
	}
	//层序  this == root
	public void levelOrder(){
		//root.levelOrder() 。root肯定不null
		LinkedList<Node> queue = new LinkedList<Node>();
		//根节点元素入队
		// offer()将指定元素添加到此列表的末尾（最后一个元素）。返回boolean
		queue.offer(this);
		int count = 0;//记录每层节点个数
		while (!queue.isEmpty()){
			//已经访问过出队。
			// 返回E 	poll()获取并移除此列表的头（第一个元素）
			Node poll = queue.poll();
			System.out.println(poll.value);
			if(this.left != null){
				queue.offer(poll.left);
			}
			if(this.right != null){
				queue.offer(poll.right);
			}
		}
	}
}