package org.example.dsAlgo.stacks;

import java.util.Stack;

public class QueueUsingTwoStacks {

    /*
     * Two Stacks: s1 & s2
     * NOTE: Popping elements from one stack and adding it to another stack,
     * it revereses all the elements present in the stack and the other stack now
     * behaves like a queue
     * enqueue: add element in s1
     * dequeue: if s2 is empty, then transfer all the elements from s1 to s2
     * now peek/pop elements from s2
     */
    public static class MyQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.add(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                transferAllElements(s1, s2);
            }
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()) {
                transferAllElements(s1, s2);
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.empty() && s2.empty();
        }

        private void transferAllElements(Stack<Integer> from, Stack<Integer> to) {
            while (!from.empty()) {
                to.add(from.pop());
            }
        }
    }
}
