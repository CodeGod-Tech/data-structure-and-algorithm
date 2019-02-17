package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.val = value;
    }

    public void display() {
        System.out.print(this.val + "\t");
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}