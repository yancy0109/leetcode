package offersword.q35reverseLinkList_acwing;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 35. 反转链表
 * acwing
 * 栈
 * @author yancy0109
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 存入栈中
        Deque<ListNode> deque = new LinkedList<>();
        deque.push(head);
        while (head.next != null) {
            deque.push(head.next);
            head = head.next;
        }
        head = deque.pop();
        ListNode res = head;
        while (!deque.isEmpty()) {
            head.next = deque.pop();
            head = head.next;
        }
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}
