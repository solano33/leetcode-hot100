package com.solano.leetcode;

import java.util.Arrays;

/**
 * @author github.com/solano33
 * @date 2024/11/22 22:20
 */
public class Test_5 {

    public static void main(String[] args) {
        Test_5 test5 = new Test_5();
        String cbbd = test5.longestPalindrome("aaaa");
        System.out.println("cbbd = " + cbbd);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int maxLen = 1, left = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) != s.charAt(j)) continue;
                if (len > 2 && !dp[i+1][j-1]) continue;
                dp[i][j] = true;
                maxLen = len;
                left = i;
            }
        }
        return s.substring(left, left + maxLen);
    }
}
