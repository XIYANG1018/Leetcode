package BinarySearchTree;
import java.util.ArrayList;
import java.util.List;

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

// recursive, in-order traversal, store every node value into an array and get the kth value
class Solution1 {
    List<Integer> ordered = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        inorder(root);
        return ordered.get(k-1);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        ordered.add(root.val);
        inorder(root.right);
    }
}

// save memory, do not need to remember all nodes value, space O(k)
class Solution2 {

    int K;
    boolean isFound = false;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        K = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (K == 1) {
            ans = root.val;
            isFound = true;
        }

        K--;
        if (!isFound) {
            inorder(root.right);
        }
        
    }
}

