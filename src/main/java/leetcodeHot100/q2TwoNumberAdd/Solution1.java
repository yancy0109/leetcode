package leetcodeHot100.q2TwoNumberAdd;

import java.util.Objects;

public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //结果链表指针
        ListNode start = new ListNode();
        ListNode index = start;
        //暂存进位
        int nextAdd = 0;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)){
            int add = l1.val + l2.val + nextAdd;
            //如果nextAdd==1 说明相加时进位上一节点 恢复暂存位
            if (nextAdd == 1) {
                nextAdd=0;
            }
            //判断是否进位
            if (add >= 10){
                nextAdd++;
                add%=10;
            }
            index.next = new ListNode(add,new ListNode());
            //切换下一个节点
            index = index.next;
            l1=l1.next;
            l2=l2.next;
        }
        //如果L1还有剩余节点
        if (Objects.nonNull(l1)){
            while (Objects.nonNull(l1)){
                int add = nextAdd + l1.val;
                //如果nextAdd==1 说明相加时进位上一节点 恢复暂存位
                if (nextAdd == 1) {
                    nextAdd=0;
                }
                //判断是否进位
                if (add >= 10){
                    nextAdd++;
                    add%=10;
                }
                index.next = new ListNode(add,new ListNode());
                l1=l1.next;
                index=index.next;
            }
        }
        //如果L2还有剩余节点
        if (Objects.nonNull(l2)){
            while (Objects.nonNull(l2)){
                int add = nextAdd + l2.val;
                //如果nextAdd==1 说明相加时进位上一节点 恢复暂存位
                if (nextAdd == 1) {
                    nextAdd=0;
                }
                //判断是否进位
                if (add >= 10){
                    nextAdd++;
                    add%=10;
                }
                index.next = new ListNode(add,new ListNode());
                l2=l2.next;
                index=index.next;
            }
        }
        if (nextAdd == 1){
            index.next = new ListNode(nextAdd,new ListNode());
            index = index.next;
        }
        index.next = null;
        return start.next;
    }

    public static ListNode intsToListNode(int[] ints){
        int length = ints.length;
        ListNode listNode = new ListNode();
        ListNode index = listNode;
        //链表指针位置
        int i;
        for (i = 0; i < length-1; i++){
            index.setVal(ints[i]);
            index.setNext(new ListNode());
            index = index.getNext();
        }
        //给链表最后节点赋值
        index.setVal(ints[i]);
        index.setNext(null);
        return listNode;
    }
    public static void main(String[] args) {
//        int[] ints1 = {2,4,3,5,5};
        int[] ints1 = {9,9,9};
//        int[] ints2 = {5,6,4};
        int[] ints2 = {1};
        ListNode l1 = intsToListNode(ints1);
        ListNode l2 = intsToListNode(ints2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(new Solution1().addTwoNumbers(l1,l2));
    }

}
