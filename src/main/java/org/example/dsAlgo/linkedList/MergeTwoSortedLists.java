package org.example.dsAlgo.linkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode result = null, head = null, temp;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            if (head == null) {
                result = new ListNode(temp.val);
                head = result;
            } else {
                head.next = new ListNode(temp.val);
                head = head.next;
            }
        }

        // For unequal linked list checks
        while (list1 != null) {
            head.next = new ListNode(list1.val);
            head = head.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            head.next = new ListNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }

        return result;
    }
}
