//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2619 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return true;
        visited = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            visited[i] = -1;
        }
        return dfs(s, wordDict, 0) == 1;
    }
    // visited[i]表示从 i 下标开始到末尾能不能匹配上
    // -1: 没匹配过   0：不能匹配   1：能匹配
    private int[] visited;

    private int dfs(String s, List<String> wordDict, int cur) {
        if (cur >= s.length()) return 1;
        if (visited[cur] != -1) return visited[cur];    // 减枝
        visited[cur] = 0;  // 默认不能匹配
        for(String w : wordDict) {
            if (s.substring(cur).startsWith(w)) {
                visited[cur] = dfs(s, wordDict, cur + w.length());
                if (visited[cur] == 1) return 1;        // 减枝
            }
        }
        return visited[cur];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return true;
        visited = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) visited[i] = -1;
        return dfs2(s, wordDict, 0) == 1;
    }
    private int dfs2(String s, List<String> wordDict, int cur) {
        if (cur >= s.length()) return 1;
        if (visited[cur] != -1) return visited[cur];
        visited[cur] = 0;
        for (String w : wordDict) {
            if (s.substring(cur).startsWith(w)) {
                visited[cur] = dfs2(s, wordDict, cur + w.length());
                if (visited[cur] == 1) return 1;
            }
        }
        return visited[cur];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
