//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与 2220. 转换数字的最少位翻转次数 相同。 
//
// Related Topics 位运算 👍 748 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
        return fun2(x, y);
    }

    public int fun1(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            if((x & 1) != (y & 1)) count++;
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

    public int fun2(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int xb = ((x >> i) & 1);
            int yb = ((y >> i) & 1);
            if (xb != yb) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
