package LinkedList;

public class CycleLinkedList141 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        boolean res = hasCycle(node1);
        System.out.println(res);
    }
    //双指针方法
    public static boolean hasCycle(ListNode head){
        if (head == null){return false;}
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next ==  null){return false;}
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    // Definition for singly-linked list.
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

}
