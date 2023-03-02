package offersword.q6reversePrintLinkNode;

/**
 * @author yancy0109
 */

public class Solution1 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // 记录链表长度
        int len = 1;
        ListNode nodeIndex = head;
        while (nodeIndex.next != null) {
            len++;
            nodeIndex = nodeIndex.next;

        }
        int[] result = new int[len];
        nodeIndex = head;
        // 从头到位填充数组
        for (int pointIndex = len; pointIndex > 0; pointIndex--) {
            result[pointIndex - 1] = nodeIndex.val;
            nodeIndex = nodeIndex.next;
        }
        return result;
    }

    // Acwing version
    public int[] printListReversingly(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // 记录链表长度
        int len = 1;
        ListNode nodeIndex = head;
        while (nodeIndex.next != null) {
            len++;
            nodeIndex = nodeIndex.next;

        }
        int[] result = new int[len];
        nodeIndex = head;
        // 从头到位填充数组
        for (int pointIndex = len; pointIndex > 0; pointIndex--) {
            result[pointIndex - 1] = nodeIndex.val;
            nodeIndex = nodeIndex.next;
        }
        return result;
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