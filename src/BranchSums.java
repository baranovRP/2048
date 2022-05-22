import java.util.ArrayList;
import java.util.List;

class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

}

public class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calcBranchSums(root, 0, sums);
        return sums;
    }

    private static void calcBranchSums(BinaryTree root, int runningSum, List<Integer> sums) {
        if (root == null) return;
        int newRunningSum = runningSum + root.value;
        if (root.left == null && root.right == null) {
            sums.add(newRunningSum);
            return;
        }
        calcBranchSums(root.left, newRunningSum, sums);
        calcBranchSums(root.right, newRunningSum, sums);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right.left = new BinaryTree(10);
        System.out.println("Branch sums: " + BranchSums.branchSums(root));
    }
}
