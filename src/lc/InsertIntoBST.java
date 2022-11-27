package lc;

//  Definition for a binary tree node.
/*class TreeNode {
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
}*/

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val, null, null);
        int cmp = Integer.compare(val, root.val);
        if (cmp < 0) root.left = insertIntoBST(root.left, val);
        else if (cmp > 0) root.right = insertIntoBST(root.right, val);
        else root.val = val;
        return root;
    }
}
