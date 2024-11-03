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
    public List<String> generateParenthesis(int n) {
        count = n;
        dfs(n, n, "");
        return res;
    }
    private int count;
    private List<String> res = new ArrayList<>();

    private void dfs(int leftN, int rightN, String nowStr) {
        if (nowStr.length() == count * 2) {
            res.add(nowStr);
            return;
        }
        if (leftN > rightN) return;
        if (leftN > 0) {
            dfs(leftN - 1, rightN, nowStr + "(");
        }
        if (rightN > 0) {
            dfs(leftN, rightN - 1, nowStr + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
