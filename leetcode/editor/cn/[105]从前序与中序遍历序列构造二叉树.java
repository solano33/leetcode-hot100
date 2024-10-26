//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2396 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return fun1(preorder, inorder);
    }

    public TreeNode fun1(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length -1, 0, inorder.length - 1);
    }

    private Map<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode buildTree(int[] preorder, int[] inorder,
                               int preL, int preR,
                               int inL, int inR) {
        // todo：递归条件
        if (preL > preR || inL > inR) {
            return null;
        }
        // 前序遍历找到root
        int rootNode = preorder[preL];
        // 中序遍历找到left & right
        int rootIn = indexMap.get(rootNode);
        int leftSize = rootIn - inL;

        TreeNode root = new TreeNode(rootNode);
        root.left = buildTree(preorder, inorder, preL + 1, preL + leftSize, inL, rootIn - 1);
        root.right = buildTree(preorder, inorder, preL + leftSize + 1, preR, rootIn + 1, inR);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
