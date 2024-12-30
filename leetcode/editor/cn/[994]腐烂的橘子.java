//在给定的 m x n 网格
// grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 958 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int code = i * n + j;
                    queue.offer(code);
                }
            }
        }

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int code = queue.poll();
                int r = code / n, c = code % n;
                for (int j = 0; j < 4; j++) {
                    int rr = r + dr[j], cc = c + dc[j];
                    if (rr >= 0 && rr < m && cc >= 0 && cc < n && grid[rr][cc] == 1) {
                        grid[rr][cc] = 2;
                        int ncode = rr * n + cc;
                        queue.offer(ncode);
                    }
                }
            }
            res++;
        }
        boolean empty = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
                if (grid[i][j] != 0) empty = false;
            }
        }
        if (empty) return 0;
        return res;
    }
    private int res = -1;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
}
//leetcode submit region end(Prohibit modification and deletion)
