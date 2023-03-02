package offersword.q6reversePrintLinkNode;

import java.util.ArrayList;

/**
 * @author yancy0109
 */
public class Solution2 {

    private ArrayList<Integer> list = new ArrayList();

    // 回溯法
    public int[] reversePrint(ListNode head) {
        if (head != null) {
            recur(head);
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void recur(ListNode node) {
        if (node.next != null) {
            recur(node.next);
        }
        // 放入当前节点
        list.add(node.val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        int[] print = new Solution1().reversePrint(listNode);
        for (int i : print) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
