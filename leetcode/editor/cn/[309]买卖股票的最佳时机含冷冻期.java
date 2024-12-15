//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1784 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 状态转移方程：
     * f[i][0] = max(f[i-1][0], f[i-1][1] + p[i])
     *      i 天不持有，i-1天也不持有：收益一样,  f[i-1][0]
     *      i 天不持有，i-1天持有：i 天卖出, f[i-1][1]+p[i]
     * f[i][1] = max(f[i-1][1], f[i-2][0] - p[i])
     *      i 天持有，就得看前一天
     *          前一天持有，收益一样，f[i-1][1]
     *          前一天不持有：
     *              前两天持有：不可能，这种情况说明前一天卖出，今天又买入，不符合冷冻期
     *              前两天不持有：可能，连续两天不持有，今天买入，符合冷冻期，f[i-2][0] - p[i]
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // dp[i][0]: 表示到第 i 天时，不持有股票的最大收益
        // dp[i][1]: 表示到第 i 天时，持有股票的最大收益
        int[][] dp = new int[prices.length+1][2];
        dp[1][0] = 0; dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i-1]);
        }
        return dp[prices.length][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
