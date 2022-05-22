public class ClosestValueInBst {

    // Average: O(log(n)) time | O(log(n)) space
    // Worst: O(n) time | O(n) space
    public static int findClosestValueInBstRecursively(BST tree, int target) {
        return findClosestValueInBstRecursivelyHelper(tree, target, Double.MAX_VALUE);
    }

    private static int findClosestValueInBstRecursivelyHelper(BST tree, int target, double closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBstRecursivelyHelper(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBstRecursivelyHelper(tree.right, target, closest);
        } else {
            return (int) closest;
        }
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space
    public static int findClosestValueInBst(BST tree, int target) {
        double closest = Double.MAX_VALUE;
        BST currentNode = tree;

        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return (int) closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }












































}

