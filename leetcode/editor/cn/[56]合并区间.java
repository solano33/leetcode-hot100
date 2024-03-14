//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 时间复杂度：O(nlogn)，空间复杂度：O(logn)
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序，然后遍历区间，如果当前区间的起始位置大于前一个区间的结束位置，则不重叠，否则重叠
        // 重叠的话，取两个区间的最大结束位置
        // 时间复杂度：O(nlogn)，空间复杂度：O(logn)
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        int length = intervals.length;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(right < start) {
                res.add(new int[]{left, right});
                left = start;
                right = end;
            } else {
                right = Math.max(right, end);
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
