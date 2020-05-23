package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1: 输入: 1->2  输出: false
 * 示例 2: 输入: 1->2->2->1 输出: true
 */
public class IsPalindrome234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;node2.next = node3;node3.next = node4;
        boolean palindrome = isPalindrome(node1);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(ListNode head){

        // 将链表存储到数组列表中
        ListNode cur = head;
        List<Integer> vals = new ArrayList<>();
        while (cur != null){
            vals.add(cur.val);
            cur = cur.next;
        }
        //使用双指针判断
        int len = vals.size();
        int m = 0;
        int k = len - 1;
        while (m<k){
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(m).equals(vals.get(k))){return false;}
            m++;
            k--;
        }
        return true;
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
            return  val + "-->" + next ;
        }
    }
}
