package linkedlist;

/**
 * 判断链表中是否有环，如有，则返回入口节点
 *
 * 解决思路：
 * 1、定义慢指针和快指针，慢指针每次移动1步，快指针每次移动两步，如果有环，必定会相遇，而且在慢指针走完环之前相遇,
 *    因为快指针比慢指针快2倍，如果慢指针走完了环，那么快指针已经走了两次环
 *
 * 2、当相遇后，让快指针指向链表头，然后同慢指针每次移动一步，再次相遇的地方就是环的入口
 *    假设第一次相遇时慢指针走了 s + k 步，那么快指针走了 2 (s + k)， 假设环的节点数时x，n表示快指针比慢指针多走的环数
 *    2 (s + k) = s + k + nx，即 s + k = nx
 *    让快指针指向表头，再走s步，则慢指针总共走了
 *    s + k + s = s + nx，也就是慢指针又回到了环入口，与快指针相遇
 */
public class LinkedListLoop {



    public static Node EntryNodeOfLoop(Node pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }

        Node slow = pHead;
        Node fast = pHead;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //第一次相遇
            if (fast.data == slow.data) {
                fast = pHead;
                while (fast.data != slow.data) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            if (fast.data == slow.data) {
                return slow;
            }
        }
        return null;
    }
}
