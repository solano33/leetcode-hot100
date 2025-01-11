//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2863 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> res = search(nums, target, 0, nums.length - 1);
        if (res.size() == 0) {
            return new int[]{-1, -1};
        }
        int min = nums.length, max = -1;
        for (Integer i : res) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return new int[]{min, max};
    }

    public List<Integer> search(int[] nums, int target, int left, int right) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (left == right) {
            if (nums[left] == target) {
                res.add(left);
            }
            return res;
        }
        int mid = (right - left) / 2 + left;
        List<Integer> leftRes = search(nums, target, left, mid);
        List<Integer> rightRes = search(nums, target, mid + 1, right);
        leftRes.addAll(rightRes);
        return leftRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
