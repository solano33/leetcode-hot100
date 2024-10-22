//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return fun2(nums1, nums2);
    }

    // 直接合并俩数组：需优化
    public double fun1(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] num = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < n) {
            num[k++] = nums1[i++];
        }
        while (j < m) {
            num[k++] = nums2[j++];
        }
        int s = n + m;
        return (num[(s - 1)/2] + num[s/2])/2.0;
    }

    // 合并到数组中间就行了
    public double fun2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int t = (n + m) / 2;
        int cur = 0, i = 0, j = 0, k = 0;
        int num[] = new int[n + m];
        while (i < n && j < m) {
            if (k > t) {
                break;
            }
            if (nums1[i] <= nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < n) {
            if (k > t) {
                break;
            }
            num[k++] = nums1[i++];
        }
        while (j < m) {
            if (k > t) {
                break;
            }
            num[k++] = nums2[j++];
        }
        if ((n + m) % 2 == 0) {
            return (num[t] + num[t-1]) / 2.0;
        } else {
            return num[t];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
