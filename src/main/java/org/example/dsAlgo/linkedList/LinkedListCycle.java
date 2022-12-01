package org.example.dsAlgo.linkedList;

public class LinkedListCycle {

    /*
       If there exists any cycle in the linked list then the two pointers (slow and fast)
       are going to conicide after x iterations
       If there doesn't exist any cycle then fast pointer will end up as null
     */
    public boolean hasCycle(ListNode head) {
        boolean isCyclePresent = false;
        ListNode fast = head, slow = head;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            if (fast == slow) {
                isCyclePresent = true;
                break;
            }
            slow = slow.next;
        }
        return isCyclePresent;
    }
}
