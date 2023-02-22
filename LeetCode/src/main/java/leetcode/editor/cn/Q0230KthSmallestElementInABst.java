package leetcode.editor.cn;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  fengming.dai 
 * @date    2023-02-22 19:23:43 
 */
 public class Q0230KthSmallestElementInABst{
 //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
//
// Related Topics树 | 深度优先搜索 | 二叉搜索树 | 二叉树 
//
// 👍 707, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0230KthSmallestElementInABst().new Solution();    
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

    public int kthSmallest(TreeNode root, int k) {
        return smart(root,k);
    }
    int ans;
    int rank = 0;
    public int smart(TreeNode root,int k){
        if ( root == null){
            return -1;
        }
        rank = k;
        middleOrderPuring(root);
        return ans;
    }

    private void middleOrderPuring(TreeNode root) {
        if (root == null){
            return;
        }

        middleOrder(root.left);

        rank--;
        if (rank == 0){
            //说明 升序遍历 到了 第 rank 个。rank = k
            ans = root.val;
            return;
        }

        middleOrder(root.right);
    }

    //记录中序遍历结果。 中序为 升序
    List<Integer> list = new ArrayList<>();
    public int stupid(TreeNode root , int k){
        middleOrder(root);
        return list.get(k-1);
    }

    public void middleOrder(TreeNode root){
        if (root == null)return;

        middleOrder(root.left);
        list.add(root.val);
        middleOrder(root.right);
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