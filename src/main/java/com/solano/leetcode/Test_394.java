package com.solano.leetcode;

import java.util.Stack;

/**
 * @author github.com/solano33
 * @date 2024/12/29 18:32
 */
public class Test_394 {

    public static void main(String[] args) {
        String s = new Test_394().decodeString("100[leetcode]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();
        for (int i = n - 1; i >= 0; ) {
            char c = s.charAt(i);

            if (c == ']' || Character.isLetter(c)) {
                stack.push(c + "");
                i--;
            } else {
                // 肯定是先碰到 [ , 再是数字
                String nowStr = "";
                while (!stack.isEmpty() && !"]".equals(stack.peek())) {
                    nowStr += stack.pop();
                }
                // 如果不是空的 说明是 [，直接去掉
                if (!stack.isEmpty()) stack.pop();
                // 索引往左，跳过 [
                i--;

                // 读数字
                int num = 0, base = 1;
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    num = (s.charAt(i) - '0') * base + num;
                    base *= 10;
                    i--;
                }

                String newStr = "";
                while (num > 0) {
                    newStr += nowStr;
                    num--;
                }

                stack.push(newStr);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
