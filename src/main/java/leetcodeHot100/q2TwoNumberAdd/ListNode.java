package leetcodeHot100.q2TwoNumberAdd;

/**
 * 链表
 */
public class ListNode {
    //当前节点元素值
    int val;
    //下一节点
    ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
