package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-23 18:58:36 
 */
 public class Q0104MaximumDepthOfBinaryTree{
 //给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树 
//
// 👍 1513, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0104MaximumDepthOfBinaryTree().new Solution();    
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
    public int maxDepth(TreeNode root) {
//        recursion(root);
        return fmax(root);
    }

    //函数定义： 返回 一棵树 的 最深c层级
    public int fmax(TreeNode root){
        //base case
        if ( root == null ){
            return 0;
        }
        //获取左右 子树 的 最深 + 1， 当前节点 也算 1 层
        return Math.max( fmax(root.left), fmax(root.right)) + 1;
    }

    int maxDepth = 0;
    int curDepth = 0;
    public void recursion(TreeNode root){
        if ( root == null ){
            return;
        }
        //进入 节点前 +1
        curDepth++;
        recursion(root.left);
        //至于对 res 的更新，你放到前中后序位置都可以，只要保证在进入节点之后，离开节点之前（即 depth 自增之后，自减之前）就行了。
        if ( curDepth > maxDepth){
            maxDepth = curDepth;
        }

        recursion(root.right);

        curDepth--;
        //离开节点 前 -1
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