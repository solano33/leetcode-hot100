package com.solano.leetcode;

import java.util.Arrays;

/**
 * @author github.com/solano33
 * @date 2024/10/28 23:53
 */
public class Test_31 {
    public void fun1(int[] nums) {
        if (nums == null) return;
        int n = nums.length;
        int i = n - 2; // 1.找到第一个i<j & num[i] < num[j]
        while (i >= 0 && nums[i] < nums[i+1]) i--;
        if (i == -1) { // 没找到顺序对，说明全是逆序的
            Arrays.sort(nums);
            return;
        }
        // 2.从后往前找到第一个k，num[i] < num[k]，至少能找到一个num[j]
        int k = n - 1;
        while (nums[k] > nums[i]) k--;
        swap(nums, i, k);
        Arrays.sort(nums, i + 1,n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
