package offersword.q06reversePrintLinkNode;

import java.util.LinkedList;

/**
 * @author yancy0109
 */

public class Solution3 {

    // 辅助栈
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode index = head;
        while (index!=null) {
            stack.add(index.val);
            index = index.next;
        }
        int n = 0;
        int size = stack.size();
        int[] result = new int[size];
        while (n < size) {
            result[n] = stack.removeLast();
            n++;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        int[] print = new Solution3().reversePrint(listNode);
        for (int i : print) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}