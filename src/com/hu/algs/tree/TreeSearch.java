package com.hu.algs.tree;

import com.hu.algs.linkedlist.Node;
import com.sun.source.tree.Tree;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class TreeSearch {

    /**
     * 递归的方法实现 前序遍历，中序遍历，后序遍历
     * 用 print 来表示正在确认某节点
     */
    public static void preOrderSearch(TreeNode head) {
        if (head == null)
            return;
        System.out.println("node.value = " + head.value);
        preOrderSearch(head.left);
        preOrderSearch(head.right);
    }

    public static void midOrderSearch(TreeNode head) {
        if (head == null)
            return;
        midOrderSearch(head.left);
        System.out.println("node.value = " + head.value);
        midOrderSearch(head.right);
    }

    public static void posOrderSearch(TreeNode head) {
        if (head == null)
            return;
        posOrderSearch(head.left);
        posOrderSearch(head.right);
        System.out.println("node.value = " + head.value);
    }

    /**
     * 用非递归的方法实现前序遍历
     */
    public static void preOrderUnrecur(TreeNode head) {
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(head);
        while (!treeNodes.isEmpty()) {
            head = treeNodes.pop();
            System.out.println("node.value = " + head.value);
            if (head.right != null)
                treeNodes.push(head.right);
            if (head.left != null)
                treeNodes.push(head.left);
        }
    }

    /**
     * 非递归的中序遍历
     * 主要做法就是：
     * 1. 持续使 node = node.left
     * 2. 直至 node == null，返回上一个node（并打印）
     * 3. 然后 node = node.right,继续第 1 步
     */
    public static void midOrderUnrecur(TreeNode node) {
        Stack<TreeNode> nodes = new Stack<>();

        while (node != null || !nodes.isEmpty()) {
            if (node != null) {
                nodes.push(node);
                node = node.left;
            } else {
                node = nodes.pop();
                System.out.println("node.value = " + node.value);
                node = node.right;
            }
        }
    }

    /**
     * 非递归的后序遍历
     */

    public static void posOrderUnrecur(TreeNode node) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(node);

        while (node != null || !nodes.isEmpty()) {
            if (node.left != null) {
                node = node.left;
            } else {
                if (node.right != null)
                    node = node.right;
                else {
                    System.out.println("node.value = " + node.value);
                    node = nodes.pop();
                    continue;
                }
            }
            nodes.push(node);
        }

    }


    // 根据先序遍历和中序遍历 重构出二叉树
    public TreeNode preMidToTree(int[] preOrder, int[] midOrder) {
        if (preOrder == null)
            return null;
        TreeNode head = null;
        List<Integer> preList = toList(preOrder);
        List<Integer> midLIst = toList(midOrder);

        head = preIn(preList, 0, preList.size() - 1, midLIst, 0, midLIst.size() - 1);


        return head;
    }

    /**
     * 重点就是--
     * 1. 先序遍历的结果的第一个数一定是根【假设是 A
     * 2. 中序遍历的结果中，A的左边一定是左子树，A的右边一定是右子树
     * 于是可以以此类推，不断在子树中找到子树的根节点
     */
    public TreeNode preIn(List<Integer> preList, int firstPre, int childLength,
                          List<Integer> midList, int firstMid, int lastMid) {

        if (childLength == 0)
            return null;
        int nodeValue = preList.get(firstPre);
        TreeNode node = new TreeNode(nodeValue);
        int midPos = midList.indexOf(nodeValue);

        int leftChildLength = midPos - firstMid;
        int rightChildLength = lastMid - midPos;

        node.left = preIn(preList, firstPre + 1, leftChildLength,
                midList, firstMid, midPos - 1);
        node.right = preIn(preList, firstPre + leftChildLength + 1, rightChildLength,
                midList, midPos + 1, midPos + rightChildLength);

        return node;
    }

    public List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int ele : array) {
            list.add(ele);
        }
        return list;
    }
}


