package linkedlist;


/**
 * 两个有序的链表合并
 *
 */
public class LinkedListMerge {

    public static Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head = null;

        if (list1.data <= list2.data) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        }  else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}
