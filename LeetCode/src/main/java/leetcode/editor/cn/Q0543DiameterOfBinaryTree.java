package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-23 19:16:46 
 */
 public class Q0543DiameterOfBinaryTree{
 //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
//
// Related Topics树 | 深度优先搜索 | 二叉树 
//
// 👍 1245, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0543DiameterOfBinaryTree().new Solution();    
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

    public int diameterOfBinaryTree(TreeNode root) {
        reverse(root);
        return max;
    }

    int max = 0;

    // 获取当前 二叉树 的 最大直径
    //每一颗 二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
    private int reverse(TreeNode root) {
        if ( root == null){
            return 0;
        }
        int leftDepth = reverse(root.left);
        int rightDepth = reverse(root.right);
        //后序 位置
        if ( leftDepth + rightDepth > max ){
            max = leftDepth + rightDepth;
        }
        // 某刻子树 的 最大直径  就是 最大深度。 这里要按照 获取深度 返回
        return 1 + Math.max(leftDepth,rightDepth);
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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