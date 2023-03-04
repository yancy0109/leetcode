package offersword.q09CreateQueueWithStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode
 * Acwing
 * 20 用两个栈实现队列
 * @author yancy0109
 */
class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        if (inStack.isEmpty()) {
            return -1;
        }
        copy(inStack, outStack);
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        if (inStack.isEmpty()) {
            return -1;
        }
        copy(inStack, outStack);
        return outStack.peek();
    }


    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            return true;
        }
        return false;
    }

    void copy(Deque inStack, Deque outStack){
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
