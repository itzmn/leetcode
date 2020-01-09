package com.itzmn.leetcode;/*
 * @Author: zhangmengnan
 * @Date 19:13 2019/11/11
 * @Description //TODO
 *
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

设计方案:
1. 根据链表节点初始化两个数
2. 遍历两个链表，按位置相加，保留进位
3. 如果没有数据了，就补0
4. 将数据变成链表
 */


public class let_2_TwoNumberAdd {

    public static void main(String[] args) {

        let_2_TwoNumberAdd add = new let_2_TwoNumberAdd();
        ListNode node = add.numToListNode(5);
        add.printlist(node);

        ListNode listNode = add.numToListNode(5);
        add.printlist(listNode);

        ListNode val = add.addTwoNumbers(node, listNode);
        add.printlist(val);

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tmpHead = null;

        int add = 0;
        boolean first = true;
        while (l1 != null && l2 != null){

            int f = l1.val + l2.val + add;
            add = f / 10;
            int value = f % 10;

            ListNode node = new ListNode(value);
            if (first){
                head = node;
                first = false;
            }else {
                tmpHead.next = node;
            }
            tmpHead = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int f = l1.val + add;
            add = f / 10;
            int value = f % 10;

            ListNode node = new ListNode(value);
            tmpHead.next = node;
            tmpHead = node;
            l1 = l1.next;
        }

        while (l2 != null){
            int f = l2.val + add;
            add = f / 10;
            int value = f % 10;

            ListNode node = new ListNode(value);
            tmpHead.next = node;
            tmpHead = node;
            l2 = l2.next;
        }

        if (add!=0){
            ListNode node = new ListNode(add);
            tmpHead.next = node;
        }

        return head;
    }

    public ListNode numToListNode(int num){
        ListNode head = null;
        ListNode tmpHead = null;

        int i1 = num % 10;
        ListNode node = new ListNode(i1);
        head = node;
        tmpHead = node;
        while ((num = num / 10) != 0){

            int v = num % 10;
            ListNode node1 = new ListNode(v);
            tmpHead.next = node1;
            tmpHead = node1;
        }
        return head;
    }
    public void printlist(ListNode node){
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
