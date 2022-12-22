package leetcode.editor.cn.chatGPT;

/**
 * @Author:fengming.dai
 */
public class A {

    /**
     * 如果节点为空，则返回空。
     *
     * 如果当前节点是给定的节点之一，则返回该节点。
     *
     * 否则，递归地查找左右子树中的LCA。如果左右子树的LCA都不为空，则当前节点是LCA，因为它是左右子树中给定节点的祖先。如果只有一个子树的LCA不为空，则返回该子树的LCA，因为它是给定节点的祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//        if (root == p || root == q) {
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left != null && right != null) {
//            return root;
//        }
//        return left != null ? left : right;
//    }

}
