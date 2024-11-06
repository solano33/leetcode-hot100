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
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private List<List<Integer>> res;

    private void dfs(int[] nums, int idx, List<Integer> per) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(per));
            return;
        }
        // 不选当前元素
        dfs(nums, idx + 1, per);

        // 选当前元素
        per.add(nums[idx]);
        dfs(nums, idx + 1, per);

        per.remove(per.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
