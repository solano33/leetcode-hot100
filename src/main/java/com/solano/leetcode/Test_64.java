package com.solano.leetcode;

/**
 * @author github.com/solano33
 * @date 2024/12/14 23:43
 */
public class Test_64 {

    public static void main(String[] args) {
        Test_64 test64 = new Test_64();
        // [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int i = test64.minPathSum(grid);
        System.out.println("i = " + i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 表示从(0,0)到(i,j)的最短路径
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 && j == 0) continue;
                if (i == 0) dp[i][j] += dp[i][j-1];
                else if (j == 0) dp[i][j] += dp[i-1][j];
                else dp[i][j] += Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
