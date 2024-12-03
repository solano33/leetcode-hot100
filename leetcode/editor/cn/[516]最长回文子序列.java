//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1270 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        if (n < 2) return n;
        // dp[i][j] 表示从 s(i, j) 内的最长回文子序列长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        int res = 1;
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                char lc = s.charAt(l), rc = s.charAt(r);
                if (len == 2) {
                    if (lc != rc) {
                        dp[l][r] = 1;
                        continue;
                    } else dp[l][r] = 2;
                }
                if (lc == rc) {
                    dp[l][r] = Math.max(dp[l][r], dp[l+1][r-1] + 2);
                } else {
                    dp[l][r] = Math.max(dp[l+1][r], dp[l][r-1]);
                }
                res = Math.max(res, dp[l][r]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
