//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
//
// Related Topics 数组 数学 矩阵 👍 1974 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        // 按圈枚举(外围的一圈)
        for (int L = n; L >= 0; L -= 2) {
            // 每圈的首个节点其实都是在对角线上的
            int row = (n - L) / 2;
            int col = row;
            // 当前这一层，顶行的前 L-1 个元素
            for (int i = 0; i < L - 1; i++) {
                int r = row, c = col + i;
                int pre = matrix[r][c];
                for (int j = 0; j < 4; j++) {
                    // 这个很重要，推算一下转后的坐标关系
                    int rr = c, cc = n - 1 - r;
                    int tmp = matrix[rr][cc];
                    matrix[rr][cc] = pre;
                    pre = tmp;
                    r = rr;
                    c = cc;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
