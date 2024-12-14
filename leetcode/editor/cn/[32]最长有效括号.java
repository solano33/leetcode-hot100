//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2599 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 外边界
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else {
                if (stack.peek() == -1 || s.charAt(stack.peek()) == ')') stack.push(i);
                else {
                    stack.pop(); // 左括号
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
