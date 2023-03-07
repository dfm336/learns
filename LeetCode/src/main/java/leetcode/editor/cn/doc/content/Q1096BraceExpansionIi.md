<p>如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。</p>

<p>花括号展开的表达式可以看作一个由 <strong>花括号</strong>、<strong>逗号</strong> 和 <strong>小写英文字母</strong> 组成的字符串，定义下面几条语法规则：</p>

<ul> 
 <li>如果只给出单一的元素&nbsp;<code>x</code>，那么表达式表示的字符串就只有&nbsp;<code>"x"</code>。<code>R(x) = {x}</code> </li>
</ul>

    <ul>
    	<li>例如，表达式 <code>"a"</code> 表示字符串 <code>"a"</code>。</li>
    	<li>而表达式 <code>"w"</code> 就表示字符串 <code>"w"</code>。</li>
    </ul>
    </li>
    <li>当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。<code>R({e_1,e_2,...}) = R(e_1)&nbsp;∪ R(e_2)&nbsp;∪ ...</code>
    <ul>
    	<li>例如，表达式 <code>"{a,b,c}"</code> 表示字符串&nbsp;<code>"a","b","c"</code>。</li>
    	<li>而表达式 <code>"{{a,b},{b,c}}"</code> 也可以表示字符串&nbsp;<code>"a","b","c"</code>。</li>
    </ul>
    </li>
    <li>要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。<code>R(e_1 + e_2) = {a + b for (a, b) in&nbsp;R(e_1)&nbsp;× R(e_2)}</code>
    <ul>
    	<li>例如，表达式 <code>"{a,b}{c,d}"</code> 表示字符串&nbsp;<code>"ac","ad","bc","bd"</code>。</li>
    </ul>
    </li>
    <li>表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
    <ul>
    	<li>例如，表达式 <code>"a{b,c,d}"</code> 表示字符串&nbsp;<code>"ab","ac","ad"​​​​​​</code>。</li>
    	<li>例如，表达式 <code>"a{b,c}{d,e}f{g,h}"</code> 可以表示字符串&nbsp;<code>"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"</code>。</li>
    </ul>
    </li>


<p>给出表示基于给定语法规则的表达式&nbsp;<code>expression</code>，返回它所表示的所有字符串组成的有序列表。</p>

<p>假如你希望以「集合」的概念了解此题，也可以通过点击 “<strong>显示英文描述</strong>” 获取详情。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>expression = "{a,b}{c,{d,e}}"
<strong>输出：</strong>["ac","ad","ae","bc","bd","be"]</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>expression = "{{a,z},a{b,c},{ab,z}}"
<strong>输出：</strong>["a","ab","ac","z"]
<strong>解释：</strong>输出中 <strong>不应 </strong>出现重复的组合结果。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= expression.length &lt;= 60</code></li> 
 <li><code>expression[i]</code> 由 <code>'{'</code>，<code>'}'</code>，<code>','</code>&nbsp;或小写英文字母组成</li> 
 <li>给出的表达式&nbsp;<code>expression</code>&nbsp;用以表示一组基于题目描述中语法构造的字符串</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 广度优先搜索 | 字符串 | 回溯</details><br>

<div>👍 148, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**

</div>



