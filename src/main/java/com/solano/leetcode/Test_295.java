package com.solano.leetcode;

import java.util.PriorityQueue;

/**
 * @author github.com/solano33
 * @date 2024/12/29 17:13
 */
public class Test_295 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            queue.add(i);
            queue2.add(i);
        }
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue2.peek() = " + queue2.peek());
    }
}
