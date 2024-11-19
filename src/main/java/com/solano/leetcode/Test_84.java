package com.solano.leetcode;

import java.util.Stack;

/**
 * @author github.com/solano33
 * @date 2024/11/8 01:58
 */
public class Test_84 {

    public static void main(String[] args) {
        Test_84 test84 = new Test_84();
        int res = test84.largestRectangleArea(new int[]{2,1,2});
        System.out.println("res = " + res);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                System.out.println(stack.peek());
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(111);
                res = Math.max(res, (i + 1) * heights[i]);
            } else {
                System.out.println(222);
                res = Math.max(res, (i - stack.peek()) * heights[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) stack.pop();
        System.out.println("=============================");

        for (int i = n - 1; i >= 0; i--) {
            System.out.println("i = " + i);
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                System.out.println(stack.peek());
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(111);
                res = Math.max(res, (n - i) * heights[i]);
            } else {
                System.out.println(222);
                res = Math.max(res, (stack.peek() - i) * heights[i]);
            }
            if (res == 3) {
                System.out.println("i = " + i);
                System.out.println("stack.isEmpty() = " + stack.isEmpty());
                System.out.println("heights[i] = " + heights[i]);
            }
            stack.push(i);
        }
        return res;
    }
}
