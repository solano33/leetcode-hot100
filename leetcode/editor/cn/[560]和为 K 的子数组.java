//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2577 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 3 5 6 7 -4 -3 -3 -2 4 6 7
    public int subarraySum(int[] nums, int k) {
        int ans = 0, n = nums.length;
        // <前缀和, 个数>
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
