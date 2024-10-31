//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1253 👎 0


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
public class Codec {

    public static TreeNode tmp = null;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> res = bfs(root);
        String tmp = res.toString();
        System.out.println(tmp);
        return tmp;
    }

    private List<Integer> bfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node == null ? null : node.val);
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            res.addAll(level);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //    [1,2,3,null,null,4,5]
        // => [1, 2, 3, null, null, 4, 5, null, null, null, null]
        cur = 0;
        convert(data);
        System.out.println("data = " + data);
        return null;
    }

    private static int cur = 0;

    private List<TreeNode> convert(String data) {
        List<TreeNode> list = new ArrayList<>();
        while (cur < data.length()) {
            char now = data.charAt(cur);
            if (now == ' ' || now == '[' || now == ']' || now == ',') cur++;
            if (data.charAt(cur) == 'n') {
//            System.out.println("cur = " + cur);
                cur += 6;
                return null;
            }
            int flag = 1, val = 0;
            if (data.charAt(cur) == '-') {
//            System.out.println("cur = " + cur);
                flag = -1;
                cur++;
            }
            while (cur < data.length() && data.charAt(cur) >= '0' && data.charAt(cur) <= '9') {
//            System.out.println("cur = " + cur);
                val = (val * 10) + data.charAt(cur++) - '0';
            }
            TreeNode node = new TreeNode(flag * val);

            cur += 2;

            list.add(node);
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
