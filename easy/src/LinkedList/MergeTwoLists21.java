package LinkedList;

/*
* 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* 输入：1->2->4, 1->3->4
  输出：1->1->2->3->4->4
  来源：leetcode

* */
public class MergeTwoLists21 {
    public static void main(String[] args) {
        //创建两个单链表 singleLinkedList1 和 singleLinkedList2
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(node1);
        singleLinkedList1.add(node2);
        singleLinkedList1.add(node3);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(node4);
        singleLinkedList2.add(node5);
        singleLinkedList2.add(node6);
        ListNode res = mergeTwoLists(singleLinkedList1.head.next, singleLinkedList2.head.next);
        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.add(res);
        singleLinkedList3.list();
    }

    //    合并两个有序链表(递归)
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){ return l2;}
        else if(l2 == null){return l1;}
        else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //    定义单链表节点
    static class ListNode {
        public int val;
        public ListNode next;

        // 构造器
        public ListNode(int val) {
            this.val = val;
        }


    }

    static class SingleLinkedList {
        //定义SingleLinkedList 管理我们的英雄
        private ListNode head = new ListNode(0);

        public ListNode getHead() {
            return head;
        }


        //添加节点到单向链表 1. 找到当前链表的最后节点 2. 将最后这个节点的next 指向 新的节点
        public void add(ListNode listNode) {
            //因为head节点不能动，因此我们需要一个辅助遍历 temp
            ListNode temp = head;
            //遍历链表，找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后,将最后这个节点的next 指向 新的节点
            temp.next = listNode;
        }

        //删除节点1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点,
        // 2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
        public void del(int val) {
            ListNode temp = head;
            boolean flag = false;// 标志是否找到待删除节点的
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.val == val) {
                    //找到的待删除节点的前一个节点temp
                    flag = true;
                    break;
                }
                temp = temp.next;//temp后移，遍历
            }
            if (flag) {//找到可以删除
                temp.next = temp.next.next;
            } else {
                System.out.println("要删除的" + val + "节点不存在");
            }
        }

        //遍历显示链表
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空。");
                return;
            }
            //因为头节点，不能动，因此我们需要一个辅助变量来遍历
            ListNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                //输出节点的信息
                System.out.println(temp.val);
                //将temp后移， 一定小心
                temp = temp.next;
            }
        }
    }

}
