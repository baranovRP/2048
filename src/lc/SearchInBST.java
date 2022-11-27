package lc;

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        int cmp = Integer.compare(val, root.val);
        if (cmp < 0) return searchBST(root.left, val);
        else if (cmp > 0) return searchBST(root.right, val);
        else return root;
    }
}
