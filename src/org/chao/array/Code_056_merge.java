package org.chao.array;

import java.util.*;
/**
 * 合并区间
 */
public class Code_056_merge {
    public int[][] merge(int[][] intervals){
        if (intervals.length == 0){
            return new int[0][2];
        }

        Arrays.sort(intervals, (t1, t2) -> {return t1[0] - t2[0];});

        List<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(new int[]{interval[0], interval[1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }


    public int[][] merge1(int[][] intervals){
        if (intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, (t1, t2) -> {return t1[0] - t2[0];});

        List<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals){
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]){
                merged.add(new int[]{interval[0], interval[1]});
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }



























}
