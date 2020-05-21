package LinkedList;
/*
* 反转一个单链表。
  示例:
  输入: 1->2->3->4->5->NULL
  输出: 5->4->3->2->1->NULL
* */
public class ReverseList206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = reverseList(node1);
        System.out.println(listNode);
    }

    //    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return  val +
                    "-->" + next ;
        }
    }
//    迭代
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while (cur  != null){
            ListNode tempnext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempnext;
        }
        return prev;
    }
}
