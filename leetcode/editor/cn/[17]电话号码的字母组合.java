//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2940 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    private String[] list = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, 0, "");
        return res;
    }

    private void dfs(String digits, int cur, String nowStr) {
        if (cur == digits.length()) {
            if (nowStr != null && nowStr.length() != 0) res.add(nowStr);
            return;
        }
        int index = digits.charAt(cur) - '0' - 2;
        for (char a : list[index].toCharArray()) {
            dfs(digits, cur + 1, nowStr + a);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
