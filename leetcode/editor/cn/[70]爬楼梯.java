//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3458 👎 0

/**
 * 【难度简单】这题可作为面试题，其中一道题
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
//        return climbStairs1(n);
//        return climbStairs2(n);
        return fun4(n);
    }

    private int fun4(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int now(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }


    /**
     * 【递归】
     * 考虑最后一步，可能有两种可能：
     *  跳一阶台阶：前面可能有f(n-1)种可能，总共就是f(n-1)种，注意这边最后一步不用加1，因为最后一步跟前面每一种可能构成完整路径
     *  跳两节台阶：前面可能有f(n-2)种可能，总共就是f(n-2)种
     * 因此其实就是一个斐波那契数列，只是起始值不同，这里f(1)=1, f(2)=2
     * 状态转移方程：f(n) = f(n-1) + f(n-2)
     * note：这里会超时
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 【循环】
     * 状态转移方程只依赖于前面两个状态，实际上只需要用三个变量来表示即可
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2, sum = 3;
        for (int i = 4; i <= n; i++) {
            first = second;
            second = sum;
            sum = first + second;
        }
        return sum;
    }

    /**
     * 【动态规划】
     * 状态转移方程只依赖于前面两个状态，实际上只需要用三个变量来表示即可
     * note：还是超时
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
