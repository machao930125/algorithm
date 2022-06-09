package org.chao.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Code_015_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }

            int thrid = nums.length - 1;
            int target = - nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }

                while (second < thrid && target < nums[second] + nums[thrid]){
                    thrid --;
                }

                if (second == thrid){
                    break;
                }

                if (target == nums[second] + nums[thrid]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[thrid]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }












}
