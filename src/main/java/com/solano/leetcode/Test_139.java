package com.solano.leetcode;

import java.util.List;

/**
 * @author github.com/solano33
 * @date 2024/11/23 19:37
 */
public class Test_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return true;
        visited = new boolean[wordDict.size()];
        return dfs(s, wordDict, 0);
    }
    private boolean[] visited;

    private boolean dfs(String s, List<String> wordDict, int cur) {
        if (cur >= s.length()) return true;
        if (visited[cur]) return visited[cur];
        visited[cur] = false;
        for(String w : wordDict) {
            if (s.substring(cur).startsWith(w)) {       // 忘了 api
                visited[cur] = dfs(s, wordDict, cur + w.length());
                if (visited[cur]) return true;
            }
        }
        return visited[cur];
    }
}


