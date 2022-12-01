package org.example.dsAlgo.linkedList;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LinkedListCycleTest {

    public static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(new int[] { 3, 2, 0, -4 }, 1, true),
                Arguments.of(new int[] { 1, 2 }, 0, true),
                Arguments.of(new int[] { 1 }, -1, false));
    }

    @ParameterizedTest(name = "Inputs: head={0} :: Output: {2}")
    @MethodSource("parametersProvider")
    void test_hasCycle(int[] head, int pos, boolean expected) {
        ListNode listNode = createListNode(head, pos);
        boolean actual = new LinkedListCycle().hasCycle(listNode);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private ListNode createListNode(int[] head, int pos) {
        ListNode listNode = null, temp = null, joint = null;
        for (int i = 0; i < head.length; i++) {
            if (listNode == null) {
                listNode = new ListNode(head[i]);
                temp = listNode;
            } else {
                temp.next = new ListNode(head[i]);
                temp = temp.next;
            }
            if (i == pos) {
                joint = temp;
            }
        }
        temp.next = joint;
        return listNode;
    }
}
