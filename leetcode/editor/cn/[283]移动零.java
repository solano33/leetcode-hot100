//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2470 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
//        fun1(nums);
        fun4(nums);
    }

    private void fun4(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0, r = 1;
        while (l < r && r < nums.length) {
            if (nums[l] != 0) {
                l++;
                if (l == r) r++;
            } else if (nums[r] == 0) r++;
            else swap(nums, l++, r++);
        }
    }

    public void fun3(int[] nums) {
        int l = 0, r = 1;
        while (l < r && r < nums.length) {
            if (nums[l] != 0) {
                l++;
                if (l == r) r++;
            } else if (nums[r] == 0) r++;
            else swap(nums, l++, r++);
        }
    }

    public void fun1(int[] nums) {
        int l = 0, r = 1; // l要找到0，r要找到非0
        while (l < r && r < nums.length) {
            if (nums[l] != 0) {
                l++;
                // 避免让l追上r
                if (l == r) {
                    r++;
                }
            }
            else if (nums[r] == 0) r++;
            else {
                swap(nums, l++, r++);
            }
        }
    }

    public void fun2(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int l = 0, r = 0;
        while (l < nums.length && r < nums.length) {
            // 注意这里要先判断是不是溢出了
            while (l < nums.length && nums[l] != 0) l++;
            if (l >= nums.length) break;
            while ((r < nums.length && nums[r] == 0) || r <= l) r++;
            if (r >= nums.length) break;
            swap(nums, l++, r++);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
