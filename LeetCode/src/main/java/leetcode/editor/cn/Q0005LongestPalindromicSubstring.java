package leetcode.editor.cn;
/**
 * @author  fengming.dai 
 * @date    2023-02-06 16:10:27 
 */
 public class Q0005LongestPalindromicSubstring{
 //给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 6109 👎 0
    
 public static void main(String[] args) {        
 	Solution solution = new Q0005LongestPalindromicSubstring().new Solution();
 	String str = "cbbd";
//     String res = solution.longestPalindrome(str);
     System.out.println("res = " + longestPalindrome(str));
 }


    /**
     * 这段代码实现了一种求最长回文子序列的算法，它遍历了字符串 s 中的每一个字符，并计算以该字符为中心的回文子序列的长度。
     *
     * 主要有两种情况：回文子序列长度为奇数或偶数。因此，算法在每次循环时分别计算了这两种情况下的回文子序列长度，并取其中较长的那一个。
     *
     * 算法通过调用 expandAroundCenter 函数来计算回文子序列的长度。该函数以两个参数 left 和 right 作为中心，向外扩展并检查该子序列是否是回文子序列。如果是，则继续扩展；如果不是，则停止扩展并返回该子序列的长度。
     *
     * 最终，算法返回了字符串 s 中最长回文子序列的内容，作为字符串的子序列形式返回。
     * @param s
     * @return
     */
        public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                //考虑 奇数 length
                int len1 = expandAroundCenter(s, i, i);
                //考虑 偶数 length
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

    /**
     *  检测是否 是 回文，返会 回文字串 长度
     *  中心扩展
     * @param s
     * @param left
     * @param right
     * @return
     */
        private static int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }



    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 递推式如下：
         *
         * 当 $i = j$ 时，$dp[i][j] = 1$。
         * 当 $i > j$ 时，$dp[i][j] = 0$。
         * 当 $s[i] = s[j]$ 时，$dp[i][j] = dp[i + 1][j - 1] + 2$。
         * 当 $s[i] ≠ s[j]$ 时，$dp[i][j] = \max{dp[i + 1][j], dp[i][j - 1]}$。
         * 算法的空间复杂度为 $O(n^2)$，时间复杂度为 $O(n^2)$。
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            String res = "";
            return res;
        }

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

 }