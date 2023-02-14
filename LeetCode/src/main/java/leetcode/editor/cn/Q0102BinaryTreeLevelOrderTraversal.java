package leetcode.editor.cn;

import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-02-13 17:22:34 
 */
 public class Q0102BinaryTreeLevelOrderTraversal{
 //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 广度优先搜索 | 二叉树 
//
// 👍 1567, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0102BinaryTreeLevelOrderTraversal().new Solution();
 	TreeNode root = new TreeNode(3,
            new TreeNode(9,
                    new TreeNode(15),new TreeNode(7)
            ),
            new TreeNode(20)
    );
 	solution.preOrder(root);
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }

    //前序
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
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