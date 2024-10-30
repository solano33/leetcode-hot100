//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2436 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return fun1(root);
    }

    public boolean fun1(TreeNode root) {
        return dfs(root, (long)Integer.MIN_VALUE - 1L, (long)Integer.MAX_VALUE + 1L);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

//    // 错误做法，没有检测右子树
//    public boolean fun1(TreeNode root) {
//        if (root == null) return true;
//        boolean res = true;
//        if (root.left != null) res &= (root.val > root.left.val);
//        if (root.right != null) res &= (root.val < root.right.val);
//        if (!res) return res;
//        return fun1(root.left) && fun1(root.right);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
