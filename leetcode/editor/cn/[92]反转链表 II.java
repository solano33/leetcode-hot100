//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1860 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return fun1(head, left, right);
    }

    public ListNode fun1(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = head, pre = dummyNode;
        ListNode a = null, b = null, start = null, end = null;
        for (int i = 0; i < right; i++) {
            if (i == left - 1) {
                a = pre;
                start = cur;
            }
            if (i == right - 1){
                b = cur.next;
                end = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 断开链接
        a.next = null;
        end.next = null;

        // 反转中间段
        reverseAll(start);

        // 重新链接
        a.next = end;
        start.next = b;

        return dummyNode.next;
    }

    public ListNode reverseAll(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseAll2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
