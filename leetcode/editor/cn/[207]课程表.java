//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 2044 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0) return true;
        return dfs(numCourses, prerequisites);
    }
    private List<List<Integer>> edges = new ArrayList<>();
    private int[] state;
    private int[] stack;
    private int index = 0;
    private boolean dfs(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            edges.get(cp[0]).add(cp[1]);
        }
        state = new int[numCourses];
        stack = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        System.out.println("stack = " + Arrays.toString(stack));
        return true;
    }
    private boolean dfs(int node) {
        // 被自己遍历过了，说明有环
        if (state[node] == 1) return false;
        // 被别人遍历过了
        if (state[node] == -1) return true;

        // 尝试往下遍历
        state[node] = 1;
        List<Integer> nextNodes = edges.get(node);
        for (int nextNode : nextNodes) {
            if (!dfs(nextNode)) return false;
        }
        // 全部遍历完了，设置 state，加入栈
        state[node] = -1;
        stack[index++] = node;
        return true;
    }

    private boolean bfs(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            res[index++] = now;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] != now) continue;
                if (--inDegree[prerequisites[i][0]] == 0) {
                    queue.offer(prerequisites[i][0]);
                }
            }
        }
        return index == numCourses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
