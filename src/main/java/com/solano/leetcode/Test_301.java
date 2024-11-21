package com.solano.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author github.com/solano33
 * @date 2024/11/22 00:02
 */
public class Test_301 {

    public static void main(String[] args) {
        List<String> strings = new Solution().removeInvalidParentheses("()())()");
        System.out.println("strings = " + strings);
    }
}

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        maxLength(s);
        dfs(0 ,0, 0, new ArrayList<>());
        return res;
    }

    int maxLength = 0;
    private List<Item> items = new ArrayList<>();
    private List<String> res = new ArrayList<>();

    private int maxLength(String str) {
        int cnt = 0, s = 0, r = 0;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (i == 0 || now == str.charAt(i-1)) {
                cnt++;
            } else {
                items.add(new Item(str.charAt(i-1), cnt));
                cnt = 1;
            }
            if (now == '(') s++;
            else if (now == ')') {
                if (s > 0) s--;
                else r++;
            }
        }
        items.add(new Item(str.charAt(str.length() - 1), cnt));
        maxLength = str.length() - s - r;
        System.out.printf("s = %d, r = %d, maxLength = %d \n", s, r, maxLength);
        System.out.println("items = " + items);
        return maxLength;
    }

    void dfs(int cur, int s, int len, List<Item> ans) {
        System.out.println(cur + ", " + s + ", " + len);
        if (cur == items.size()) {
            if (s == 0 && len == maxLength) {
                res.add(gen(ans));
            }
            return;
        }

        Item item = items.get(cur);
        System.out.println("item = " + item);
        if (item.c != '(' && item.c != ')') {
            if (len + item.cnt > maxLength) return;
            ans.add(item);
            dfs(cur + 1, s, len + item.cnt, ans);
            ans.remove(item);
            return;
        }

        ans.add(item);
        for (int i = 0; i <= item.cnt; i++) {
            if (item.c == '(') {
                if (len + i <= maxLength) {
                    ans.get(cur).cnt = i;
                    dfs(cur + 1, s + i, len + i, ans);
                }
            } else {
                if (s >= i && len + i <= maxLength) {
                    ans.get(cur).cnt = i;
                    dfs(cur + 1, s + i, len + i, ans);
                }
            }
        }
    }

    private String gen(List<Item> ans) {
        System.out.println("gen");
        String s = "";
        for (Item a : ans) {
            s += a.c;
        }
        return s;
    }
}

class Item {
    char c;
    int cnt;
    public Item(char c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }

    public String toString() {
        return "[ " + c + " = " + cnt + " ]";
    }
}
