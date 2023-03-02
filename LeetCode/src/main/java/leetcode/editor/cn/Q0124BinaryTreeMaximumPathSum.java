package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-03-02 16:37:16 
 */
 public class Q0124BinaryTreeMaximumPathSum{
 //路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics树 | 深度优先搜索 | 动态规划 | 二叉树 
//
// 👍 1863, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0124BinaryTreeMaximumPathSum().new Solution();    
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

    Integer max = Integer.MIN_VALUE;
    //只返回 单边最大路径
    public  int maxSideSum(TreeNode root){
        if (root == null){
            return  0;
        }
        //这两处 调用 max 比较是截断 负数
        int left = Math.max(0,maxSideSum(root.left));
        int right = Math.max(0,maxSideSum(root.right));
        //如果 当前节点的 left+right + root.val  > max
        //因为可以 任意节点出发，此时的 max 肯定是 三个节点 max值  都用到
        max = Math.max(max,left+right+root.val);
        //定义的是 单边最大路径，只能选择 root+ max(left,right)
        return Math.max(left,right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)return 0;
        maxSideSum(root);
        return max;
//        //base case
//        if (root == null )return 0;
//        if (root.left == null && root.right == null) return root.val;
//
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//
//
//        // 若存在 负数 则 不取,， 必须经过 root 才能连起来
//        //可能的情形：
//        // 1. left
//        // 2. right
//        // 3. left + root.val
//        // 4. root.val
//        // 5. right + root.val
//        int uniLeft = root.val + left;
//        int uniRight = root.val + right;
//        List<Integer> list = Arrays.asList(left,root.val,right,uniLeft,uniRight);
//        Collections.sort(list);
//        return list.get(4);
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