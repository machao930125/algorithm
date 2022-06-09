package org.chao.array;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Code_sort_912_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 3, 6, 7, 2, 8, 2, 4, 10, 12, 11};
        new Code_sort_912_BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortArray(int[] nums){
        bubbleSort(nums);
        return nums;
    }

    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
