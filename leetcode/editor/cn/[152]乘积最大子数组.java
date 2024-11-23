//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = Integer.MIN_VALUE, val = 1;
        for (int l = 0, r = 0; l < nums.length; ) {
            // r 遇到了数组右边界，或者遇到了 0
            if (r == nums.length || nums[r] == 0) {
                // 移动左指针
                while (l < r) {
                    res = Math.max(res, val);
                    val /= nums[l++];
                }
                if (r < nums.length && nums[r] == 0) res = Math.max(res, 0);
                l++; r++;
            } else {
                val *= nums[r++];
                res = Math.max(res, val);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
