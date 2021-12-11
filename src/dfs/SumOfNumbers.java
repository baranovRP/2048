package dfs;

import java.util.*;

class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        List<Integer> pathNumbers = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllPaths(root, currentPath, pathNumbers);
        int sum = 0;
        for (Integer n : pathNumbers) sum += n;
        return sum;
    }

    private static void findAllPaths(TreeNode node, List<Integer> current, List<Integer> pathNumbers) {
        if (node == null) return;
        current.add(node.val);
        if (node.left == null && node.right == null) {
            String pathNum = "";
            for (Integer n : current) pathNum += n.toString();
            pathNumbers.add(Integer.valueOf(pathNum));
        } else {
            findAllPaths(node.left, current, pathNumbers);
            findAllPaths(node.right, current, pathNumbers);
        }
        current.remove(current.size() - 1);
    }

    /**
     * Time complexity
     * The time complexity of the algorithm is O(N),
     * where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     *
     * Space complexity
     * The space complexity of the algorithm will be O(N) in the worst case.
     * This space will be used to store the recursion stack.
     * The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
     */
    public static int findSumOfPathNumbers2(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null)
            return 0;

        // calculate the path number of the current node
        pathSum = 10 * pathSum + currentNode.val;

        // if the current node is a leaf, return the current path sum.
        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        // traverse the left and the right sub-tree
        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers2(root));
    }
}

