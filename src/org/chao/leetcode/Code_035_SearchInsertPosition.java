package org.chao.leetcode;

/**
 * 二分查找
 * <p>
 * 来源：力扣（LeetCode）
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class Code_035_SearchInsertPosition {

    public static int searchInsert(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        int mid ;
        while (left < right){
            mid = left + ((right - left) >> 1);

            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,2, 3,4, 7,9};
        System.out.println(searchInsert(arr, 10));
    }

}
