package org.example.dsAlgo.stacks;

import org.example.dsAlgo.stacks.QueueUsingTwoStacks.MyQueue;
import org.junit.jupiter.api.Test;

public class QueueUsingTwoStacksTest {
    
    @Test
    void test_MyQueue() {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.peek();
        q.pop();
        q.empty();
    }
}
