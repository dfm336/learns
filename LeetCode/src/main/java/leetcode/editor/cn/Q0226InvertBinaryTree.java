package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-23 19:44:26 
 */
 public class Q0226InvertBinaryTree{
 //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
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
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1508, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0226InvertBinaryTree().new Solution();    
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

    public TreeNode invertTree(TreeNode root) {
        visit(root);
        return root;
    }

    // 遍历思路
    public void visit(TreeNode root){
        if ( root == null){
            return;
        }

        //q前序  ，访问节点时 就 交换左右z子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        visit(root.left);
        visit(root.right);
    }

    // 分解问题 思路
    //定义： 镜像翻转 root 的 左右子树。并返回根节点
    public TreeNode reverse(TreeNode root){
        if ( root == null ){
            return null;
        }
        TreeNode leftRoot = reverse(root.left);
        TreeNode rightRoot = reverse(root.right);
        //翻转
        root.left = rightRoot;
        root.right = leftRoot;
        return root;
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