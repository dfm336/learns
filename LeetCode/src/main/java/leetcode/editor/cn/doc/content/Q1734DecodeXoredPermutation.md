<p>给你一个整数数组&nbsp;<code>perm</code>&nbsp;，它是前&nbsp;<code>n</code>&nbsp;个正整数的排列，且&nbsp;<code>n</code>&nbsp;是个 <strong>奇数</strong>&nbsp;。</p>

<p>它被加密成另一个长度为 <code>n - 1</code>&nbsp;的整数数组&nbsp;<code>encoded</code>&nbsp;，满足&nbsp;<code>encoded[i] = perm[i] XOR perm[i + 1]</code>&nbsp;。比方说，如果&nbsp;<code>perm = [1,3,2]</code>&nbsp;，那么&nbsp;<code>encoded = [2,1]</code>&nbsp;。</p>

<p>给你&nbsp;<code>encoded</code>&nbsp;数组，请你返回原始数组&nbsp;<code>perm</code>&nbsp;。题目保证答案存在且唯一。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>encoded = [3,1]
<b>输出：</b>[1,2,3]
<b>解释：</b>如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>encoded = [6,5,4,6]
<b>输出：</b>[2,4,1,5,3]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>3 &lt;= n &lt;&nbsp;10<sup>5</sup></code></li> 
 <li><code>n</code>&nbsp;是奇数。</li> 
 <li><code>encoded.length == n - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>

<div>👍 161, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

</div>



