package LinkedList;
/*
*  输出结果有问题,应该是链表的创建出现了问题？？？？？
*
* */
public class GetIntersectionNode160 {
    public static void main(String[] args) {
//        listA = [4,1,8,4,5]
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        System.out.println(node1.next);
//        System.out.println(node4.next);

//      listB = [5,0,1,8,4,5]
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(4);
//        ListNode node9 = new ListNode(8);
//        ListNode node10 = new ListNode(4);
//        ListNode node11 = new ListNode(5);
        node6.next = node7;
        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
//        node10.next = node11;
        ListNode intersectionNode = getIntersectionNode(node1, node6);
        System.out.println(intersectionNode);
    }

    //
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode aPointer = headA;
        ListNode bPointer = headB;
        while (aPointer != bPointer) {
            aPointer = aPointer == null ? headB : aPointer.next;
            bPointer = bPointer == null ? headA : bPointer.next;
        }
        return aPointer;
    }

    //   Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
