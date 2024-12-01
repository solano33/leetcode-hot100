//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 2043 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int num : nums) s += num;
        if ((s + target) % 2 != 0) return 0;
        int n = (s + target) / 2;
        if (n < 0) return 0;
        // 从 nums 中取出 n 个物品使得背包容量为 n
        // dp[i][j] 表示前 i 个物品容量和为 j 的组合数量 01背包问题 有点区别，原始的 01背包问题是求最大价值
        return dp2(nums, n);
    }

    /**
     * 经典做法：二维数组
     */
    private int dp1(int[] nums, int n) {
        int m = nums.length;
        int[][] dp = new int[m +1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // 不选第 i 个物品
                dp[i][j] = dp[i-1][j];
                // 选第 i 个物品
                if (j >= nums[i-1]) dp[i][j] += dp[i-1][j-nums[i-1]];
            }
        }
        return dp[m][n];
    }

    /**
     * 优化版本：滚动数组
     */
    private int dp2(int[] nums, int n) {
        int m = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= nums[i - 1]; j--) {
                dp[j] += dp[j-nums[i-1]];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
