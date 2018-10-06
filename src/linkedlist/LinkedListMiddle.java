package linkedlist;

/**
 * 求链表的中间结点
 *
 */
public class LinkedListMiddle {




    public static void main(String[] args) {
        Node node = Node.readyNode();
        Node middle = findMiddle(node);
        Node.print(node);
        System.out.println(middle.data);
    }


    static Node findMiddle(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
