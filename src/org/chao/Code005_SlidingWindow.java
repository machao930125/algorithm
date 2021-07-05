package org.chao;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口法：
 */
public class Code005_SlidingWindow {
    /**
     * 固定窗口内数组最大值，将组成最大值的数据返回
     * 输入：arr = [4,3,5,4,3,3,6,7], W = 3
     * 返回：[5,5,5,4,6,7]
     */
    public static int[] maxValueWithLength(int[] arr, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] rtn = new int[arr.length - k + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                rtn[index++] = arr[queue.peekFirst()];
            }
        }
        return rtn;
    }

    /**
     * 给定一个整型数组arr，和一个整数num
     * 某个arr中的子数组sub，如果想达标，必须满足：
     * sub中最大值 – sub中最小值 <= num，
     * 返回arr中达标子数组的数量
     */
    public static int getNum(int arr[], int value) {
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        int right = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            while (right < arr.length) {
                while (!max.isEmpty() && arr[right] >= arr[max.peekFirst()]) {
                    max.pollFirst();
                }
                max.addLast(right);
                while (!min.isEmpty() && arr[right] <= arr[min.peekFirst()]) {
                    min.pollFirst();
                }
                min.addLast(right);
                if (arr[max.peekFirst()] - arr[min.peekFirst()] > value) {
                    break;
                }
                right++;
            }
            res += right - i;
            if (max.peekFirst() == i) {
                max.pollFirst();
            }
            if (min.peekFirst() == i) {
                min.pollFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(Arrays.toString(maxValueWithLength(arr, 3)));
        System.out.println(getNum(arr, 1));
    }

}
