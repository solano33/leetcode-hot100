//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2829 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return target;
    }

    private TreeNode target = null;
    /**
     * 从 root 开始找，如果找到 q 则第二位置为 1，如果找到 p 则第一位置为 1
     *
     * 00: 表示没有找到pq
     * 01：表示找到了q，没找到p
     * 10: 表示找到了p，没找到q
     * 11: 表示都找到了
     */
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int res = 0;
        if (root == p) res |= 2;
        if (root == q) res |= 1;
        int lres = dfs(root.left, p, q);
        int rres = dfs(root.right, p, q);
        res |= lres;
        res |= rres;
        if (res == 3 && target == null) target = root;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
