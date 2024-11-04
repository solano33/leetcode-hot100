//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1895 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private int n, m;
    private int[] dr = new int[]{-1, 1, 0, 0};
    private int[] dc = new int[]{0, 0, -1, 1};
    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (r < 0 || r >= n || c < 0 || c >= m || board[r][c] == '#') return false;
        if (idx < word.length() && board[r][c] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        char tmp = board[r][c];
        board[r][c] = '#';
        for (int i = 0; i < 4; i++) {
            if (dfs(board, word, r + dr[i], c + dc[i], idx + 1)) return true;
        }
        board[r][c] = tmp;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
