//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
//
// Related Topics 广度优先搜索 字符串 回溯 👍 948 👎 0

/**
 * 放弃了 太难了
 */
//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
