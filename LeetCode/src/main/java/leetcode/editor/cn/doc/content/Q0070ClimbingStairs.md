<p>假设你正在爬楼梯。需要 <code>n</code>&nbsp;阶你才能到达楼顶。</p>

<p>每次你可以爬 <code>1</code> 或 <code>2</code> 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 2
<strong>输出：</strong>2
<strong>解释：</strong>有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>3
<strong>解释：</strong>有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 45</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>记忆化搜索 | 数学 | 动态规划</details><br>

<div>👍 2867, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 17 期刷题打卡挑战](https://aep.xet.tech/s/2jPp5X) 下周开始，报名从速！。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题属于最基本的动态规划，建议先看下前文 [动态规划框架详解](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)。

这题很像 [509. 斐波那契数](/problems/fibonacci-number)：爬到第 `n` 级台阶的方法个数等于爬到 `n - 1` 的方法个数和爬到 `n - 2` 的方法个数之和。

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    // 备忘录
    int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return dp(n);
    }

    // 定义：爬到第 n 级台阶的方法个数为 dp(n)
    int dp(int n) {
        // base case
        if (n <= 2) {
            return n;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        // 状态转移方程：
        // 爬到第 n 级台阶的方法个数等于爬到 n - 1 的方法个数和爬到 n - 2 的方法个数之和。
        memo[n] = dp(n - 1) + dp(n - 2);
        return memo[n];
    }
}
```

**类似题目**：
  - [剑指 Offer 10- II. 青蛙跳台阶问题 🟢](/problems/qing-wa-tiao-tai-jie-wen-ti-lcof)

</details>
</div>



