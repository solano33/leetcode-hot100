package com.solano.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author github.com/solano33
 * @date 2024/11/3 15:30
 */
public class Test_46 {

    public static void main(String[] args) {
        boolean[] bs = new boolean[10];
        System.out.println("bs = " + bs[3]);

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        System.out.println("nums = " + nums);
        nums.removeIf(e -> e == 1);
        System.out.println("nums = " + nums);
    }
}
