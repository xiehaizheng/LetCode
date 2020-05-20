package LinkedList;

public class SingleLinkedListDemo {
    // 定义单链表节点
    public static class ListNode {
        public int val;
        public ListNode next;

        // 构造器
        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
    public static class SingleLinkedList{
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
                System.out.println(temp);
                //将temp后移， 一定小心
                temp = temp.next;
            }
        }
    }


}
