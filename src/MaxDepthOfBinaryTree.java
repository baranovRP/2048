import com.sun.source.tree.Tree;

import java.util.Stack;

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

class NodeInfo {
    TreeNode treeNode;
    int depth;

    NodeInfo(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }
}

public class MaxDepthOfBinaryTree {
    public static int nodeDepthsRecusively(TreeNode root) {

        return nodeDepthsHelper(root, 0);
    }

    private static int nodeDepthsHelper(TreeNode node, int depth) {
        if (node == null) return 0;
        return depth + nodeDepthsHelper(node.left, (depth + 1)) + nodeDepthsHelper(node.right, (depth + 1));
    }

    public static int nodeDepths(TreeNode root) {
        Stack<NodeInfo> stack = new Stack<>();
        int sumDepths = 0;
        TreeNode curr = root;
        stack.add(new NodeInfo(curr, 0));
        while (!stack.empty()) {
            NodeInfo currentNode = stack.pop();
            curr = currentNode.treeNode;
            if (curr == null) continue;
            int depth = currentNode.depth;
            sumDepths += depth;
            stack.push(new NodeInfo(curr.left, depth + 1));
            stack.push(new NodeInfo(curr.right, depth + 1));
        }
        return sumDepths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Max depth: " + MaxDepthOfBinaryTree.nodeDepthsRecusively(root));
        System.out.println("Max depth: " + MaxDepthOfBinaryTree.nodeDepths(root));
    }
}
