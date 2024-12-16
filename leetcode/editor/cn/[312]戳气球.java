//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1417 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 避免边界讨论
        int n = nums.length;
        int[] a = new int[n+2];
        a[0] = 1; a[n+1]=1;
        for (int i = 1; i <= n; i++) a[i] = nums[i-1];
        // dp[i][j]表示从 i-j 能获得的最大价值。这里应该逆向考虑，遍历最后一个可能的气球
        int[][] dp = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = a[i-1] * a[i] * a[i+1];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + a[k] * a[i-1] * a[j+1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[1][nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
