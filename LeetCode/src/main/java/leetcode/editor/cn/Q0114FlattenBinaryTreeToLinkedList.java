package leetcode.editor.cn;

import gnu.crypto.cipher.Rijndael;

/**
 * @author  fengming.dai 
 * @date    2023-02-24 14:40:11 
 */
 public class Q0114FlattenBinaryTreeToLinkedList{
 //给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics栈 | 树 | 深度优先搜索 | 链表 | 二叉树 
//
// 👍 1392, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0114FlattenBinaryTreeToLinkedList().new Solution();    
 }    

 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        divide(root);
    }

    //函数定义： 将root 根据 前序 组合为 链表
    public void divide(TreeNode root){
        if ( root == null ){
            return ;
        }
        // 把左右 子树 都拉为 链表
        divide(root.left);
        divide(root.right);

        //由于 前序， 把拉平后的 左子树 接入 root.right
        // 然后把 拉平后的 右子树，接在 最下面

        // 1、左右子树已经被拉平成一条链表
        TreeNode afterLeft = root.left;
        TreeNode afterRight = root.right;

        // 2、将左子树作为右子树
        root.right = afterLeft;
        root.left = null;


        //3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        //这里 注意要 p.right != null
        while ( p.right != null ){
            p = p.right;
        }
        p.right = afterRight;



    }


    /**
     * 遍历方法, 除非 使用 新链表，暂无法实现
     */
    TreeNode pre = null;
    public void preOrder(TreeNode root){
        if ( root == null ){
            return;
        }
        if ( pre == null ){
            pre = root;
        }else {
            // 这里会 影响 接下来的 递归
            pre.left = null;
            pre.right = root;
        }
        preOrder(root.left);
        preOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

 }