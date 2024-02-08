
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
    }
}

// use tree level order traversal, store the last element at the level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> nodeQ = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        nodeQ.add(root);

        while (!nodeQ.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queueLength = nodeQ.size();

            for (int i=0; i<queueLength; i++) {
                TreeNode currentNode = nodeQ.poll();
                if (currentNode != null) {
                    level.add(currentNode.val);
                    nodeQ.add(currentNode.left);
                    nodeQ.add(currentNode.right);
                }
            }

            if (!level.isEmpty()) {
                ans.add(level.get(level.size()-1));
            }
            
        }

        return ans;
    }

}

// using dfs, every level we only add one value

class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    List<Integer> ans = new ArrayList<>();

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth == ans.size()) ans.add(root.val);
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
    }
}