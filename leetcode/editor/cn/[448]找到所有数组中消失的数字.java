//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
//
// Related Topics 数组 哈希表 👍 1341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return fun1(nums);
    }

    public List<Integer> fun1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            // nums[i], 本应该在的位置nums[i]-1
            int rightIndex = nums[i] - 1;
            if (rightIndex == i) continue;
            while (true) {
                rightIndex = nums[i] - 1;
                swap(nums, i, rightIndex);
                if (rightIndex == i || nums[i] == nums[rightIndex]) break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
