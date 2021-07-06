package org.chao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈问题
 */
public class Code006_MonotonicStack {
    /**
     * 给定一个可能含有重复值的数组arr，i位置的数一定存在如下两个信息
     * 1）arr[i]的左侧离i最近并且小于(或者大于)arr[i]的数在哪？
     * 2）arr[i]的右侧离i最近并且小于(或者大于)arr[i]的数在哪？
     * 如果想得到arr中所有位置的两个信息，怎么能让得到信息的过程尽量快。
     */
    public static int[][] getMinAddress(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> integers = stack.pop();
                // 获取左侧小于当前值的最近一个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer integer : integers) {
                    res[integer][0] = leftLessIndex;
                    res[integer][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                stack.push(li);
            }
        }
        // 处理栈中剩余值
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer integer : pop) {
                res[integer][0] = leftLessIndex;
                res[integer][1] = -1;
            }
        }
        return res;
    }

    public static int max1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int minNum = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    minNum = Math.min(minNum, arr[k]);
                }
                max = Math.max(max, minNum * sum);
            }
        }
        return max;
    }

    /**
     * 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
     * 一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
     * 那么所有子数组中，这个值最大是多少？
     */
    public static int max2(int[] arr) {
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }

    public static int[] gerenareRondomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

//    public static void main(String[] args) {
//        int testTimes = 2000000;
//        System.out.println("test begin");
//        for (int i = 0; i < testTimes; i++) {
//            int[] arr = gerenareRondomArray();
//            if (max1(arr) != max2(arr)) {
//                System.out.println("FUCK!");
//                break;
//            }
//        }
//        System.out.println("test finish");
//    }

    /**
     * 求最大方格数
     *
     * @param arr
     * @return
     */
    public static int maxValue(int[] arr) {
        Stack<List<Integer>> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer integer : pop) {
                    if (leftLessIndex == -1){
                        max = Math.max(max, arr[i] * (i + 1));
                    }else{
                        max = Math.max(max, Math.max(arr[leftLessIndex] * (integer - leftLessIndex + 1), arr[i] * (i - integer + 1)));
                    }
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()){
            List<Integer> pop = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() -1);
            for (Integer integer : pop) {
                if (leftLessIndex == -1) {
                    max = Math.max(max, arr[integer] * arr.length);
                } else {
                    max = Math.max(max, arr[integer] * (arr.length - integer + 1));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,2,9,7,8,7,8,2,2,2,2,2,2,2,2,2,2,22,2,2};
        System.out.println(maxValue(arr));
    }



}
