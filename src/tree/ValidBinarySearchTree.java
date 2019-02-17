package tree;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 1. 中序遍历排序，判断排序结果是不是升序
 * 2. 递归，左子树最大值小于根节点，右子树最大值大于根节点
 */
public class ValidBinarySearchTree {

    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isValidBST(TreeNode root) {
        inOrderTraverse(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }


    public static void inOrderTraverse(TreeNode node) {
        if (node == null)
            return ;
        inOrderTraverse(node.left);
        list.add(node.val);
        inOrderTraverse(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }


}
