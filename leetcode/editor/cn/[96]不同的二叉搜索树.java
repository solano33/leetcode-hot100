//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2576 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        return dp(n);
    }
    private int dp(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int len = 2; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                // 以 root 为根，左边有 root-1 个，右边有 len-root 个
                dp[len] += dp[root-1] * dp[len-root];
            }
        }
        return dp[n];
    }
    private int dfs(int n) {
        if (n <= 1) return n;
        int[] fn = new int[n + 1];
        // -1表示没有没搜索过
        for (int i = 0; i <= n; i++) fn[i] = -1;
        return dfs(fn, n);
    }
    private int dfs(int[] fn, int n) {
        if (n == 0) {
            fn[n] = 1;
            return 1;
        }
        if (fn[n] != -1) return fn[n];
        fn[n] = 0;
        for (int i = 1; i <= n; i++) {
            int left = dfs(fn, i-1);
            int right = dfs(fn, n-i);
            fn[n] += left * right;
        }
        return fn[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
