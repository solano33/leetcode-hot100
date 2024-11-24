//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 3119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // x[0], x[1] 表示前一个房子不偷 | 偷的最大价值
        // y[0], y[1] 表示当前房子不偷 | 偷的最大价值
        int[] x = new int[2], y = new int[2];
        x[0] = 0;
        x[1] = nums[0];
        // 注意要从第二个房子开始, 因为第一个房子已经算过了
        for (int i = 1; i < nums.length; i++) {
            // 当前不偷：前一个偷 / 不偷的较大值
            y[0] = Math.max(x[0], x[1]);
            // 当前偷：前一个只能不偷 + 当前房子价值
            y[1] = x[0] + nums[i];
            x[0] = y[0];
            x[1] = y[1];
        }
        return Math.max(x[0], x[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
