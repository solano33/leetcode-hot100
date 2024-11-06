//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2822 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = 1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            // 这个时候stack所有柱子都比当前柱子要低, 或者没有更低的了
            if (stack.isEmpty()) w[i] += i; // stack为空代表左边都比当前高
            else w[i] += i - stack.peek() - 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) stack.pop();
        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) w[i] += n - 1 - i;
            else w[i] += stack.peek() - i - 1;
            stack.push(i);
            res = Math.max(res, heights[i] * w[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
