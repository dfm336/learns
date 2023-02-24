package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author  fengming.dai 
 * @date    2023-02-24 11:50:00 
 */
 public class Q0116PopulatingNextRightPointersInEachNode{
 //给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
// 
//
// 示例 2: 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在
// [0, 2¹² - 1] 范围内 
// -1000 <= node.val <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 链表 | 二叉树 
//
// 👍 951, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0116PopulatingNextRightPointersInEachNode().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
//        levelOrder(root);
        if ( root == null)return null;
        connectTwoNode(root.left,root.right);
        return root;
    }

    //链接传入的 两个node
    public void connectTwoNode(Node left, Node right){
        if ( left == null || right == null ){
            return;
        }

        left.next = right;

        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left,right.right);
        //链接两k棵树
        connectTwoNode(left.right, right.left);
        return;

    }

    //利用层序 遍历
    public void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while ( !queue.isEmpty() ){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                if ( poll.left != null ){
                    queue.offer( poll.left );
                }
                if ( poll.right != null ){
                    queue.offer( poll.right );
                }

                if ( pre != null ){
                    pre.next = poll;
                    pre = poll;
                }else if (i == 0){
                    pre = poll;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

 }