package org.chao.array;

/**
 * 堆排序
 */
public class Code_sort_912_HeapSort {
    public int[] sortArray(int[] nums){
        heapSort(nums);
        return nums;
    }


    
    public void heapSort(int[] nums){
        // 创建大顶堆
        int start = nums.length / 2 - 1;
        for (int i = start; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
        
        // 将最大值放在最后，一次调整堆
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            adjustHeap(nums, 0, i - 1);
        }
    }

    public void adjustHeap(int[] arr, int start, int end){
        while (true){
            int left_child = start * 2 + 1;

            if (left_child > end){
                break;
            }
            // 创建大顶堆
            if (left_child + 1 <= end && arr[left_child + 1] > arr[left_child]){
                left_child += 1;
            }

            if (arr[start] < arr[left_child]){
                swap(arr, start, left_child);
                // 继续调整
                start = left_child;
            }else {
                break;
            }
        }
    }
    
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 利用大顶堆获取最小的N个值
     *
     * @param arr
     * @param n
     */
    public void topN(int[] arr, int n) {
        // 创建大顶堆
        int start = n / 2 - 1;
        for (int i = start; i >= 0; i--) {
            adjustHeap(arr, i, n - 1);
        }
        // 一次比较大小，交换后进行堆调整
        for (int i = n; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                adjustHeap(arr, 0, n - 1);
            }
        }
    }
}
