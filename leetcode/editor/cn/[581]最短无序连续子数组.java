//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 从左到右看，数应该越来越大，如果某个数，比前面最大值大，那他没问题，如果小于前面的最大值，那么这个数就有问题
     * 从左到右不断更新最大值，遇到有问题的数，就记录下来作为right，并且right可以更新
     * right更新到最后面不动了，说明right右边的数都比，right左边的max的数大，但是right自己比max小，right右边是排好序的，right左边需要重新排序，right是需要重新排序的区间的右边届。
     * left同理，left就是从右往左看，数要越来越小才行，如果某个数，比右边最小值还要小，那他没问题，如果它比右边的最小值要大，说明他有问题。
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
