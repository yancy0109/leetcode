package offersword.q09CreateQueueWithStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode
 * 剑指offer
 * 09 用两个栈实现队列
 * @author yancy0109
 */
public class CQueue {

    // 压入
    private Deque<Integer> inStack;
    // 取出
    private Deque<Integer> outStack;

    public CQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // 输出栈不为空
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        if (inStack.isEmpty()) {
            // 不存在元素
            return -1;
        }
        // 将输入压入输出栈 此时输出栈顶为队列头节点
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        // 取出头节点
        return outStack.pop();
    }

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(3);
        obj.appendTail(2);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

}
