package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindMaxTreePaths {

    public static List<Integer> findPaths(TreeNode root) {
        List<List<Integer>> maxSumPaths = new ArrayList<>();
        maxSumPaths.add(new ArrayList<>());
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, currentPath, maxSumPaths);
        return maxSumPaths.get(0);
    }

    private static void findPathsRecursive(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> maxSumPaths) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);
        if (currentNode.left == null && currentNode.right == null) {
            Integer currentSum = currentPath.stream().reduce(0, Integer::sum);
            Integer maxSum = maxSumPaths.get(0).stream().reduce(0, Integer::sum);
            if (currentSum > maxSum) maxSumPaths.add(0, new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, currentPath, maxSumPaths);
            findPathsRecursive(currentNode.right, currentPath, maxSumPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = FindMaxTreePaths.findPaths(root);
        System.out.println("Tree paths with max sum: " + result);
    }
}
