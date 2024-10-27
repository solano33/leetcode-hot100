//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2914 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return fun1(nums, k);
    }

    public int[] fun1(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[]{};
        }
        PriorityQueue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return a.num != b.num ? b.num - a.num : b.index - a.index;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(new Item(nums[i], i));
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek().num;
        for (int i = k; i < nums.length; i++) {
            queue.offer(new Item(nums[i], i));
            while (queue.peek().index <= i - k) {
                queue.poll();
            }
            res[i-k+1] = queue.peek().num;
        }
        return res;
    }

    public static class Item {
        int num;
        int index;
        public Item(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
