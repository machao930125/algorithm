package org.chao.array;

import java.util.Random;

/**
 * 快排
 */
public class Code_sort_912_QuickSort {
    public int[] sortArray(int[] nums){
        randomQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomQuickSort(int[] nums, int left, int right){
        if (left < right){
            int random = random(nums, left, right);
            randomQuickSort(nums, left, random - 1);
            randomQuickSort(nums, random + 1, right);
        }
    }

    public int random(int[] nums, int left, int right){
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, random, right);
        return partion(nums, left, right);
    }

    public int partion(int[] nums, int left, int right){
        int pivot = nums[right];
        int l = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot){
                swap(nums, l, i);
                l ++;
            }
        }
        swap(nums, l + 1, right);
        return l + 1;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
