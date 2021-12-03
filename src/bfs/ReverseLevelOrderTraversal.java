package bfs;

import java.util.*;

class ReverseLevelOrderTraversal {

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(N),
     * where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N)
     * as we need to return a list containing the level order traversal.
     * We will also need O(N) space for the queue.
     * Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
     * therefore we will need O(N)space to store them in the queue.
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(0, level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}

