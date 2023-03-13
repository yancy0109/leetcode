package offersword.q35reverseLinkList_acwing;

/**
 * 35. 反转链表
 * acwing
 * 递归
 * @author yancy0109
 */
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        // 指向空 或 没有下一个元素
        if (head == null || head.next == null) {
            return head;
        }
        // 将剩余链表进行反转
        ListNode res = reverseList(head.next);
        // 将当前节点的下一节点指向当前节点
        head.next.next = head;
        head.next = null;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Solution3().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))));
    }
}
