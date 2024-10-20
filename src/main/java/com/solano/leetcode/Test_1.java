package com.solano.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author github.com/solano33
 * @date 2024/10/20 17:30
 */
public class Test_1 {

    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if(map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
