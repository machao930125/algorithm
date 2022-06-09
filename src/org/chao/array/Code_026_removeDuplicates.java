package org.chao.array;

/**
 * 删除有序数组重复数据
 */
public class Code_026_removeDuplicates {
    public int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j+ 1;
    }


























}
