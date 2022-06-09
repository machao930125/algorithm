package org.chao.array;

/**
 * 合并两个有序数组
 */
public class Code_088_merge {
    public void merge(int[] nums1, int n, int[] nums2, int m){
        int index = n + m - 1;
        n--;
        m--;

        while (n >= 0 || m >= 0){
            if (n == -1){
                nums1[index--] = nums2[m--];
            }else if (m == -1){
                nums1[index--] = nums1[n--];
            }else if (nums1[n] > nums2[m]){
                nums1[index--] = nums1[n--];
            }else {
                nums1[index--] = nums2[m--];
            }
        }
    }




























}
