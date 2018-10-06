package linkedlist;

/**
 * 删除链表倒数第 n 个结点
 */
public class LinkedListNodeRemove {


    public static Node removeNthFromEnd(Node node, int n) {
        if (node == null) {
            return node;
        }

        Node start = node;
        Node end = node;

        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        while (end.next != null) {
            start = start.next;
            end = end.next;
        }

        //删除
        start.next = start.next.next;
        return node;

    }
}
