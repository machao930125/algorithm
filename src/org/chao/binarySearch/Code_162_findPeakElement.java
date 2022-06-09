package org.chao.binarySearch;

/**
 * 寻找峰值
 */
public class Code_162_findPeakElement {
    public int findPeakElement(int[] nums){
        int n = nums.length;
        if (n == 0){
            return -1;
        }
        if (n == 1){
            return 0;
        }

        int left = 0; int right = n -1;

        while (left <= right){

            int mid = left + ((right - left) >> 1);
            if ((mid - 1 < 0 || nums[mid - 1] < nums[mid]) && (mid + 1 >= n || nums[mid] > nums[mid + 1])){
                return mid;
            }

            if (mid - 1 < 0 || nums[mid -1] < nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return -1;
    }
}
