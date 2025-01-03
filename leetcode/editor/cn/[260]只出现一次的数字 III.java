//给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
//
// Related Topics 位运算 数组 👍 925 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        return fun1(nums);
    }

    public int[] fun1(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s ^= nums[i];
        }
        int flag = 1;
        while ((flag & s) == 0) flag <<= 1;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((flag & nums[i]) == 0) {
                sum1 ^= nums[i];
            } else {
                sum2 ^= nums[i];
            }
        }
        return new int[]{sum1, sum2};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
