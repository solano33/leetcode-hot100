//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2388 👎 0


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
    public ListNode sortList(ListNode head) {
        return fun1(head);
    }


    public ListNode fun1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 一般来说快慢指针都是先指向头节点，这里比较特殊，因为要找到第一段链表的尾节点。
        // 假设只有俩节点，必须让slow停在第一个节点上
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow就是中点，或者中点偏左
        ListNode left = head, right = slow.next;
        slow.next = null;

        ListNode leftResult = fun1(left);
        ListNode rightResult = fun1(right);

        // merge
        ListNode cur = new ListNode(-1);
        ListNode res = cur;
        while (leftResult != null && rightResult != null) {
            if (leftResult.val <= rightResult.val) {
                cur.next = leftResult;
                leftResult = leftResult.next;
            } else {
                cur.next = rightResult;
                rightResult = rightResult.next;
            }
            cur = cur.next;
        }
        if (leftResult != null) {
            cur.next = leftResult;
        }
        if (rightResult != null) {
            cur.next = rightResult;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
