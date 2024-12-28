package com.solano.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author github.com/solano33
 * @date 2024/12/29 01:23
 */
public class Test_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int cnt = map.getOrDefault(n, 0);
            map.put(n, cnt + 1);
        }
        PriorityQueue<Item> queue = new PriorityQueue<>((a, b) -> b.k - a.k);
        map.forEach((key, v) -> queue.offer(new Item(v, key)));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().v;
        }
        return res;
    }
    public static class Item {
        int k;
        int v;
        public Item(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
}