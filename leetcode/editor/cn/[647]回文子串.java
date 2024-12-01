//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 1387 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        // dp[i][j] 表示s[i:j]是否是回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        int res = n;
        for (int len = 2; len <= n; len++) {
            // 遍历左端点
            for (int l = 0; l + len - 1 < n; l++) {
                // 右端点
                int r = l + len - 1;
                char lc = s.charAt(l), rc = s.charAt(r);
                if (lc != rc) continue;
                if (len == 2 || dp[l+1][r-1]) {
                    dp[l][r] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
