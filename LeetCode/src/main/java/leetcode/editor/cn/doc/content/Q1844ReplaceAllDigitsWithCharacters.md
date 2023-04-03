<p>给你一个下标从 <strong>0</strong>&nbsp;开始的字符串 <code>s</code>&nbsp;，它的 <strong>偶数</strong> 下标处为小写英文字母，<strong>奇数</strong>&nbsp;下标处为数字。</p>

<p>定义一个函数&nbsp;<code>shift(c, x)</code>&nbsp;，其中&nbsp;<code>c</code>&nbsp;是一个字符且&nbsp;<code>x</code>&nbsp;是一个数字，函数返回字母表中&nbsp;<code>c</code>&nbsp;后面第 <code>x</code>&nbsp;个字符。</p>

<ul> 
 <li>比方说，<code>shift('a', 5) = 'f'</code>&nbsp;和&nbsp;<code>shift('x', 0) = 'x'</code>&nbsp;。</li> 
</ul>

<p>对于每个 <strong>奇数</strong>&nbsp;下标&nbsp;<code>i</code>&nbsp;，你需要将数字&nbsp;<code>s[i]</code> 用&nbsp;<code>shift(s[i-1], s[i])</code>&nbsp;替换。</p>

<p>请你替换所有数字以后，将字符串 <code>s</code>&nbsp;返回。题目 <strong>保证</strong><em>&nbsp;</em><code>shift(s[i-1], s[i])</code>&nbsp;不会超过 <code>'z'</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>s = "a1c1e1"
<b>输出：</b>"abcdef"
<strong>解释：</strong>数字被替换结果如下：
- s[1] -&gt; shift('a',1) = 'b'
- s[3] -&gt; shift('c',1) = 'd'
- s[5] -&gt; shift('e',1) = 'f'</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>s = "a1b2c3d4e"
<b>输出：</b>"abbdcfdhe"
<strong>解释：</strong>数字被替换结果如下：
- s[1] -&gt; shift('a',1) = 'b'
- s[3] -&gt; shift('b',2) = 'd'
- s[5] -&gt; shift('c',3) = 'f'
- s[7] -&gt; shift('d',4) = 'h'</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 100</code></li> 
 <li><code>s</code>&nbsp;只包含小写英文字母和数字。</li> 
 <li>对所有 <strong>奇数</strong> 下标处的&nbsp;<code>i</code>&nbsp;，满足&nbsp;<code>shift(s[i-1], s[i]) &lt;= 'z'</code>&nbsp;。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串</details><br>

<div>👍 17, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

</div>



