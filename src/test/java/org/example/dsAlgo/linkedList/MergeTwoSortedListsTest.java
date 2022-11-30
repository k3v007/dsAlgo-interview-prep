package org.example.dsAlgo.linkedList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTwoSortedListsTest {

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[0], new int[0], new int[0]),
                Arguments.of(new int[0], new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void test_mergeTwoLists1(int[] list1, int[] list2, int[] output) {
        ListNode listNode1 = createListNode(list1);
        ListNode listNode2 = createListNode(list2);
        ListNode expected = createListNode(output);

        ListNode actual = new MergeTwoSortedLists().mergeTwoLists(listNode1, listNode2);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    private ListNode createListNode(int[] list) {
        ListNode listNode = null, head = null;
        for (int i = 0; i < list.length; ++i) {
            if (head == null) {
                listNode = new ListNode(list[i]);
                head = listNode;
            } else {
                head.next = new ListNode(list[i]);
                head = head.next;
            }
        }
        return listNode;
    }
}
