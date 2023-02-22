<p>给定一个二叉搜索树的根节点 <code>root</code> ，和一个整数 <code>k</code> ，请你设计一个算法查找其中第&nbsp;<code>k</code><strong>&nbsp;</strong>个最小元素（从 1 开始计数）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg" style="width: 212px; height: 301px;" /> 
<pre>
<strong>输入：</strong>root = [3,1,4,null,2], k = 1
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/28/kthtree2.jpg" style="width: 382px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [5,3,6,2,4,null,null,1], k = 3
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中的节点数为 <code>n</code> 。</li> 
 <li><code>1 &lt;= k &lt;= n &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 <code>k</code> 小的值，你将如何优化算法？</p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 707, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 下周开始，报名从速！。**



<p><strong><a href="https://labuladong.github.io/article?qno=230" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

BST 的中序遍历结果是有序的（升序），所以用一个外部变量记录中序遍历结果第 `k` 个元素即是第 `k` 小的元素。

**详细题解：[东哥带你刷二叉搜索树（特性篇）](https://labuladong.github.io/article/fname.html?fname=BST1)**

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)**

## 解法代码

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }
}
```

**类似题目**：
  - [1038. 从二叉搜索树到更大和树 🟠](/problems/binary-search-tree-to-greater-sum-tree)
  - [538. 把二叉搜索树转换为累加树 🟠](/problems/convert-bst-to-greater-tree)
  - [剑指 Offer 54. 二叉搜索树的第k大节点 🟢](/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof)
  - [剑指 Offer II 054. 所有大于等于节点的值之和 🟠](/problems/w6cpku)

</details>
</div>



