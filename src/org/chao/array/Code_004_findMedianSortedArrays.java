package org.chao.array;

/**
 * 寻找中位数
 */
public class Code_004_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length; int l2 = nums2.length;
        int totalLength = l1 + l2;
        if (totalLength % 2 == 1){
            return getKthElement(nums1, nums2, totalLength / 2 + 1);
        }else {
            return (getKthElement(nums1, nums2, totalLength / 2) + getKthElement(nums1, nums2, totalLength / 2 + 1) ) / 2.0;
        }
    }
    public int getKthElement(int[] nums1, int[] nums2, int k){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int index1 = 0;
        int index2 = 0;

        while (true){
            if (index1 == l1){
                return nums2[index2 + k - 1];
            }

            if (index2 == l2){
                return nums1[index1 + k - 1];
            }

            if (k == 1){
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, l1) - 1;
            int newIndex2 = Math.min(index2 + half, l2) - 1;

            if (nums1[newIndex1] <= nums2[newIndex2]){
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }else {
                k -=( newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }


        }


    }


















}
