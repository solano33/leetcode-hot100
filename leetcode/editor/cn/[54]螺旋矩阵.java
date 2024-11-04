//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1784 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean[][] visited;
    private List<Integer> res = new ArrayList<>();
    private int n, m;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};
    private int flag = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return res;
        n = matrix.length;
        m = matrix[0].length;
        visited = new boolean[n][m];
        dfs(matrix, 0, 0);
        return res;
    }

    private boolean dfs(int[][] matrix, int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c]) {
            flag = (flag + 1) % 4;
            return false;
        }
        visited[r][c] = true;
        res.add(matrix[r][c]);
        for (int i = 0; i < 2; i++) {
            int rr = r + dr[flag], cc = c + dc[flag];
            if (dfs(matrix, rr, cc)) {
                break;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
