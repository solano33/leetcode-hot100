//给你一个字符串 s，找到 s 中最长的 回文 子串。 
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
//
// Related Topics 双指针 字符串 动态规划 👍 7430 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int maxLen = 1, left = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                char lc = s.charAt(l), rc = s.charAt(r);
                if (lc != rc) continue;
                if (len > 2 && !dp[l+1][r-1]) continue;
                dp[l][r] = true;
                maxLen = len;
                left = l;
            }
        }
        return s.substring(left, left + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
