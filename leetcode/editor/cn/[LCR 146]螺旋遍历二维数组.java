//给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。 
//
// 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：array = [[1,2,3],[8,9,4],[7,6,5]]
//输出：[1,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
//输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= array.length <= 100 
// 0 <= array[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// 
//
// Related Topics 数组 矩阵 模拟 👍 606 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0) return new int[]{};
        n = array.length;
        m = array[0].length;
        res = new int[n * m];
        visited = new boolean[n][m];
        dfs(array, 0, 0, 0);
        return res;
    }

    private boolean[][] visited;
    private int[] res;
    private int n, m;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};
    private int flag = 0;
    private boolean dfs(int[][] array, int r, int c, int idx) {
        if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c]) {
            flag = (++flag) % 4;
            return false;
        }
        res[idx] = array[r][c];
        visited[r][c] = true;
        for (int i = 0; i < 2; i++) {
            int rr = r + dr[flag], cc = c + dc[flag];
            if (dfs(array, rr, cc, idx + 1)) {
                break;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
