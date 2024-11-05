//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        num = n;
        count = n * n;
        res = new int[n][n];
        dfs(1, 0, 0);
        return res;
    }

    private int num;
    private int count;
    private int[][] res;
    private int flag = 0;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};

    private boolean dfs(int idx, int r, int c) {
        if (idx > count) return false;
        if (r < 0 || r >= num || c < 0 || c >= num || res[r][c] != 0) {
            flag = (flag + 1) % 4;
            return false;
        }
        res[r][c] = idx;
        for (int i = 0; i < 2; i++) {
            int rr = r + dr[flag], cc = c + dc[flag];
            if (dfs(idx + 1, rr, cc)) {
                break;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
