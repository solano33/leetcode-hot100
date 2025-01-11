//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 3078 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        //左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left+((right-left)>>1);
            if (nums[mid] == target) {
                return mid;
            }
            //落在同一数组的情况，同时落在数组1 或 数组2
            if (nums[mid] >= nums[left]) {
                //target 落在 left 和 mid 之间，则移动我们的right，完全有序的一个区间内查找
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                    // target 落在right和 mid 之间，有可能在数组1， 也有可能在数组2
                } else {
                    left = mid + 1;
                }
                //不落在同一数组的情况，left 在数组1， mid 落在 数组2
            }else {
                //有序的一段区间，target 在 mid 和 right 之间
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                    // 两种情况，target 在left 和 mid 之间
                } else {
                    right = mid - 1;
                }
            }
        }
        //没有查找到
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
