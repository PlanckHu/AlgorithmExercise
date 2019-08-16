package com.hu.algs;

public class Fibonacci {

    //获得斐波那契数列的第n项,递归方法的时间复杂度为2的N次方
    public static int getN(int n) {
        if (n < 1)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else return getN(n - 1) + getN(n - 2);
    }

    //时间复杂度为 O(N)
    public static int getFN(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int temp = 1;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            int pre2 = temp;
            temp = temp + pre;
            pre = pre2;
        }
        return temp;
    }

    /**
     * 给定台阶数N，一次跨1/2级台阶，返回有多少种走法
     */
    public static int getStairSteps(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return n;
        else return getStairSteps(n - 1) + getStairSteps(n - 2);
    }

    /**
     * 农场初始有 1 只牛
     * 牛：不会死，有 3 年成熟期，每年生一只
     * 求第 N 年的牛数量
     * 其实就是上一年的牛数量+新生的牛数量
     * 新生的牛数量 = 三年前的牛数量
     */
    public static int getCows(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return n ;
        else
            return getCows(n - 1) + getCows(n - 3);
    }
}
