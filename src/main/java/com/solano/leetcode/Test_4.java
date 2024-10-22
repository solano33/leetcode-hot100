package com.solano.leetcode;

/**
 * @author github.com/solano33
 * @date 2024/10/22 23:07
 */
public class Test_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        return (num[(s - 1)/2] + num[s/2])/2;
    }
}
