//在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后
//一列。 
//
// 你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。 
//
// 最终，我们到过网格的所有 rows x cols 个空间。 
//
// 按照访问顺序返回表示网格位置的坐标列表。 
//
// 
//
// 示例 1： 
// 
// 
//输入：rows = 1, cols = 4, rStart = 0, cStart = 0
//输出：[[0,0],[0,1],[0,2],[0,3]]
// 
//
// 示例 2： 
// 
// 
//输入：rows = 5, cols = 6, rStart = 1, cStart = 4
//输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3
//,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0
//],[3,0],[2,0],[1,0],[0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows, cols <= 100 
// 0 <= rStart < rows 
// 0 <= cStart < cols 
// 
//
// Related Topics 数组 矩阵 模拟 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * todo: 还没做出来
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        row = rows;
        col = cols;
        findDummyRow(rows, cols, rStart, cStart);
        res = new int[rows * cols][2];
        visited = new boolean[dummyR][dummyC];
        System.out.println("dummyR = " + dummyR);
        dfs(rStart, cStart, 0);
        return res;
    }

    private void findDummyRow(int rows, int cols, int rStart, int cStart) {
        int drow = Math.max(rStart, rows - rStart - 1);
        int dcol = Math.max(cStart, cols - cStart - 1);
        int dd = Math.max(drow, dcol);
        dummyR = dd * 2 + 1;
        dummyC = dummyR;
    }

    private int[][] res;
    private boolean[][] visited;
    private int dummyR, dummyC, row, col;
    private int flag = 0;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};

    private boolean dfs(int r, int c, int idx) {
        System.out.println("c = " + c + ", r = " + r);
//        System.out.println("idx = " + idx);
        if (c < 0 || c >= dummyC || r < 0 || r >= dummyR || idx >= res.length || visited[c][r]) {
            flag = (flag + 1) % 4;
            return false;
        }
        visited[r][c] = true;
        if (c >= 0 && c < col && r >= 0 && r < row) {
            res[idx][0] = r;
            res[idx][1] = c;
        } else {
            idx--;
        }
        for (int i = 0; i < 2; i++) {
            int rr = r + dr[flag], cc = c + dc[flag];
            System.out.println("flag = " + flag);
            System.out.println("rr = " + rr);
            System.out.println("cc = " + cc);
            if (dfs(rr, cc, idx + 1)) {
                break;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
