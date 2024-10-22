//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10384 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return fun2(s);
    }

    public int fun1(String s) {
        int l = 0, r = 0;
        int res = 0;
        // 表示字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char rc = s.charAt(r++);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (map.get(rc) > 1) {
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public int fun2(String s) {
        int l = -1, r = 0, res = 0;
        // 表示字符最后一次出现的索引
        Map<Character, Integer> map = new HashMap<>();
        for (r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (map.containsKey(rc)) {
                l = Math.max(l, map.get(rc));
            }
            map.put(rc, r);
            res = Math.max(res, r - l);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
