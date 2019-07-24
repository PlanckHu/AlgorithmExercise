package com.hu.algs;

import java.util.Stack;

/**
 * 设计一个push poll getMin时间复杂度都是 O(1)的特殊栈
 */
public class SpecialStack {
    private static SpecialStack instance;
    private Stack<Integer> stack1;
    private Stack<Integer> minItems;

    private SpecialStack() {
        stack1 = new Stack<>();
        minItems = new Stack<>();
    }

    public static SpecialStack getInstance() {
        if (instance == null)
            instance = new SpecialStack();
        return instance;
    }

    public void push(Integer item) {
        if (minItems.size() == 0) {
            minItems.push(item);
        } else {
            Integer last = minItems.peek();
            minItems.push((last < item) ? last : item);
        }
        stack1.push(item);
    }

    public Integer pop() {
        if (stack1.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        minItems.pop();
        return stack1.pop();
    }

    public Integer getMinItem() {
        if (minItems.isEmpty()){
            throw new RuntimeException("Stack is Empty!");
        }
        return minItems.peek();
    }
}
