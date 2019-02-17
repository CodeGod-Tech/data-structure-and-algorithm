package tree;

import java.util.Stack;

/**
 * Created by Leon on 2018-01-29.
 * http://blog.csdn.net/fengrunche/article/details/52305748
 */
public class BinaryTree {
    private TreeNode root = null;

    BinaryTree(int value) {
        root = new TreeNode(value);
        root.left = null;
        root.right = null;
    }


    public String insert(int value) {
        String error = null;

        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            root.left = null;
            root.right = null;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                if (value < current.val) {
                    parent = current;
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        break;
                    }
                } else if (value > current.val) {
                    parent = current;
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        break;
                    }
                } else {
                    error = "having same val in binary tree";
                }
            } // end of while
        }
        return error;
    }

    public TreeNode find(int value) {
        TreeNode current = root;
        while (true) {
            if (value == current.val) {
                return current;
            } else if (value < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }
    }

    /**
     * //中序遍历(递归)：
     *    1、调用自身来遍历节点的左子树
     *    2、访问这个节点
     *    3、调用自身来遍历节点的右子树
     */
    public void inOrderTraverse() {
        System.out.print("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null)
            return ;

        inOrderTraverse(node.left);
        node.display();
        inOrderTraverse(node.right);
    }


    /**
     * //前序遍历(递归)：
     *    1、访问这个节点
     *    2、调用自身来遍历节点的左子树
     *    3、调用自身来遍历节点的右子树
     */
    public void preOrderTraverse() {
        System.out.print("前序遍历:");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(TreeNode node) {
        if (node == null)
            return ;

        node.display();
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    /**
     * //后序遍历(递归)：
     *    1、调用自身来遍历节点的左子树
     *    2、调用自身来遍历节点的右子树
     *    3、访问这个节点
     */
    public void postOrderTraverse() {
        System.out.print("后序遍历:");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(TreeNode node) {
        if (node == null)
            return ;

        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        node.display();
    }

    /**
     * 中序非递归遍历：
     *     1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。
     *     2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     *     3) 重复1、2步操作，直到current为空且栈内节点为空。
     */
    public void inOrderByStack() {
        System.out.print("中序非递归遍历:");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        bt.insert(999);

        bt.preOrderTraverse();
        bt.inOrderTraverse();
        bt.postOrderTraverse();
    }


}
