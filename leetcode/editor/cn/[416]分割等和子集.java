//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2199 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        // dp[i][s]: 表示前 i 个元素，能否凑出和为 s
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        dp = new int[nums.length][target+1];
        return dfs(nums, nums.length - 1, target) == 1;
    }

    private int dp[][];

    private int dfs(int[] nums, int n, int target) {
        if (target == 0) return 1;
        if (n < 0 || target < 0) return -1;
        if (dp[n][target] != 0) return dp[n][target];
        // 第 n 个选或者不选
        if (dfs(nums, n-1, target-nums[n]) == 1 || dfs(nums, n-1, target) == 1) {
            dp[n][target] = 1;
        } else {
            dp[n][target] = -1;
        }
        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
