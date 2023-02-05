package leetcodeHot100.q2TwoNumberAdd;


/**
 * @author yancy0109
 */
public class App {

    // 非空链表
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        // 返回指针
        ListNode returnIndex = resultNode;
        // 存储相加值
        int addNum = 0;
        // 存储进位值
        int addNext = 0;

        // 循环判断进位
        while (l1 != null || l2 != null) {
            // 放在循环首部，代码更简洁复用，指针指向下一个元素
            resultNode.next = new ListNode();
            resultNode = resultNode.next;

            // 判断几种加法
            // 如果两个节点都还有剩余
            addNum = (l1!=null)&&(l2!=null)? l1.val+l2.val : addNum;
            // 如果l1还有剩余
            addNum = (l1!=null)&&(l2==null)? l1.val : addNum;
            //如果l2还有剩余
            addNum = (l1==null)&&(l2!=null)? l2.val : addNum;
            // 如果有进位
            if (addNext == 1) {
                addNum = addNum + addNext;
                addNext = 0;
            }
            if (addNum >= 10) {
                addNext = 1;
            }
            addNum = addNum%10;
            resultNode.val = addNum;
            // 重置Temp
            addNum = 0;

            // 指针指向下一个元素
            if (l1 != null && l1.next != null) {
                l1 = l1.next;
            } else {
                // 链表遍历至尾
                l1 = null;
            }
            if (l2 != null && l2.next != null) {
                l2 = l2.next;
            } else {
                // 链表遍历至尾
                l2 = null;
            }
        }
        // l1与l2都已遍历至队尾 && addNext = 1
        if (l1 == null && l2 == null && addNext == 1){
            resultNode.next = new ListNode();
            resultNode = resultNode.next;
            resultNode.val = addNext;
        }
        return returnIndex.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode listNode2 = new ListNode(5, null);
        ListNode node = addTwoNumbers(listNode1, listNode2);
        System.out.println(node.toString());
    }
}
