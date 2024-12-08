//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, 1);
        int res = 0;
        for (Integer n : map.keySet()) {
            if (map.get(n) == 0) continue;
            // 没有访问过，往左右两边扩展
            int length = 1;
            for (int i = 1; map.containsKey(n-i) && map.get(n-i) == 1; i++) {
                length++;
                map.put(n-i, 0);
            }
            for (int i = 1; map.containsKey(n+i) && map.get(n+i) == 1; i++) {
                length++;
                map.put(n+i, 0);
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
