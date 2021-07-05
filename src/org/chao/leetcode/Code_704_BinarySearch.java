package org.chao.leetcode;

/**
 * 二分查找
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/binary-search
 */
public class Code_704_BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid;
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
        int[] arr = {1,3,5,6,8,9};
        System.out.println(search(arr, 5));
    }
}
