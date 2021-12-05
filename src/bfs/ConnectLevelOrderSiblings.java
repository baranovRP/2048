package bfs;

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    TreeNode2(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode2 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode2 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode2 root) {
        if (root == null) return;
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode2 current = queue.poll();
                if (levelSize == i + 1) {
                    current.next = null;
                } else {
                    current.next = queue.peek();
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(N),
     * where ‘N’ is the total number of nodes in the tree.
     * This is due to the fact that we traverse each node once.
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N), which is required for the queue.
     * Since we can have a maximum of N/2 nodes at any level (this could happen only at the lowest level),
     * therefore we will need O(N) space to store them in the queue.
     */
    public static void connect2(TreeNode2 root) {
        if (root == null)
            return;

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode2 currentNode = queue.poll();
                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}

