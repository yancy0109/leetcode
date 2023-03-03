package offersword.q09CreateQueueWithStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode
 * Acwing
 * 20 用两个栈实现队列
 * @author yancy0109
 */
public class MyQueue {

    private Deque<Integer> inputStack;
    private Deque<Integer> storeStack;

    public MyQueue() {
        inputStack = new LinkedList<>();
        storeStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        int restore = -1;
        if (inputStack.isEmpty()) {
            return restore;
        }
        while (!inputStack.isEmpty()) {
            storeStack.push(inputStack.pop());
        }
        restore = storeStack.pop();
        while (!storeStack.isEmpty()) {
            inputStack.push(storeStack.pop());
        }
        return restore;
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.appendTail(3);
        obj.appendTail(2);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

}
