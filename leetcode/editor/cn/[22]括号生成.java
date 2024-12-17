//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3714 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return res;
        dfs("", n, n);
        return res;
    }

    private void dfs(String nowStr, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            res.add(nowStr);
            return;
        }
        if (leftCount > rightCount) return;
        if (leftCount > 0) {
            dfs(nowStr + "(", leftCount - 1, rightCount);
        }
        if (rightCount > 0) {
            dfs(nowStr + ")", leftCount, rightCount - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
