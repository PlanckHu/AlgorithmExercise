package com.hu.algs.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ListOperator {
    public ListOperator() {
    }

    /**
     * 1. 输出两个有序链表的公共部分
     * 有序：从小到大连接
     */
    public List<Node> outputCommonNode(Node head1, Node head2) {
        List<Node> commonList = new ArrayList<>();

        while (head1 != null && head2 != null) {
            if (head1.value < head2.value)
                head1 = head1.next;
            else if (head1.value > head2.value)
                head2 = head2.next;
            else {
                commonList.add(head1);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return commonList;
    }

    /**
     * 2. 分别实现两个函数，分别删除单/双向链表的倒数第 k 个 node
     */
    public Node removeLastKthNode(Node head, int k) {
        if (head == null)
            return null;

        Node pt = head;
        while (pt != null) {
            pt = pt.next;
            k--;
        }
        if (k == 0)
            head = head.next;
        else if (k < 0) {
            pt = head;
            while (k < 0) {
                pt = pt.next;
                k++;
            }
            pt.next = pt.next.next;
        }
        return head;
    }

    public DoubleNode removeLastKthDoubleNode(DoubleNode head, int k) {
        if (head == null || k < 1)
            return null;
        DoubleNode cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }

        if (k == 0) {
            head = head.next;
            head.last = null;
        }else if (k < 0){
            cur = head;
            while (k<0){
                cur = cur.next;
                k++;
            }
            DoubleNode temp = cur.next;
            cur.next = temp.next;
            if (temp.next!=null)
                temp.next.last = cur;
        }

        return head;
    }
}
