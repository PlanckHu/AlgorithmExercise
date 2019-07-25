package com.hu.algs;

import java.util.Stack;

/**
 * 将栈从顶到底由从大到小的顺序排序
 * 只允许申请一个栈，不能申请额外的数据结构
 */
public class StackSort {

    /**
     * 其实相当于插入排序
     * 先假设之前的 assist 是已经经过排序了的，于是只要找到正确的位置放入就好了
     * 该函数的主要作用是 判断 target 能否放在 assist 栈顶
     * 所以一个递归里有两件任务
     * 1. 判断目标 target 和 栈顶 peek()的大小，从而判断是否要在此处放入 target
     * 2. 如果还不能放入(peek() < target),那么继续往下找，直到能放在 assist[0,n]的栈顶
     */
    private static void putRightPosition(Stack<Integer> assist, Integer target) {
        if (assist.isEmpty() || target <= assist.peek())
            assist.push(target);
        else {
            Integer temp = assist.pop();
            putRightPosition(assist, target);
            assist.push(temp);
        }
    }

    // 用上了递归
    public static void Sort1(Stack<Integer> stack) {
        Stack<Integer> assistStack = new Stack<>();
        while (!stack.isEmpty()) {
            putRightPosition(assistStack, stack.pop());
        }

        while (!assistStack.isEmpty()) {
            stack.push(assistStack.pop());
        }
    }

    //不用递归
    public static void Sort2(Stack<Integer> stack) {
        Stack<Integer> assistStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            while (!assistStack.isEmpty() && temp <= assistStack.peek()) {
                stack.push(assistStack.pop());
            }
            assistStack.push(temp);
        }

        while (!assistStack.isEmpty()) {
            stack.push(assistStack.pop());
        }
    }
}
