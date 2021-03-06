package org.chao.base;

/**
 * 二分查找
 */
public class BinarySearch {

    // 通过左中右指针方式实现二分查找
    public static int binarySearch(int[] arr, int target) {
        // 定义左、右、中三个指针
        int left = 0;
        int right = arr.length;
        int mid;
        // 循环条件左指针小于右指针
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 7, 9, 12, 14, 17, 24, 37, 57};
        int i = binarySearch(arr, 37);
        System.out.println(i);
    }
}
