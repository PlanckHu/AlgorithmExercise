package com.hu.algs;

import java.util.Stack;

/**
 * 由两个栈组成一个队列
 */
public class TwoStackList {
    private Stack<Object> stackPush;
    private Stack<Object> stackPop;

    public TwoStackList() {
        this.stackPop = new Stack<>();
        this.stackPush = new Stack<>();
    }

    public void add(Object object) {
        stackPush.push(object);
    }

    public Object pop() {
        if (!stackPop.isEmpty())
            return stackPop.pop();
        if (stackPush.isEmpty())
            throw new RuntimeException("List is Empty!");
        else {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }
    }

    /**
     * @return return the 1st element stored in this TwoStackList
     */
    public Object peek(){
        if (!stackPop.isEmpty())
            return stackPop.peek();
        if (stackPush.isEmpty())
            throw new RuntimeException("List is Empty!");
        else{
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }
}
