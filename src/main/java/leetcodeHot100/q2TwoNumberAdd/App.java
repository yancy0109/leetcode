package leetcodeHot100.q2TwoNumberAdd;


/**
 * @author yancy0109
 */
public class App {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 存储结果
        ListNode result = new ListNode();
        // 暂存单个位运算
        int temp;
        temp = l1.val + l2.val;
        // 余数
        result.val = temp % 10;
        if (temp/10 != 0) {
            result.next = new ListNode();
            result = result.next;
        }
        // 当L1 OR L2 没有下一位 则不再次计算
        while (l1.next != null && l2.next != null) {
            // 上一位进位数
            temp = temp/10;
            temp = temp + l1.val + l2.val;
            // 当前余数
            result.val = temp%10;
            // 当前进位数
            if (temp%10 != 0) {
                result.next = new ListNode();
                // result指向更高位
                result = result.next;
            }
        }
        // 如果L1剩余
        if (l1.next != null) {

        }
        // 如果L2剩余
        if (l1.next != null) {

        }
        // L1和L2都为空
        if (l1.next == null && l2.next == null) {

        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(7, null)));

    }
}
