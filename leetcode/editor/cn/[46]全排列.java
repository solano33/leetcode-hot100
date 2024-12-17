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
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> nowList, int cur) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(nowList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nowList.add(nums[i]);
            dfs(nums, nowList, cur + 1);
            nowList.remove(nowList.size() - 1);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
