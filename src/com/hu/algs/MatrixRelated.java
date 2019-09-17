package com.hu.algs;

public class MatrixRelated {

    /**
     * 计算数组中子排列的最大和
     * 比如 [1,-2,3,5,-2,6,-1] 中 [3,5,-2,6]有最大的累加和 12
     */
    public int maxSum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = (cur < 0) ? 0 : cur;
        }
        return max;
    }

    /**
     * 计算矩阵中的最大累加和
     * 比如
     * | -90  48  78|
     * |  64 -40  64|
     * | -81  -7  66|
     * 中有
     * | 48  78|
     * |-40  64|
     * | -7  66|
     * 中有最大累加和 209
     * 这个需要 O(n^3)的时间复杂度
     */
    public int maxSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] s = new int[arr[0].length];
            for (int j = i; j < arr.length; j++) {
                cur = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += arr[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

    /**
     * 计算数组中的最大积
     */
    public double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    /**
     * 二分法查找数组中的极小值（局部最小值）
     */
    public int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        if (arr.length == 1 || arr[0] < arr[1])
            return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2])
            return arr.length - 1;
        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1])
                right = mid - 1;
            else if (arr[mid] > arr[mid + 1])
                left = mid + 1;
            else return mid;
        }
        return left;
    }

}
