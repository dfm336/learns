package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-03-02 17:21:58 
 */
 public class Q0105ConstructBinaryTreeFromPreorderAndInorderTraversal{
 //给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics树 | 数组 | 哈希表 | 分治 | 二叉树 
//
// 👍 1884, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//
    
 public static void main(String[] args) {        
 	Solution solution = new Q0105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();    
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        //base case 终止条件
        if (preStart > preEnd) return null;

        //前序第一个 作为 根节点
        int root = preorder[preStart];
        //找到 在中序的位置, 合理的树 一定存在. 这里可以 优化为 map 直接查找， key:value, value: index
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (  inorder[i] == root){
                index = i;
                break;
            }
        }
        //前序 范围就是  在  根节点后 在连续数 中序根节点 本次左边的个数
        int leftSize = index - inStart;
        TreeNode node = new TreeNode(root);
        //前序数组的  左边范围 是 从起点数  构建左子树 需要元素个数（ index - inStart)
        TreeNode leftNode = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
       // 前序数组 右边范围 在 左边用完的 剩下半截
        TreeNode rightNode = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd);
        node.left = leftNode;
        node.right = rightNode;
        return node;
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