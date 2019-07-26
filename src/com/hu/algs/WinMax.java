package com.hu.algs;

import java.util.LinkedList;

/**
 * array[n]里放大小为w的窗口，求窗口里的最大值
 * 比如：
 * array[5]={1,2,3,2,5,6}, w = 3
 * 对应可以有4个窗口，{1,2,3},{2,3,2},{3,2,5},{2,5,6}
 * 最大值对应位{3,3,5,6}
 */
public class WinMax {

    public static int[] getMaxWin(int[] array, int width) {
        if (array == null || array.length < width)
            return null;

        int[] maxList = new int[array.length - width + 1];
        LinkedList<Integer> list = new LinkedList<>();

        /**
         * 实际原理就是：
         * 假设某个数字在位置n，将区间 [n-w,n+w]上的最大值记录在 list 上
         */
        for (int i = 0, pt = 0; i < array.length; i++) {
            while (!list.isEmpty() && array[list.peekLast()] <= array[i])
                list.pollLast();
            list.add(i);
            if (list.peekFirst() == i - width)
                list.pollFirst();
            if (i >= width - 1)
                maxList[pt++] = array[list.peekFirst()];
        }
        return maxList;
    }
}
