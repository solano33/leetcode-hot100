//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }
    private List<List<Integer>> res = new ArrayList<>();
    private void dfs(int[] nums, List<Integer> nowList, int cur) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(nowList));
            return;
        }
        // 不选当前元素
        dfs(nums, nowList, cur + 1);

        // 选当前元素
        nowList.add(nums[cur]);
        dfs(nums, nowList, cur + 1);
        nowList.remove(nowList.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
