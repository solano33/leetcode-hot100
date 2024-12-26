//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3 : 
//
// 
//输入：nums = [3,3,3,3,3]
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
//
// Related Topics 位运算 数组 双指针 二分查找 👍 2519 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        return fun2(nums);
    }

    /**
     * 进阶版，快慢指针，龟兔赛跑
     */
    public int fun2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * swap做法，会改变 nums
     */
    public int fun1(int[] nums) {
        int n = nums.length - 1;
        // 遍历数组，将每个数字放到它应该在的位置（即 nums[i] 应该放在 i 位置）
        for (int i = 0; i < n; i++) {
            // 如果当前位置的数字不是 i+1，即 nums[i] 不是它应该在的位置
            while (nums[i] != i + 1) {
                int rightIdx = nums[i] - 1;
                if (nums[rightIdx] == rightIdx + 1) {
                    // 如果交换后 nums[rightIdx] 与 nums[i] 相同，说明找到了重复的数字
                    return rightIdx + 1;
                } else {
                    // 否则，交换 nums[i] 和 nums[rightIdx]
                    swap(nums, i, rightIdx);
                }
            }
        }
        // 循环结束后，返回最后一个元素，因为最后一个元素是重复的
        return nums[n];
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
