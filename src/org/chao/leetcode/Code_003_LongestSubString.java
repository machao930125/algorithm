package org.chao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口
 */
public class Code_003_LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            while (set.contains(chars[i])){
                set.remove(chars[left]);
                left ++;
            }
            set.add(chars[i]);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ajldasdasiiks"));
    }
}
