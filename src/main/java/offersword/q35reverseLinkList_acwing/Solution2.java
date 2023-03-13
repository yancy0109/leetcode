package offersword.q35reverseLinkList_acwing;

/**
 * 35. 反转链表
 * acwing
 * 迭代
 * @author yancy0109
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = null;
        ListNode index = head;
        ListNode next = head.next;
        while (next != null) {
            // 让当前指针指向上一个元素
            index.next = lastNode;
            lastNode = index;
            // 切换指向下一个元素
            index = next;
            next = next.next;
        }
        index.next = lastNode;
        return index;
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}
