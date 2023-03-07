<p>给定一个数组 <code>prices</code> ，它的第&nbsp;<code>i</code> 个元素&nbsp;<code>prices[i]</code> 表示一支给定股票第 <code>i</code> 天的价格。</p>

<p>你只能选择 <strong>某一天</strong> 买入这只股票，并选择在 <strong>未来的某一个不同的日子</strong> 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>

<p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[7,1,5,3,6,4]
<strong>输出：</strong>5
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 2840, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线。**



<p><strong><a href="https://labuladong.github.io/article?qno=121" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程：

```python
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
              max( 今天选择 rest,        今天选择 sell       )

dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
              max( 今天选择 rest,         今天选择 buy         )
```

通用 base case：

```python
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

特化到 `k = 1` 的情况，状态转移方程和 base case 如下：

```python
状态转移方程：
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
dp[i][1] = max(dp[i-1][1], -prices[i])

base case：
dp[i][0] = 0;
dp[i][1] = -prices[i];
```

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
```

**类似题目**：
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [123. 买卖股票的最佳时机 III 🔴](/problems/best-time-to-buy-and-sell-stock-iii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>



