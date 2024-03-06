//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1124 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        return generate2(numRows);
    }

    /**
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 状态转移方程：dp[i][j] = dp[i-1][j-1] + dp[i-1][j]  (i>1, j>1)
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            res.add(first);
            return res;
        }
        
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            List<Integer> per = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                per.add(dp[i][j]);
            }
            res.add(per);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
