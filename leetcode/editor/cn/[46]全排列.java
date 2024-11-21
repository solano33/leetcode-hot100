//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2986 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        visited = new boolean[nums.length];
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    private void dfs(int cur, int[] nums, List<Integer> now) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(now));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (visited[i]) continue;
            visited[i] = true;
            now.add(num);
            dfs(cur + 1, nums, now);
            visited[i] = false;
            now.remove(now.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
