package BinaryTree;

class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while (root != null) {
            if (root == p || root == q) {
                return root;
            } 

            // if there is p or q on each of left and right, root is the ancesstor
            // is p and q both locate at the left tree, current root is not the lowest ancesstor
            // then search further in the left

            if (dfs(root.left, p, q) && dfs(root.right, p, q)) {
                return root;
            } else if (dfs(root.left, p, q) && !dfs(root.right, p, q)) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
        
    }

    // helper method: search the tree if there is p or q, return true
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        } else if (root == p || root == q){
            return true;
        }

        return dfs(root.left, p, q) || dfs(root.right, p, q);
    }
}

// Space complexity is not O(1), recursion includes call stack, so memory usage is proportional to the height of the tree, which is O(n) in worst case and O(log n) if the tree is more balanced.

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
