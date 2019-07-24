package com.hu.algs;

import java.util.Stack;

/**
 * 仅用 递归 和 栈操作来逆序一个栈，不增加别的数据结构
 */
public class StackReversion {
    public static Object popFirstElement(Stack<Object> objectStack) {
        Object last = objectStack.pop();
        if (objectStack.isEmpty())
            //表示这个时候stack中剩下唯一一个object
            return last;
        else {
            //获得第一个object，并将这个object继续向前传递(return)
            Object pre = popFirstElement(objectStack);
            // 不是第一个的object重新存回stack中
            objectStack.push(last);
            return pre;
        }
    }

    public static void reverse(Stack<Object> objectStack) {
        if (objectStack.isEmpty())
            return;
        //下面相当于取出stack里的第一个object，暂存，然后继续向下取
        Object lastEle = popFirstElement(objectStack);
        reverse(objectStack);
        // 知道取到最后一个，然后开始从后向前一个个往stack里push
        // 是利用了递归的回调和暂存的机制来改变顺序的
        objectStack.push(lastEle);
    }
}
